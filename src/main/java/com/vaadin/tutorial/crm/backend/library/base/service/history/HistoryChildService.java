package com.vaadin.tutorial.crm.backend.library.base.service.history;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.create.CreateProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.create.CreateProcessToDTO;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.delete.DeleteProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.ReadProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.Filterer;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.update.UpdateProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.update.UpdateProcessToDTO;
import com.vaadin.tutorial.crm.backend.library.base.dto.history.CreateHistoryChildDTO;
import com.vaadin.tutorial.crm.backend.library.base.dto.history.UpdateHistoryChildDTO;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryChildOf;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.type.HistoryEntityType;
import com.vaadin.tutorial.crm.backend.library.base.repository.HistoryChildJpaRepo;
import com.vaadin.tutorial.crm.backend.library.base.service.BaseService;
import com.vaadin.tutorial.crm.backend.library.exception.ConflictException;
import hu.hellp.mdss.service.processor.ModelDtoSerializerService;

import java.util.List;


public abstract class HistoryChildService<
        CHILD extends HistoryChildOf<?>,
        ID,
        REPO extends HistoryChildJpaRepo<CHILD, ID>>
        extends BaseService<CHILD, ID, REPO>
        implements HistoryChildServiceInterface<CHILD> {

    protected HistoryChildService(REPO repo, ModelDtoSerializerService mds) {
        super(repo, mds);
    }

    @Override
    public <DTO extends CreateHistoryChildDTO<CHILD, DTO>> CHILD save(DTO dto) {
        return this.save(this.mds.DTO2Model(dto, this.modelClass));
    }

    @Override
    public <DTO extends UpdateHistoryChildDTO<CHILD, DTO>> CHILD update(DTO dto) {
        return this.save(mds.DTO2Model(dto, this.modelClass));
    }

    @Override
    public <DTO> void delete(DTO dto) {
        this.delete(this.mds.DTO2Model(dto, this.modelClass));
    }


    /////////////////////////////////////////////////////////////////////////////


    protected void validateHistoryStatusIsAnyOf(CHILD child, String errorMessage, HistoryEntityType... statuses) {
        assert statuses.length > 0;

        if (child.statusIsNoneOf(statuses)) {
            throw new ConflictException("error." + this.modelClassSimpleNameLowerCamelCase + ".status." + errorMessage);
        }
    }

    protected void validateHistoryStatusIsNoneOf(CHILD child, String errorMessage, HistoryEntityType... statuses) {
        assert statuses.length > 0;

        if (child.statusIsAnyOf(statuses)) {
            throw new ConflictException("error." + this.modelClassSimpleNameLowerCamelCase + ".status." + errorMessage);
        }
    }


    /////////////////////////////////////////////////////////////////////////////


    // region DO_NOT_TOUCH
    // region CREATE
    // TODO: 2021. 04. 09. Zi - ha mind a 3 method final, akkor a getSaveProcessToDto,
    //  kifelé menő szerializációja elszáll a buzigecihibával, ha 0-1-2 final method van a chainben,
    //  akkor tökéletesen lefut a restaurant mentés a getSaveProcessToDto-val
    @Override
    public <DTO extends CreateHistoryChildDTO<CHILD, DTO>> CreateProcess<CHILD, DTO> getSaveProcess() {
        return this::save;
    }

    @Override
    public <DTO extends CreateHistoryChildDTO<CHILD, DTO>> CreateProcessToDTO<DTO> getSaveProcessToDto() {
        return this::save;
    }

    @Override
    public <DTO extends CreateHistoryChildDTO<CHILD, DTO>, RESULT_DTO> RESULT_DTO save(DTO dto, Class<RESULT_DTO> resultDto) {
        return this.mds.model2DTO(this.save(dto), resultDto);
    }
    // endregion CREATE


    // region READ
    @SuppressWarnings("rawtypes")
    @Override
    public <DTO, FILTER extends Filterer> ReadProcess<DTO, FILTER> getReadProcess() {
        return this::read;
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <DTO, FILTER extends Filterer> List<DTO> read(FILTER filter) {
        return this.mds.models2DTOs(this.repo.findAll(filter), filter.getDtoClass());
    }
    // endregion READ


    // region UPDATE
    @Override
    public <DTO extends UpdateHistoryChildDTO<CHILD, DTO>> UpdateProcess<CHILD, DTO> getUpdateProcess() {
        return this::update;
    }

    @Override
    public <DTO extends UpdateHistoryChildDTO<CHILD, DTO>> UpdateProcessToDTO<DTO> getUpdateProcessToDto() {
        return this::update;
    }

    @Override
    public <DTO extends UpdateHistoryChildDTO<CHILD, DTO>, RESULT_DTO> RESULT_DTO update(DTO dto, Class<RESULT_DTO> resultDto) {
        return this.mds.model2DTO(this.update(dto), resultDto);
    }
    // endregion UPDATE

    // region DELETE
    @Override
    public <DTO> DeleteProcess<DTO> getDeleteProcess() {
        return this::delete;
    }
    // endregion DELETE
    // endregion DO_NOT_TOUCH

}
