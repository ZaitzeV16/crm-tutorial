package com.vaadin.tutorial.crm.backend.library.base.controller;//package com.vaadin.tutorial.crm.backend.library.base.its.a.me.calendario.app.controller;
//
//import com.vaadin.tutorial.crm.backend.library.base.blackMagic.create.POSTRequestPayload;
//import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.GETRequestPayload;
//import com.vaadin.tutorial.crm.backend.library.base.blackMagic.update.PUTRequestPayload;
//import com.vaadin.tutorial.crm.backend.library.base.dto.base.BaseDTO;
//import service.entity.pkgOpeninghours.openingHours.OpeningHoursService;
//import service.entity.pkgOpeninghours.openingHours.dto.CreateOpeningHoursDTO;
//import service.entity.pkgOpeninghours.openingHours.dto.UpdateOpeningHoursDTO;
//import service.entity.pkgOpeninghours.openingHours.model.OpeningHours;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//public class BelaController extends BaseEntityController<OpeningHours, Long, OpeningHoursService, CreateOpeningHoursDTO, UpdateOpeningHoursDTO> {
//
//    @Autowired
//    public BelaController(OpeningHoursService service) {
//        super(service);
//    }
//
//    @Override
//    public <RESULT_DTO extends BaseDTO> ResponseEntity<List<RESULT_DTO>> get(GETRequestPayload payload) {
//        return super.get(payload);
//    }
//
//    @Override
//    public ResponseEntity<?> create(@Valid POSTRequestPayload<OpeningHours, CreateOpeningHoursDTO> payload) {
//        return super.create(payload);
//    }
//
//    @Override
//    public ResponseEntity<?> update(Long aLong, PUTRequestPayload<OpeningHours, UpdateOpeningHoursDTO> payload) {
//        return super.update(aLong, payload);
//    }
//
//    @Override
//    public ResponseEntity<?> delete(Long aLong) {
//        return super.delete(aLong);
//    }
//}
