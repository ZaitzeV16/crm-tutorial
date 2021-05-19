package com.vaadin.tutorial.crm.backend.library.base.processType;

import java.util.function.Function;

public interface ProcessMemberInterface<PROCESS_PARAM extends ProcessParam<?, ?, ?>> {

    default PROCESS_PARAM apply(PROCESS_PARAM pp) {
        return this.getProcess().apply(pp);
    }

    default Function<PROCESS_PARAM, PROCESS_PARAM> getProcess() {
        return this::getSubProcess;
    }

    PROCESS_PARAM getSubProcess(PROCESS_PARAM pp);

}
