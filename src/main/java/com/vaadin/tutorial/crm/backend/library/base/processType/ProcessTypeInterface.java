package com.vaadin.tutorial.crm.backend.library.base.processType;

import java.util.List;

public interface ProcessTypeInterface<PROCESS_MEMBER extends ProcessMemberInterface<? extends ProcessParam<?, ?, ?>>> {

    List<? extends ProcessMemberInterface> getProcessMembers();

}
