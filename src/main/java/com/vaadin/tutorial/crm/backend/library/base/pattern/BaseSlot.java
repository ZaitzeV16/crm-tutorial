package com.vaadin.tutorial.crm.backend.library.base.pattern;//package com.vaadin.tutorial.crm.backend.library.base.pattern;
//
//import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.SQLDelete;
//
//import javax.persistence.Entity;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//
//@Entity
//@SQLDelete(sql =
//        "UPDATE base_slot " +
//                "SET deleted = true " +
//                "WHERE id = ?")
//@Getter
//@Setter
//@Inheritance(strategy = InheritanceType.JOINED)
//public class BaseSlot extends BaseEntity {
//
//    private Boolean required;
//    private Boolean selectable;
//
//}
