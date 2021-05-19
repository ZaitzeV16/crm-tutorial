package com.vaadin.tutorial.crm.backend.seed;

import com.vaadin.tutorial.crm.backend.entity._leftover.company.CompanyService;
import com.vaadin.tutorial.crm.backend.entity._leftover.company.model.Company;
import com.vaadin.tutorial.crm.backend.library.base.seed.BaseSeedService;
import com.vaadin.tutorial.crm.backend.library.base.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@SeedService
public class CompanySeedService extends BaseSeedService<Company, CompanyService> {

    @Autowired
    public CompanySeedService(CompanyService companyService) {
        super(companyService);
    }

    @Override
    public List<Company> generateSeedData() {
        return Stream.of("Path-Way Electronics", "E-Tech Management", "Path-E-Tech Management")
                .map(Company::new)
                .collect(toList());
    }

}
