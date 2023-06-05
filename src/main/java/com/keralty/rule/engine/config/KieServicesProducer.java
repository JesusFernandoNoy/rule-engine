package com.keralty.rule.engine.config;

import io.quarkus.arc.DefaultBean;
import org.kie.api.KieServices;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class KieServicesProducer {

    @Produces
    @DefaultBean
    private KieServices getKieServices() {
        return KieServices.Factory.get();
    }
}
