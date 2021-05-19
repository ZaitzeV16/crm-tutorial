package com.vaadin.tutorial.crm.backend.library.base.service;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.create.CreateProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.create.CreateProcessToDTO;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.delete.DeleteProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.ReadProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.Filterer;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.update.UpdateProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.update.UpdateProcessToDTO;
import com.vaadin.tutorial.crm.backend.library.base.dto.base.CreateBaseDTO;
import com.vaadin.tutorial.crm.backend.library.base.dto.base.UpdateBaseDTO;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import com.vaadin.tutorial.crm.backend.library.base.repository.BaseEntityJpaRepo;
import hu.hellp.mdss.service.processor.ModelDtoSerializerService;

import java.util.List;


public abstract class BaseEntityService<
        MODEL extends BaseEntity,
        ID,
        REPO extends BaseEntityJpaRepo<MODEL, ID>>
        extends BaseService<MODEL, ID, REPO>
        implements BaseEntityServiceInterface<MODEL> {

    protected BaseEntityService(REPO repo, ModelDtoSerializerService mds) {
        super(repo, mds);
    }

    @Override
    public <CREATE_DTO extends CreateBaseDTO<MODEL, CREATE_DTO>> MODEL save(CREATE_DTO dto) {
        return this.save(this.mds.DTO2Model(dto, this.modelClass));
    }

    @Override
    public <UPDATE_DTO extends UpdateBaseDTO<MODEL, UPDATE_DTO>> MODEL update(UPDATE_DTO dto) {
        return this.save(this.mds.DTO2Model(dto, this.modelClass));
    }

    @Override
    public <DTO> void delete(DTO dto) {
        this.delete(this.mds.DTO2Model(dto, this.modelClass));
    }


    // region DO_NOT_TOUCH
    // region CREATE
    @Override
    public <CREATE_DTO extends CreateBaseDTO<MODEL, CREATE_DTO>> CreateProcess<MODEL, CREATE_DTO> getSaveProcess() {
        return this::save;
    }

    @Override
    public <CREATE_DTO extends CreateBaseDTO<MODEL, CREATE_DTO>> CreateProcessToDTO<CREATE_DTO> getSaveProcessToDto() {
        return this::save;
    }

    @Override
    public <CREATE_DTO extends CreateBaseDTO<MODEL, CREATE_DTO>, RESULT_DTO> RESULT_DTO save(CREATE_DTO dto, Class<RESULT_DTO> resultDtoClass) {
        return this.mds.model2DTO(this.save(dto), resultDtoClass);
    }
    // endregion CREATE


    // region READ
    @SuppressWarnings("rawtypes")
    @Override
    public <DTO, FILTER extends Filterer> ReadProcess<DTO, FILTER> getReadProcess() {
        return this::read;
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <DTO, FILTER extends Filterer> List<DTO> read(FILTER filter) {
        return this.mds.models2DTOs(this.repo.findAll(filter), filter.getDtoClass());
    }
    // endregion READ


    // region UPDATE
    @Override
    public <UPDATE_DTO extends UpdateBaseDTO<MODEL, UPDATE_DTO>> UpdateProcess<MODEL, UPDATE_DTO> getUpdateProcess() {
        return this::update;
    }

    @Override
    public <UPDATE_DTO extends UpdateBaseDTO<MODEL, UPDATE_DTO>> UpdateProcessToDTO<UPDATE_DTO> getUpdateProcessToDto() {
        return this::update;
    }

    @Override
    public <UPDATE_DTO extends UpdateBaseDTO<MODEL, UPDATE_DTO>, RESULT_DTO> RESULT_DTO update(UPDATE_DTO dto, Class<RESULT_DTO> resultDtoClass) {
        return this.mds.model2DTO(this.update(dto), resultDtoClass);
    }
    // endregion UPDATE

    // region DELETE
    @Override
    public <DTO> DeleteProcess<DTO> getDeleteProcess() {
        return this::delete;
    }
    // endregion DELETE
    // endregion DO_NOT_TOUCH

}
