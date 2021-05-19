package com.vaadin.tutorial.crm.backend.library.base.processType;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ProcessParam<
        PROCESS_DATA_TYPE extends Enum<?>,
        PROCESS_TYPE extends ProcessTypeInterface<?>,
        PROCESS_SERVICE extends ProcessService<PROCESS_TYPE, ? extends ProcessParam<PROCESS_DATA_TYPE, PROCESS_TYPE, PROCESS_SERVICE>, PROCESS_SERVICE>
        > {

    public final PROCESS_TYPE processType;
    public final PROCESS_SERVICE processService;
    public final Map<PROCESS_DATA_TYPE, Object> dataMap = new HashMap<>();

    protected ProcessParam(PROCESS_TYPE processType, PROCESS_SERVICE processService, @NotNull Map<PROCESS_DATA_TYPE, Object> dataMap) {
        this.processType = processType;
        this.processService = processService;

        this.populateDataMap(dataMap);
    }

    private void populateDataMap(Map<PROCESS_DATA_TYPE, Object> dataMap) {
        dataMap.forEach(this::add);
    }

    public <OBJECT> void add(PROCESS_DATA_TYPE dataType, OBJECT object) {
        this.dataMap.put(dataType, object);
    }

    @SuppressWarnings("unchecked")      // TODO: 2021. 03. 09. Zi - a castolás nem biztos, hogy kell
    public <OBJECT> OBJECT get(PROCESS_DATA_TYPE dataType) {
        return (OBJECT) this.dataMap.get(dataType);
    }

    // region Model 2 DTO
    public <DTO> DTO model2DTO(Object model, Class<DTO> dtoClazz) {
        return this.processService.model2DTO(model, dtoClazz);
    }

    public <DTO> List<DTO> models2DTOs(List<?> models, Class<DTO> dtoClazz) {
        return this.processService.models2DTOs(models, dtoClazz);
    }

    public <DTO> Set<DTO> models2DTOs(Set<Object> models, Class<DTO> dtoClazz) {
        return this.processService.models2DTOs(models, dtoClazz);
    }
    // endregion Model 2 DTO

    // region DTO 2 Model
    public <MODEL> MODEL DTO2Model(Object dto, Class<MODEL> modelClazz) {
        return this.processService.DTO2Model(dto, modelClazz);
    }

    public <MODEL> List<MODEL> DTOs2Models(List<?> dtos, Class<MODEL> modelClazz) {
        return this.processService.DTOs2Models(dtos, modelClazz);
    }

    public <MODEL> Set<MODEL> DTOs2Models(Set<Object> dtos, Class<MODEL> modelClazz) {
        return this.processService.DTOs2Models(dtos, modelClazz);
    }
    // endregion DTO 2 Model

}
