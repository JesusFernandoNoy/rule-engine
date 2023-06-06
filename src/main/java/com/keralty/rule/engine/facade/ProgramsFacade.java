package com.keralty.rule.engine.facade;


import com.keralty.rule.engine.config.program.Program;
import com.keralty.rule.engine.dto.program.CalculateVariablesProgramDTO;
import com.keralty.rule.engine.entity.request.ProgramVariablesRequest;
import com.keralty.rule.engine.entity.response.ProgramVariablesResponse;


import org.kie.api.runtime.KieSession;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;

@ApplicationScoped
public class ProgramsFacade {

    private final KieSession kieSession;

    public ProgramsFacade(@Program KieSession kieSession) {
        this.kieSession = kieSession;
    }

    /**
     * Get program variables given healthCareProgramID and patientType
     *
     * @param request Representation of healthCareProgramID and patientType
     *        {@link ProgramVariablesRequest}
     * @return Program variables represented on {@link ProgramVariablesResponse}
     */
    public ProgramVariablesResponse findProgramVariables(ProgramVariablesRequest request) {
        return executeRule(request);
    }

    public ProgramVariablesResponse executeRule(ProgramVariablesRequest request) {
        CalculateVariablesProgramDTO calculateVariablesProgramDTO = CalculateVariablesProgramDTO.builder().request(request).result(new ProgramVariablesResponse()).build();
        kieSession.insert(calculateVariablesProgramDTO);
        kieSession.fireAllRules();
        return calculateVariablesProgramDTO.getResult();
    }
}
