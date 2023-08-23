package com.keralty.rule.engine.service;


import com.keralty.rule.engine.dto.reglasCompania.ReglasCompaniaDTO;
import com.keralty.rule.engine.dto.reglasCompania.ReglasCompaniaResultDTO;
import com.keralty.rule.engine.exception.handler.FacadeException;
import com.keralty.rule.engine.facade.ReglasCompaniaFacade;
import org.jboss.resteasy.reactive.RestResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static com.keralty.rule.engine.mediaType.JsonMediaType.APPLICATION_JSON;

@Path("/reglasCompania")
public class ReglasCompaniaService {

    private final ReglasCompaniaFacade reglasCompaniaFacade;

    public ReglasCompaniaService(ReglasCompaniaFacade reglasCompaniaFacade){this.reglasCompaniaFacade = reglasCompaniaFacade;}

    /**
     * Calculate associated UPI given medicalCenterName and patientLocation
     *@param company unique company code
     * @return the reglas Compania associated with the code {@link ReglasCompaniaDTO}
     */
    @GET
    @Produces(APPLICATION_JSON)
    public RestResponse<ReglasCompaniaResultDTO> getReglasAseguradora(@QueryParam("company") String company) throws FacadeException {
        return RestResponse.ResponseBuilder.ok(reglasCompaniaFacade.getCompanyRule(company)).build();
    }
}
