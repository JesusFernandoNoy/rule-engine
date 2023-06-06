package com.keralty.rule.engine.service;

import com.keralty.rule.engine.entity.request.ProgramVariablesRequest;
import com.keralty.rule.engine.entity.response.ProgramVariablesResponse;

import com.keralty.rule.engine.facade.ProgramsFacade;
import org.jboss.resteasy.reactive.RestResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/programs")
public class ProgramsService {
    private final ProgramsFacade programsFacade;

    public ProgramsService(ProgramsFacade programsFacade) {
        this.programsFacade = programsFacade;
    }

    /**
     * Get program variables given healthCareProgramID and patientType
     *
     * @param request Representation of healthCareProgramID and patientType
     *        {@link ProgramVariablesRequest}
     * @return Program variables represented on {@link ProgramVariablesResponse}
     */
    @POST
    @Path("/variables")
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<ProgramVariablesResponse> findProgramVariables(ProgramVariablesRequest request) {
        return RestResponse.ResponseBuilder.ok(programsFacade.findProgramVariables(request)).build();

    }

}
