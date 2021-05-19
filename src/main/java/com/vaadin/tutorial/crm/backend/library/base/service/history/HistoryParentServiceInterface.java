package com.vaadin.tutorial.crm.backend.library.base.service.history;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.ReadProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.Filterer;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryParentOf;

import java.util.List;

public interface HistoryParentServiceInterface<PARENT extends HistoryParentOf<?>> {

    // region CREATE
//    <DTO extends HistoryParentDTO> CreateProcess<PARENT, DTO> getSaveProcess();
//
//    <DTO extends HistoryParentDTO> PARENT save(DTO dto);
    // endregion CREATE


    // region READ
    @SuppressWarnings("rawtypes")
    <DTO, FILTER extends Filterer> ReadProcess<DTO, FILTER> getReadProcess();

    @SuppressWarnings("rawtypes")
    <DTO, FILTER extends Filterer> List<DTO> read(FILTER filter);
    // endregion READ


    // region UPDATE
//    <DTO extends HistoryParentDTO> UpdateProcess<PARENT, DTO> getUpdateProcess();
//
//    <DTO extends HistoryParentDTO> PARENT update(DTO dto);
    // endregion UPDATE


    // region DELETE
//    <DTO> DeleteProcess<DTO> getDeleteProcess();
//
//    <DTO> void delete(DTO dto);
    // endregion DELETE

}
