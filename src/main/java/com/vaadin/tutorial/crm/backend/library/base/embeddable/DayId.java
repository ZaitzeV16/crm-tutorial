package com.vaadin.tutorial.crm.backend.library.base.embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class DayId implements Serializable {

    private static final long serialVersionUID = 10L;
    private Long id;
    private Long dayNumberCode;

    public DayId(Long dayNumberCode) {
        this.dayNumberCode = dayNumberCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((dayNumberCode == null) ? 0 : dayNumberCode.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        DayId other = (DayId) obj;
        if (dayNumberCode == null) {
            if (other.dayNumberCode != null) {
                return false;
            }
        } else if (!dayNumberCode.equals(other.dayNumberCode)) {
            return false;
        }

        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }

        return true;
    }

}
