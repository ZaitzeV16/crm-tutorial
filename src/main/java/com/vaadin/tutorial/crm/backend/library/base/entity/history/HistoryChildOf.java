package com.vaadin.tutorial.crm.backend.library.base.entity.history;

import com.vaadin.tutorial.crm.backend.library.base.entity.history.type.HistoryEntityType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Arrays;

import static com.vaadin.tutorial.crm.backend.library.base.entity.history.type.HistoryEntityType.DEPRECATED;
import static com.vaadin.tutorial.crm.backend.library.base.entity.history.type.HistoryEntityType.PUBLISHED;

@MappedSuperclass
@Getter
@Setter
abstract public class HistoryChildOf<PARENT extends HistoryParentOf> extends HistoryEntity {

    @ManyToOne
    @JoinColumn(name = "history_id")
    private PARENT history;

    // TODO: 2020. 10. 28. Zi - átállás - Optional may cause problems in DTO creation
//    public Optional<Long> getHistoryId() {
//        return (history != null) ? Optional.of(history.getId()) : Optional.empty();
//    }
//    public Long getHistoryId() {
//        return (this.history != null) ? this.history.getId() : null;
//    }
//
//    public <ID extends Serializable> ID getHistoryId() {
//        return (this.history != null) ? this.history.getId() : null;
//    }

    public boolean statusIs(HistoryEntityType status) {
        return this.getStatus().equals(status);
    }

    public boolean statusIsAnyOf(HistoryEntityType... statuses) {
        return Arrays.stream(statuses)
                .anyMatch(this::statusIs);
    }

    public boolean statusIsNot(HistoryEntityType status) {
        return !this.statusIs(status);
    }

    public boolean statusIsNoneOf(HistoryEntityType... statuses) {
        return Arrays.stream(statuses)
                .noneMatch(this::statusIs);
    }

    public boolean isPublished() {
        return this.statusIs(PUBLISHED);
    }

    public boolean isDeprecated() {
        return this.statusIs(DEPRECATED);
    }

    public boolean isNotDeprecated() {
        return !this.isDeprecated();
    }

}
