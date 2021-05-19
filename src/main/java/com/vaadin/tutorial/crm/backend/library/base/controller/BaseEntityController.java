package com.vaadin.tutorial.crm.backend.library.base.controller;//package com.vaadin.tutorial.crm.backend.library.base.com.vaadin.tutorial.crm.backend.controller;
//
//import com.vaadin.tutorial.crm.backend.library.base.blackMagic.create.POSTRequestPayload;
//import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.GETRequestPayload;
//import com.vaadin.tutorial.crm.backend.library.base.blackMagic.update.PUTRequestPayload;
//import com.vaadin.tutorial.crm.backend.library.base.dto.base.BaseDTO;
//import com.vaadin.tutorial.crm.backend.library.base.dto.base.CreateBaseDTO;
//import com.vaadin.tutorial.crm.backend.library.base.dto.base.UpdateBaseDTO;
//import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
//import com.vaadin.tutorial.crm.backend.library.base.repository.BaseEntityJpaRepo;
//import com.vaadin.tutorial.crm.backend.library.base.service.BaseEntityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//@RestController
//public abstract class BaseEntityController<
//        MODEL extends BaseEntity,
//        ID,
//        SERVICE extends BaseEntityService<MODEL, ID, ? extends BaseEntityJpaRepo<MODEL, ID>>,
//        CREATE_DTO extends CreateBaseDTO<MODEL, CREATE_DTO>,
//        UPDATE_DTO extends UpdateBaseDTO<MODEL, UPDATE_DTO>
//        > {
//
//    protected final SERVICE service;
//
//    @Autowired
//    public BaseEntityController(SERVICE service) {
//        this.service = service;
//    }
//
//    // region GET
//    @GetMapping(value = "")
//    public <RESULT_DTO extends BaseDTO> ResponseEntity<List<RESULT_DTO>> get(@RequestBody GETRequestPayload payload) {
//        return ResponseEntity.ok(this.getAllByFilter(payload));
//    }

//import org.springframework.web.bind.annotation.RequestParam;(@RequestParam(name = "filter") String filter) {
//        GETRequestPayload payload = Utilities.getPayloadFromString(filter, GETRequestPayload.class);
//        return ResponseEntity.ok(payload.findAllByFilter(this.service.getReadProcess()));
//
//    protected final <RESULT_DTO extends BaseDTO> List<RESULT_DTO> getAllByFilter(@RequestBody GETRequestPayload payload) {
//        return payload.findAllByFilter(this.service.getReadProcess());
//    }
//    // endregion GET
//
//
//    // region POST
//    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> create(@Valid @RequestBody POSTRequestPayload<MODEL, CREATE_DTO> payload) {
//        this.createProcess(payload);
//        return ResponseEntity.noContent().build();
//    }
//
//    protected final void createProcess(@RequestBody @Valid POSTRequestPayload<MODEL, CREATE_DTO> payload) {
//        payload.save(this.service.getSaveProcess());
//    }
//
//    protected final <RESULT_DTO extends BaseDTO> RESULT_DTO createProcessToDto(@RequestBody @Valid POSTRequestPayload<MODEL, CREATE_DTO> payload, Class<RESULT_DTO> resultDtoClass) {
//        return payload.saveToDTO(this.service.getSaveProcessToDto(), resultDtoClass);
//    }
//    // endregion POST
//
//
//    // region PUT
//    @PutMapping(value = "", produces = APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody PUTRequestPayload<MODEL, UPDATE_DTO> payload) {
//        this.updateProcess(payload);
//        return ResponseEntity.noContent().build();
//    }
//
//    protected final void updateProcess(@RequestBody PUTRequestPayload<MODEL, UPDATE_DTO> payload) {
//        payload.update(this.service.getUpdateProcess());
//    }
//
//    protected final <RESULT_DTO extends BaseDTO> RESULT_DTO updateProcessToDto(@RequestBody PUTRequestPayload<MODEL, UPDATE_DTO> payload, Class<RESULT_DTO> resultDtoClass) {
//        return payload.updateToDTO(this.service.getUpdateProcessToDto(), resultDtoClass);
//    }
//    // endregion PUT
//
//
//    // region DELETE
//    @DeleteMapping(value = "", produces = APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> delete(@PathVariable ID id) {
//        this.deleteProcess(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    protected final void deleteProcess(@PathVariable ID id) {
//        this.service.deleteById(id);
//    }
//    // endregion DELETE
//
//}
