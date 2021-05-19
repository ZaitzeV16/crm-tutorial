package com.vaadin.tutorial.crm.backend.library.base.service.history;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.create.CreateProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.create.CreateProcessToDTO;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.delete.DeleteProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.ReadProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.Filterer;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.update.UpdateProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.update.UpdateProcessToDTO;
import com.vaadin.tutorial.crm.backend.library.base.dto.history.CreateHistoryChildDTO;
import com.vaadin.tutorial.crm.backend.library.base.dto.history.UpdateHistoryChildDTO;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryChildOf;

import java.util.List;

public interface HistoryChildServiceInterface<CHILD extends HistoryChildOf<?>> {

    // region CREATE
    <DTO extends CreateHistoryChildDTO<CHILD, DTO>> CreateProcess<CHILD, DTO> getSaveProcess();

    <DTO extends CreateHistoryChildDTO<CHILD, DTO>> CHILD save(DTO dto);

    <DTO extends CreateHistoryChildDTO<CHILD, DTO>> CreateProcessToDTO<DTO> getSaveProcessToDto();

    <DTO extends CreateHistoryChildDTO<CHILD, DTO>, RESULT_DTO> RESULT_DTO save(DTO dto, Class<RESULT_DTO> resultDto);
    // endregion CREATE


    // region READ
    @SuppressWarnings("rawtypes")
    <DTO, FILTER extends Filterer> ReadProcess<DTO, FILTER> getReadProcess();

    @SuppressWarnings("rawtypes")
    <DTO, FILTER extends Filterer> List<DTO> read(FILTER filter);
    // endregion READ


    // region UPDATE
    <DTO extends UpdateHistoryChildDTO<CHILD, DTO>> UpdateProcess<CHILD, DTO> getUpdateProcess();

    <DTO extends UpdateHistoryChildDTO<CHILD, DTO>> CHILD update(DTO dto);

    <DTO extends UpdateHistoryChildDTO<CHILD, DTO>> UpdateProcessToDTO<DTO> getUpdateProcessToDto();

    <DTO extends UpdateHistoryChildDTO<CHILD, DTO>, RESULT_DTO> RESULT_DTO update(DTO dto, Class<RESULT_DTO> resultDto);
    // endregion UPDATE


    // region DELETE
    <DTO> DeleteProcess<DTO> getDeleteProcess();

    <DTO> void delete(DTO dto);
    // endregion DELETE

}
