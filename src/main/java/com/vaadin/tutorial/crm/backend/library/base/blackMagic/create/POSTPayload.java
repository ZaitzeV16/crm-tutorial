package com.vaadin.tutorial.crm.backend.library.base.blackMagic.create;//package com.vaadin.tutorial.crm.backend.library.base.blackMagic.create;
//
//import com.vaadin.tutorial.crm.backend.library.base.dto.base.BaseDTO;
//import com.vaadin.tutorial.crm.backend.library.base.dto.base.CreateBaseDTO;
//import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
//import com.vaadin.tutorial.crm.backend.library.base.repository.BaseEntityJpaRepo;
//import com.vaadin.tutorial.crm.backend.library.base.service.BaseEntityServiceInterface;
//import com.vaadin.tutorial.crm.backend.library.base.service.asd.BaseServiceInterface;
//import service.entity.pkgIngredient.ingredient.IngredientService;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.validation.Valid;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class POSTPayload<CREATE_DTO extends iCreate> {
////public class POSTPayload<MODEL extends BaseEntity, CREATE_DTO extends iCreate<MODEL, CREATE_DTO>> {
//
//    private String type;
//    private String token = "";
//
//    @Valid
//    private CREATE_DTO attribute;
//
////    public <MODEL extends BaseEntity, SERVICE extends BaseEntityServiceInterface<MODEL>> MODEL save(SERVICE service) {
////        return (MODEL) this.attribute.save(service.getSaveProcess());
//////        return service.getModelClass().cast(this.attribute.save(service.getSaveProcess()));
////    }
//    // CreateProcess<MODEL, CREATE_DTO> createProcess
//
////    public <MODEL extends BaseEntity> MODEL save() {
////        Object save = this.attribute.save(createProcess);
////        return save;
////    }
////
////    public <RESULT_DTO extends BaseDTO> RESULT_DTO saveToDTO(CreateProcessToDTO<CREATE_DTO> createProcess, Class<RESULT_DTO> resultDtoClass) {
////        return this.attribute.save(createProcess, resultDtoClass);
////    }
//
//}
