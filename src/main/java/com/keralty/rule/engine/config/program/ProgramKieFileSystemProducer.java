package com.keralty.rule.engine.config.program;


import com.keralty.rule.engine.config.KieFileSystemProducer;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ProgramKieFileSystemProducer extends KieFileSystemProducer {

    public ProgramKieFileSystemProducer(KieServices kieServices) {
        super(kieServices);
    }

    @Program
    @Produces
    public KieFileSystem kieFileSystem() {
        return super.kieFileSystem();
    }

    @Override
    protected String getFolderLocation() {
        return "drools/program";
    }

}
