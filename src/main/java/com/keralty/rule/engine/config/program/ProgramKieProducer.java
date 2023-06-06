package com.keralty.rule.engine.config.program;


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
public class ProgramKieProducer extends KieProducer {

    @Inject
    protected ProgramKieProducer(KieServices kieServices, @Program KieFileSystem kieFileSystem) {
        super(kieServices, kieFileSystem);
    }

    @Program
    @Produces
    public KieSession kieSession() {
        return super.kieSession();
    }
}
