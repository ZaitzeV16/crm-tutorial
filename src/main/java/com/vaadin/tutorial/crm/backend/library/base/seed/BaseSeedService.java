package com.vaadin.tutorial.crm.backend.library.base.seed;

import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import com.vaadin.tutorial.crm.backend.library.base.service.BaseService;

import java.util.List;

public abstract class BaseSeedService<MODEL extends BaseEntity, ENTITY_SERVICE extends BaseService<MODEL, ?, ?>> implements SeedServiceInterface<MODEL> {

    protected final ENTITY_SERVICE entityService;

    public BaseSeedService(ENTITY_SERVICE entityService) {
        this.entityService = entityService;
    }

    @Override
    public List<MODEL> saveAll(Iterable<MODEL> models) {
        return this.entityService.saveAll(models);
    }

    @Override
    public List<MODEL> findAll() {
        return this.entityService.findAll();
    }

}
