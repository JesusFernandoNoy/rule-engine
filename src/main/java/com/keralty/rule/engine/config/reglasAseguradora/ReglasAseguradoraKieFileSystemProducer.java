package com.keralty.rule.engine.config.reglasAseguradora;

import com.keralty.rule.engine.config.KieFileSystemProducer;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ReglasAseguradoraKieFileSystemProducer extends KieFileSystemProducer {

    public ReglasAseguradoraKieFileSystemProducer(KieServices kieServices) {
        super(kieServices);
    }

    @ReglasAseguradora
    @Produces
    public KieFileSystem kieFileSystem() {
        return super.kieFileSystem();
    }

    @Override
    protected String getFolderLocation() {
        return "drools/reglasAseguradora";
    }
}
