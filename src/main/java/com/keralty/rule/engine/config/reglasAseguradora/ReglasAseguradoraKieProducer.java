package com.keralty.rule.engine.config.reglasAseguradora;


import com.keralty.rule.engine.config.KieProducer;
import lombok.NoArgsConstructor;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieSession;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
@NoArgsConstructor
public class ReglasAseguradoraKieProducer extends KieProducer{

    @Inject
    protected ReglasAseguradoraKieProducer(KieServices kieServices, @ReglasAseguradora KieFileSystem kieFileSystem) {
        super(kieServices, kieFileSystem);
    }

    @ReglasAseguradora
    @Produces
    public KieSession kieSession() {
        return super.kieSession();
    }
}
