package com.vaadin.tutorial.crm.backend.library.base.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
@Getter
@Setter
abstract public class BaseEntity extends Auditable {
//abstract public class BaseEntity<ID extends Serializable> extends Auditable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
//    private ID id;

    private Boolean deleted = false;

    public boolean isNotDeleted() {
        return !this.deleted;
    }

    //    public boolean idIs(ID id) {
    public boolean idIs(Long id) {
        if (this.id == null) {
            return id == null;
        }

        return this.id.equals(id);
    }

    public boolean idIsNull() {
        return this.id == null;
    }

    //    public boolean idIsNOT(ID id) {
    public boolean idIsNOT(Long id) {
        return !this.idIs(id);
    }

//    public boolean hasId() {
//        return !this.idIsNull() && this.id > 0;
//    }

//    public boolean hasNoId() {
//        return !this.hasId();
//    }

    @Override
    public int hashCode() {
        if (this.idIsNOT(null)) {
            return this.getId().hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        BaseEntity other = (BaseEntity) obj;
        if (this.idIsNull() || other.idIsNull()) {
            return false;
        }

        return this.idIs(other.getId());
    }

}
