package com.vaadin.tutorial.crm.backend.library.base.seed;

import java.util.List;

public interface SeedServiceInterface<MODEL> {

    default List<MODEL> createSeed() {
        return this.saveAll(this.generateSeedData());
    }

    List<MODEL> generateSeedData();

    List<MODEL> saveAll(Iterable<MODEL> models);

    List<MODEL> findAll();

}
