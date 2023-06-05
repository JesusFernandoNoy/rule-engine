package com.keralty.rule.engine.config;

import io.quarkus.arc.DefaultBean;
import lombok.NoArgsConstructor;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
@NoArgsConstructor
public class KieProducer {

    private KieServices kieServices;

    private KieFileSystem kieFileSystem;

    @Inject
    protected KieProducer(KieServices kieServices, KieFileSystem kieFileSystem) {
        this.kieServices = kieServices;
        this.kieFileSystem = kieFileSystem;
    }

    @Produces
    @DefaultBean
    public KieSession kieSession() {
        return kieContainer().newKieSession();
    }

    @Produces
    public KieContainer kieContainer() {
        final KieRepository kieRepository = kieServices.getRepository();

        kieRepository.addKieModule(kieRepository::getDefaultReleaseId);

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        return kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
    }

}
