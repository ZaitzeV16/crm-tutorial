package com.vaadin.tutorial.crm.backend.library.base.pattern;//package com.vaadin.tutorial.crm.backend.library.base.pattern;
//
//import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
//import com.vaadin.tutorial.crm.backend.library.exception.ConflictException;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import static java.util.stream.Collectors.toList;
//import static javax.persistence.CascadeType.*;
//import static javax.persistence.FetchType.LAZY;
//
//@MappedSuperclass
//@Getter
//@Setter
//public class Slot<MODEL extends BaseEntity, MODEL_TYPE extends BaseEntity> extends BaseSlot {
//
//    @OneToOne(fetch = LAZY)
//    private MODEL_TYPE modelType;
//
//    @ManyToMany(cascade = {DETACH, MERGE, PERSIST, REFRESH})
//    @JoinTable(
//            name = "slot_model",
//            joinColumns = @JoinColumn(name = "slot_id"),
//            inverseJoinColumns = @JoinColumn(name = "model_id")
//    )
//    private List<MODEL> models = new ArrayList<>();
//
//
//    // region ModelType
//    public boolean hasModelType() {
//        return this.modelType != null;
//    }
//
//    public Long getModelTypeId() {
//        if (this.hasModelType()) {
//            return this.modelType.getId();
//        }
//
//        throw new ConflictException("error.slot.modelType.null");
//    }
//    // endregion ModelType
//
//
//    // region Models
//    public List<Long> getModelIds() {
//        return this.models
//                .stream()
//                .map(MODEL::getId)
//                .collect(toList());
//    }
//    // endregion Models
//
//}
