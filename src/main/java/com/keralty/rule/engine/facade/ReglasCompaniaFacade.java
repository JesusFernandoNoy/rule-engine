package com.keralty.rule.engine.facade;

import com.keralty.rule.engine.config.reglasCompania.ReglasCompania;
import com.keralty.rule.engine.dto.reglasCompania.ReglasCompaniaDTO;
import com.keralty.rule.engine.dto.reglasCompania.ReglasCompaniaResultDTO;
import com.keralty.rule.engine.exception.handler.FacadeException;
import org.kie.api.runtime.KieSession;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReglasCompaniaFacade {

    private final KieSession kieSession;

    public ReglasCompaniaFacade(@ReglasCompania KieSession kieSession) {
        this.kieSession = kieSession;
    }

    /**
     * Get specialty based on specialty code
     *
     * @param company unique asegurador ID
     * @return Representation of ReglasAsegurador {@link ReglasCompaniaDTO}
     */
    public ReglasCompaniaResultDTO getCompanyRule(String company) throws FacadeException {
        ReglasCompaniaResultDTO result = executeRules(company).getResult();
        if (result.getStatus() == null) {
            result = new ReglasCompaniaResultDTO();
            result.setStatus("FAIL");
            //throw new FacadeException("There is no aseguradora with code: " + aseguradoraID, null);
        }
        return result;
    }

    public ReglasCompaniaDTO executeRules(String company) {
        ReglasCompaniaDTO reglasCompaniaDTO = new ReglasCompaniaDTO();
        reglasCompaniaDTO.setCompany(company);
        reglasCompaniaDTO.setResult(new ReglasCompaniaResultDTO());
        kieSession.insert(reglasCompaniaDTO);
        kieSession.fireAllRules();
        return reglasCompaniaDTO;
    }

}
