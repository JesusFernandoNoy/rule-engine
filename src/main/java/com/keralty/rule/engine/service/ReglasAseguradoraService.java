package com.keralty.rule.engine.service;


import com.keralty.rule.engine.dto.reglasAseguradora.ReglasAseguradoraResultDTO;
import com.keralty.rule.engine.exception.handler.FacadeException;
import com.keralty.rule.engine.facade.ReglasAseguradoraFacade;
import org.jboss.resteasy.reactive.RestResponse;
import com.keralty.rule.engine.dto.reglasAseguradora.ReglasAseguradoraDTO;
import javax.ws.rs.*;

import static com.keralty.rule.engine.mediaType.JsonMediaType.APPLICATION_JSON;

@Path("/reglasAseguradora")
public class ReglasAseguradoraService {

    private final ReglasAseguradoraFacade reglasAseguradoraFacade;

    public ReglasAseguradoraService(ReglasAseguradoraFacade reglasAseguradoraFacade){this.reglasAseguradoraFacade = reglasAseguradoraFacade;}

    /**
     * Calculate associated UPI given medicalCenterName and patientLocation
     *@param company unique company code
     * @param aseguradoraID unique insurance code
     * @return the reglas Aseguradora associated with the code {@link ReglasAseguradoraDTO}
     */
    @GET
    @Produces(APPLICATION_JSON)
    public RestResponse<ReglasAseguradoraResultDTO> getReglasAseguradora(@QueryParam("company") String company,@QueryParam("insuranceID") String aseguradoraID) throws FacadeException {
        return RestResponse.ResponseBuilder.ok(reglasAseguradoraFacade.getCompanyInsuranceRule(company,aseguradoraID)).build();
    }
}
