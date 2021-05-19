package com.vaadin.tutorial.crm.backend.library.base.dto.base;

import hu.hellp.mdss.annotation.MdsDTO;
import hu.hellp.mdss.annotation.MdsDefaultProperty;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MdsDTO(targetModel = BaseEntity.class)
public class BaseDTO {

    @MdsDefaultProperty
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted = false;

    public BaseDTO(Long id) {
        this.id = id;
    }

    public boolean idIsNull() {
        return this.id == null;
    }

    public boolean hasId() {
        return !this.idIsNull() && this.id > 0;
    }

    public boolean hasNoId() {
        return !this.hasId();
    }

    public boolean idIs(Long id) {
        if (this.idIsNull()) {
            return id == null;
        }

        return this.id.equals(id);
    }

    public boolean idIsNOT(Long id) {
        return !this.idIs(id);
    }

}
