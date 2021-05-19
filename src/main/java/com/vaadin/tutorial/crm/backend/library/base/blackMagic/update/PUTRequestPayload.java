package com.vaadin.tutorial.crm.backend.library.base.blackMagic.update;

import com.vaadin.tutorial.crm.backend.library.base.dto.base.BaseDTO;
import com.vaadin.tutorial.crm.backend.library.base.dto.base.UpdateBaseDTO;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PUTRequestPayload<MODEL extends BaseEntity, UPDATE_DTO extends UpdateBaseDTO<MODEL, UPDATE_DTO>> {

    private String type;
    private String token = "";

    @Valid
    private UPDATE_DTO attribute;

    public MODEL update(UpdateProcess<MODEL, UPDATE_DTO> updateProcess) {
        return this.attribute.update(updateProcess);
    }

    public <RESULT_DTO extends BaseDTO> RESULT_DTO updateToDTO(UpdateProcessToDTO<UPDATE_DTO> updateProcess, Class<RESULT_DTO> resultDtoClass) {
        return this.attribute.update(updateProcess, resultDtoClass);
    }

}
