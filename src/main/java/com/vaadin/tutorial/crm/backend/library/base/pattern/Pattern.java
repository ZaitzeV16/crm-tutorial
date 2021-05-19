package com.vaadin.tutorial.crm.backend.library.base.pattern;//package com.vaadin.tutorial.crm.backend.library.base.pattern;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.Cache;
//
//import javax.persistence.MapKey;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.OneToMany;
//import javax.persistence.OrderBy;
//import java.util.HashMap;
//import java.util.Map;
//
//import static javax.persistence.CascadeType.*;
//import static org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL;
//
//@MappedSuperclass
//@Getter
//@Setter
//public class Pattern<PATTERN_SLOT extends PatternSlot> extends BaseEntity {
//
//    @OneToMany(mappedBy = "pattern", cascade = {DETACH, MERGE, PERSIST, REFRESH})
//    @MapKey(name = "orderNumberId.orderNumber")
//    @Cache(usage = TRANSACTIONAL)
//    @OrderBy("orderNumberId.orderNumber ASC")
//    @JsonIgnore
//    private Map<Long, PATTERN_SLOT> slotMap = new HashMap<>();
//
//}
