package com.keralty.rule.engine.config;


import io.quarkus.arc.DefaultBean;
import io.quarkus.runtime.configuration.ConfigurationException;

import lombok.NoArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.internal.io.ResourceFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
@NoArgsConstructor
public class KieFileSystemProducer {
    private KieServices kieServices;

    @ConfigProperty(name = "drools.root")
    public String baseDrlLocation;

    @Inject
    public KieFileSystemProducer(KieServices kieServices) {
        this.kieServices = kieServices;
    }

    @Produces
    @DefaultBean
    public KieFileSystem kieFileSystem() {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        getFiles().forEach(file -> kieFileSystem.write(ResourceFactory.newFileResource(file)));
        return kieFileSystem;
    }

    private List<File> getFiles() {
        if(baseDrlLocation != null) {
            //System.out.println("baseDrlLocation = "+baseDrlLocation);
            /*if(baseDrlLocation.contains("C:")){
                baseDrlLocation = baseDrlLocation.substring(20);
                System.out.println("nueva baseDrlLocation = "+baseDrlLocation);
            }*/
            try (Stream<Path> paths = Files.walk(Path.of(getRulesLocation()))) {
                return paths.filter(Files::isRegularFile).map(java.nio.file.Path::toFile).toList();
            } catch (IOException e) {
                throw new ConfigurationException("Cannot read .drl files directory to build KieBase: " + getRulesLocation());
            }
        } else {
            throw new ConfigurationException("There is no base .drl location defined");
        }
    }

    protected String getRulesLocation() {
        return baseDrlLocation + "/" + getFolderLocation();
    }

    protected String getFolderLocation() {
        return "/drools/base";
    }

}
