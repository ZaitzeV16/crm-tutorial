package com.vaadin.tutorial.crm.backend.library.base.processType;

import hu.hellp.mdss.service.processor.ModelDtoSerializerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

//import service.entity.pkgReservation.reservationProcess.ReservationProcessDataType;
//import service.entity.pkgReservation.reservationProcess.ReservationProcessParam;
//import service.entity.pkgReservation.reservationProcess.ReservationProcessType;

@Service
public abstract class ProcessService<
        PROCESS_TYPE extends ProcessTypeInterface<?>,
        PROCESS_PARAM extends ProcessParam<?, PROCESS_TYPE, PROCESS_SERVICE>,
        PROCESS_SERVICE extends ProcessService<PROCESS_TYPE, PROCESS_PARAM, PROCESS_SERVICE>
        > {

    private final ModelDtoSerializerService mds;

    protected ProcessService(ModelDtoSerializerService mds) {
        this.mds = mds;
    }

    // region Model 2 DTO
    public <DTO> DTO model2DTO(Object model, Class<DTO> dtoClazz) {
        return this.mds.model2DTO(model, dtoClazz);
    }

    public <DTO> List<DTO> models2DTOs(List<?> models, Class<DTO> dtoClazz) {
        return this.mds.models2DTOs(models, dtoClazz);
    }

    public <DTO> Set<DTO> models2DTOs(Set<Object> models, Class<DTO> dtoClazz) {
        return this.mds.models2DTOs(models, dtoClazz);
    }
    // endregion Model 2 DTO

    // region DTO 2 Model
    public <MODEL> MODEL DTO2Model(Object dto, Class<MODEL> modelClazz) {
        return this.mds.DTO2Model(dto, modelClazz);
    }

    public <MODEL> List<MODEL> DTOs2Models(List<?> dtos, Class<MODEL> modelClazz) {
        return this.mds.DTOs2Models(dtos, modelClazz);
    }

    public <MODEL> Set<MODEL> DTOs2Models(Set<Object> dtos, Class<MODEL> modelClazz) {
        return this.mds.DTOs2Models(dtos, modelClazz);
    }
    // endregion DTO 2 Model

    public abstract PROCESS_PARAM createProcessParam(PROCESS_TYPE processType);

//    public abstract <SOURCE_DTO extends BaseDTO> PROCESS_PARAM createProcessParam(PROCESS_TYPE processType, SOURCE_DTO sourceDto);

//    public abstract ReservationProcessParam createProcessParam(ReservationProcessType processType, Map<ReservationProcessDataType, Object> dataMap);



    @SuppressWarnings({"unchecked", "rawtypes"})  // TODO: 2021. 03. 30. Zi - teljesen generizálni a kört
    protected PROCESS_PARAM doFolyamat(PROCESS_PARAM pp) {
        List<? extends ProcessMemberInterface> members = pp.processType.getProcessMembers();

        for (ProcessMemberInterface<PROCESS_PARAM> member : members) {
            pp = member.apply(pp);
        }

        return pp;
    }

}
