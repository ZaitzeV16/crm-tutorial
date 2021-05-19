package com.vaadin.tutorial.crm.backend.library.base.service.history;

import hu.hellp.mdss.service.processor.ModelDtoSerializerService;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.ReadProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.Filterer;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryParentOf;
import com.vaadin.tutorial.crm.backend.library.base.repository.HistoryParentJpaRepo;
import com.vaadin.tutorial.crm.backend.library.base.service.BaseService;

import java.util.List;


public abstract class HistoryParentService<
        PARENT extends HistoryParentOf<?>,
        ID,
        REPO extends HistoryParentJpaRepo<PARENT, ID>>
        extends BaseService<PARENT, ID, REPO>
        implements HistoryParentServiceInterface<PARENT> {

    protected HistoryParentService(REPO repo, ModelDtoSerializerService mds) {
        super(repo, mds);
    }

    //      // TODO: 2021. 04. 20. Zi - hát, ezen még egy kicsit gondolkodni kell
    // TODO: 2021. 04. 20. Zi - használjuk a BaseService-est protectedként, bemeneti paraméterrel
//    private String getClassSimpleNameLowerCamelCase(Class<?> clazz) {
//        String s = clazz.getSimpleName();
//        return s.substring(0, 1).toLowerCase() + s.substring(1);
//    }
//
//    @Transactional
//    public <CHILD extends HistoryChildOf<PARENT>> PARENT saveNewChildToNewHistory(CHILD child) {
//        if (child.hasId()) {
//            throw new ConflictException("error." + this.getClassSimpleNameLowerCamelCase(child.getClass()) + ".id.notNull");
//        }
//
//        return this.saveChildToHistory(child, new DiyHistory());
//    }
//
//    @Transactional
//    public <CHILD extends HistoryChildOf<PARENT>> PARENT saveChildToHistory(CHILD child, PARENT history) {
//        history.addChild(child);
//        return this.repo.save(history);
//    }




//    @Override
//    public <DTO extends HistoryParentDTO> PARENT save(DTO dto) {
//        return this.save(this.mds.DTO2Model(dto, this.modelClass));
//    }
//
//    @Override
//    public <DTO extends HistoryParentDTO> PARENT update(DTO dto) {
//        return this.save(this.mds.DTO2Model(dto, this.modelClass));
//    }
//
//    @Override
//    public <DTO> void delete(DTO dto) {
//        this.delete(this.mds.DTO2Model(dto, this.modelClass));
//    }


    // region DO_NOT_TOUCH
    // region READ
    @SuppressWarnings("rawtypes")
    @Override
    public <DTO, FILTER extends Filterer> ReadProcess<DTO, FILTER> getReadProcess() {
        return this::read;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public <DTO, FILTER extends Filterer> List<DTO> read(FILTER filter) {
        return this.mds.models2DTOs(this.repo.findAll(filter), filter.getDtoClass());
    }
    // endregion READ
    // endregion DO_NOT_TOUCH

}
