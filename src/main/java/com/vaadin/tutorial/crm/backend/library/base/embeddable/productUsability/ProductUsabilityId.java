package com.vaadin.tutorial.crm.backend.library.base.embeddable.productUsability;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ProductUsabilityId implements Serializable {

    private static final long serialVersionUID = 10L;
    private Long id;

    private ProductUsability usability;

    public ProductUsabilityId() {
    }

    public ProductUsabilityId(ProductUsability usability) {
        this.usability = usability;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((usability == null) ? 0 : usability.hashCode());
        result = prime * result
                + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductUsabilityId other = (ProductUsabilityId) obj;
        if (usability == null) {
            if (other.usability != null)
                return false;
        } else if (!usability.equals(other.usability))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}