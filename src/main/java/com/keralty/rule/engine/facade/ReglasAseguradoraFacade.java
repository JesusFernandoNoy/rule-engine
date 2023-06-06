package com.keralty.rule.engine.facade;

import com.keralty.rule.engine.config.reglasAseguradora.ReglasAseguradora;
import com.keralty.rule.engine.dto.reglasAseguradora.ReglasAseguradoraDTO;

import com.keralty.rule.engine.dto.reglasAseguradora.ReglasAseguradoraResultDTO;
import com.keralty.rule.engine.exception.handler.FacadeException;
import org.kie.api.runtime.KieSession;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReglasAseguradoraFacade {

    private final KieSession kieSession;

    public ReglasAseguradoraFacade(@ReglasAseguradora KieSession kieSession) {
        this.kieSession = kieSession;
    }

    /**
     * Get specialty based on specialty code
     *
     * @param aseguradoraID unique asegurador ID
     * @return Representation of ReglasAsegurador {@link ReglasAseguradoraDTO}
     */
    public ReglasAseguradoraResultDTO getReglasAseguradora(String aseguradoraID) throws FacadeException {
        ReglasAseguradoraResultDTO result = executeRules(aseguradoraID).getResult();
        if (result.getType() == null) {
            throw new FacadeException("There is no aseguradora with code: " + aseguradoraID, null);
        }
        return result;
    }

    public ReglasAseguradoraDTO executeRules(String aseguradoraID) {
        ReglasAseguradoraDTO reglasAseguradoraDTO = new ReglasAseguradoraDTO();
        reglasAseguradoraDTO.setAseguradoraID(aseguradoraID);
        reglasAseguradoraDTO.setResult(new ReglasAseguradoraResultDTO());
        kieSession.insert(reglasAseguradoraDTO);
        kieSession.fireAllRules();
        return reglasAseguradoraDTO;
    }

}
