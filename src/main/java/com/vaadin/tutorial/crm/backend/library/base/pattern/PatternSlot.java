package com.vaadin.tutorial.crm.backend.library.base.pattern;//package com.vaadin.tutorial.crm.backend.library.base.pattern;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.vaadin.tutorial.crm.backend.library.base.embeddable.OrderNumberId;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//import static javax.persistence.FetchType.LAZY;
//
//@MappedSuperclass
//@Getter
//@Setter
//public class PatternSlot<SLOT extends Slot, PATTERN extends Pattern> {
//
//    @EmbeddedId
//    @JsonIgnore
//    private OrderNumberId orderNumberId;
//
//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "slot_id")
//    @NotNull
//    private SLOT slot;
//
//    @ManyToOne(fetch = LAZY)
//    @MapsId("id")
//    @JoinColumn(name = "id")
//    @NotNull
//    @JsonIgnore
//    private PATTERN pattern;
//
//}
