package com.vaadin.tutorial.crm.backend.entity._leftover.company;

import com.vaadin.tutorial.crm.backend.entity._leftover.company.model.Company;
import com.vaadin.tutorial.crm.backend.entity._leftover.company.repo.CompanyRepository;
import com.vaadin.tutorial.crm.backend.library.base.service.BaseEntityService;
import hu.hellp.mdss.service.processor.ModelDtoSerializerService;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.stream.Collectors.toMap;


@Service
public class CompanyService extends BaseEntityService<Company, Long, CompanyRepository> {

    protected CompanyService(CompanyRepository repo, ModelDtoSerializerService mds) {
        super(repo, mds);
    }

    public Map<String, Integer> getStats() {
        return this.findAll()
                .stream()
                .collect(toMap(
                        Company::getName,
                        Company::getEmployeeSize
                ));
    }

}
