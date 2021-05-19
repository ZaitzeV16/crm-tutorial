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

import java.util.List;

public interface BaseEntityServiceInterface<MODEL extends BaseEntity> {

    // region CREATE
    <CREATE_DTO extends CreateBaseDTO<MODEL, CREATE_DTO>> CreateProcess<MODEL, CREATE_DTO> getSaveProcess();

    <CREATE_DTO extends CreateBaseDTO<MODEL, CREATE_DTO>> MODEL save(CREATE_DTO dto);

    <CREATE_DTO extends CreateBaseDTO<MODEL, CREATE_DTO>> CreateProcessToDTO<CREATE_DTO> getSaveProcessToDto();

    <CREATE_DTO extends CreateBaseDTO<MODEL, CREATE_DTO>, RESULT_DTO> RESULT_DTO save(CREATE_DTO dto, Class<RESULT_DTO> resultDtoClass);
    // endregion CREATE


    // region READ
    @SuppressWarnings("rawtypes")
    <DTO, FILTER extends Filterer> ReadProcess<DTO, FILTER> getReadProcess();

    @SuppressWarnings("rawtypes")
    <DTO, FILTER extends Filterer> List<DTO> read(FILTER filter);
    // endregion READ


    // region UPDATE
    <UPDATE_DTO extends UpdateBaseDTO<MODEL, UPDATE_DTO>> UpdateProcess<MODEL, UPDATE_DTO> getUpdateProcess();

    <UPDATE_DTO extends UpdateBaseDTO<MODEL, UPDATE_DTO>> MODEL update(UPDATE_DTO dto);

    <UPDATE_DTO extends UpdateBaseDTO<MODEL, UPDATE_DTO>> UpdateProcessToDTO<UPDATE_DTO> getUpdateProcessToDto();

    <UPDATE_DTO extends UpdateBaseDTO<MODEL, UPDATE_DTO>, RESULT_DTO> RESULT_DTO update(UPDATE_DTO dto, Class<RESULT_DTO> resultDtoClass);
    // endregion UPDATE


    // region DELETE
    <DTO> DeleteProcess<DTO> getDeleteProcess();

    <DTO> void delete(DTO dto);
    // endregion DELETE

}
