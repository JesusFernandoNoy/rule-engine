package com.keralty.rule.engine.config.reglasCompania;


import com.keralty.rule.engine.config.KieProducer;
import com.keralty.rule.engine.config.reglasCompania.ReglasCompania;
import lombok.NoArgsConstructor;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieSession;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
@NoArgsConstructor
public class ReglasCompaniaKieProducer extends KieProducer{

    @Inject
    protected ReglasCompaniaKieProducer(KieServices kieServices, @ReglasCompania KieFileSystem kieFileSystem) {
        super(kieServices, kieFileSystem);
    }

    @ReglasCompania
    @Produces
    public KieSession kieSession() {
        return super.kieSession();
    }
}
