package com.keralty.rule.engine.config.reglasCompania;

import com.keralty.rule.engine.config.KieFileSystemProducer;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ReglasCompaniaKieFileSystemProducer extends KieFileSystemProducer {

    public ReglasCompaniaKieFileSystemProducer(KieServices kieServices) {
        super(kieServices);
    }

    @ReglasCompania
    @Produces
    public KieFileSystem kieFileSystem() {
        return super.kieFileSystem();
    }

    @Override
    protected String getFolderLocation() {
        return "drools/reglasCompania";
    }
}
