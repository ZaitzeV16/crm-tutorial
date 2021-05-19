package com.vaadin.tutorial.crm.backend.seed;

import com.vaadin.tutorial.crm.backend.library.base.seed.MainSeedService;
import com.vaadin.tutorial.crm.backend.library.base.seed.SeedServiceInterface;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CustomMainSeedService extends MainSeedService {

    public CustomMainSeedService(List<? extends SeedServiceInterface<?>> seedServices) {
        super(seedServices);
    }

    @PostConstruct
    public void generate() {
        this.createSeed();
    }

}
