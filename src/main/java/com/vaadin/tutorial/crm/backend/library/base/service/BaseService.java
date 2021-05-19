package com.vaadin.tutorial.crm.backend.library.base.service;

import com.vaadin.tutorial.crm.backend.library.base.dto.base.BaseDTO;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import com.vaadin.tutorial.crm.backend.library.base.repository.BaseJpaRepo;
import com.vaadin.tutorial.crm.backend.library.exception.NotFoundException;
import hu.hellp.mdss.service.processor.ModelDtoSerializerService;

import java.lang.reflect.ParameterizedType;
import java.util.List;


public abstract class BaseService<MODEL extends BaseEntity, ID, REPO extends BaseJpaRepo<MODEL, ID>> {

    protected final REPO repo;
    protected final Class<MODEL> modelClass;
    protected final Class<ID> idClass;
    protected final String modelClassSimpleNameLowerCamelCase;
    protected final ModelDtoSerializerService mds;

    protected BaseService(REPO repo, ModelDtoSerializerService mds) {
        this.repo = repo;
        this.mds = mds;

        this.modelClass = this.getModelClassFromGeneric();
        this.idClass = this.getIdClassFromGeneric();

        this.modelClassSimpleNameLowerCamelCase = this.setModelClassSimpleNameLowerCamelCase();     // TODO: 2020. 11. 24. Zi - rename
    }


    // region Init
    @SuppressWarnings("unchecked")
    private Class<MODEL> getModelClassFromGeneric() {
        return (Class<MODEL>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    private Class<ID> getIdClassFromGeneric() {
        return (Class<ID>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
    }

    private String setModelClassSimpleNameLowerCamelCase() {
        String s = this.modelClass.getSimpleName();
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }
    // endregion Init


    // region CRUD
    // region CREATE
    public MODEL save(MODEL model) {
        return this.repo.save(model);
    }

    public List<MODEL> saveAll(Iterable<MODEL> models) {
        return this.repo.saveAll(models);
    }
    // endregion CREATE


    // region READ
    public MODEL findById(ID id) {
        return this.repo.findById(id)
                .orElseThrow(() -> new NotFoundException("error." + this.modelClassSimpleNameLowerCamelCase + ".notExist"));
    }

    public <DTO extends BaseDTO> DTO getById(ID id, Class<DTO> dtoClass) {
        return this.mds.model2DTO(this.findById(id), dtoClass);
    }

    public List<MODEL> findAll() {
        return this.repo.findAll();
    }

    public <DTO extends BaseDTO> List<DTO> getAll(Class<DTO> dtoClass) {
        return this.mds.models2DTOs(this.repo.findAll(), dtoClass);
    }
    // endregion READ


    // region DELETE
    public void deleteById(ID id) {
        this.repo.deleteById(id);
    }

    public void delete(MODEL model) {
        this.repo.delete(model);
    }
    // endregion DELETE
    // endregion CRUD


    public long count() {
        return this.repo.count();
    }

}
