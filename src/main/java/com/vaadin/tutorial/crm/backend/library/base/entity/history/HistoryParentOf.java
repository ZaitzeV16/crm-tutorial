package com.vaadin.tutorial.crm.backend.library.base.entity.history;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.persistence.CascadeType.ALL;

@SuppressWarnings("rawtypes")
@MappedSuperclass
@Getter
@Setter
abstract public class HistoryParentOf<HISTORY_CHILD extends HistoryChildOf> extends BaseEntity {

    @OneToMany(mappedBy = "history", cascade = ALL)
    @OrderBy("createdAt DESC")
    @JsonIgnore
    private List<HISTORY_CHILD> children = new ArrayList<>();

    @Column
    private Long count = 0L;

    @SuppressWarnings("unchecked")
    public void addChild(HISTORY_CHILD child) {
        this.children.add(child);
        child.setHistory(this);
        this.count += 1;
    }

//    public Optional<HISTORY_CHILD> getPublishedChild() {
//        return children.stream()
//                .filter(HISTORY_CHILD::isPublished)
//                .findFirst();
//    }

    public HISTORY_CHILD getPublishedChild() {
        return this.children
                .stream()
                .filter(HISTORY_CHILD::isPublished)
                .findFirst()
                .orElse(null);
    }

    public Optional<HISTORY_CHILD> findPublishedChild() {
        return this.children
                .stream()
                .filter(HISTORY_CHILD::isPublished)
                .findFirst();
    }

    public Optional<HISTORY_CHILD> findNonDeprecatedChild() {
        return this.children
                .stream()
                .filter(HISTORY_CHILD::isNotDeprecated)
                .findAny();
    }

    public HISTORY_CHILD getNonDeprecatedChild() {
        return this.children
                .stream()
                .filter(HISTORY_CHILD::isNotDeprecated)
                .findAny()
                .orElse(null);
    }

    public Optional<HISTORY_CHILD> findPublishedNotDeletedChild() {
        return this.children
                .stream()
                .filter(HISTORY_CHILD::isPublished)
                .filter(HISTORY_CHILD::isNotDeleted)
                .findFirst();
    }

    public boolean hasPublishedChild() {
        return this.children
                .stream()
                .anyMatch(HISTORY_CHILD::isPublished);
    }

}
