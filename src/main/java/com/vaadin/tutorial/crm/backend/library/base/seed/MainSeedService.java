package com.vaadin.tutorial.crm.backend.library.base.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;


@Service
public class MainSeedService {

    private final List<? extends SeedServiceInterface<?>> seedServices;
    private final List<? extends SeedServiceInterface<?>> skippedSeedServices;
    private final List<? extends SeedServiceInterface<?>> notSkippedSeedServices;

    @Autowired
    public MainSeedService(List<? extends SeedServiceInterface<?>> seedServices) {
        this.seedServices = seedServices;
        this.skippedSeedServices = this.seedServices.stream().filter(this::notToBeSkipped).collect(toList());
        this.notSkippedSeedServices = this.seedServices.stream().filter(this::toBeSkipped).collect(toList());
    }

    private boolean toBeSkipped(SeedServiceInterface<?> seedService) {
        SeedService annotation = seedService.getClass().getAnnotation(SeedService.class);
        if (annotation != null) {
            return annotation.skip();
        }
        throw new RuntimeException("anyád");
    }

    private boolean notToBeSkipped(SeedServiceInterface<?> seedService) {
        return !this.toBeSkipped(seedService);
    }

    @SafeVarargs    // TODO: 2021. 05. 14. Zi - he?
    public final void createSeed(Class<? extends SeedServiceInterface<?>>... exclusions) {
//    public void createSeed(Collection<Class<? extends SeedServiceInterface<?>>> exclusions) {
        List<?> currentSeed;
        for (SeedServiceInterface<?> seedService : this.notSkippedSeedServices) {
            if (Arrays.stream(exclusions).anyMatch(exclusion -> exclusion.equals(seedService.getClass()))) {
                continue;
            }
            currentSeed = seedService.createSeed();
        }
    }

    public Map<Class<?>, List<?>> findAllSeed() {
        return this.notSkippedSeedServices
                .stream()
                .map(SeedServiceInterface::findAll)
                .collect(toMap(
                        seed -> seed.get(0).getClass(),
                        seed -> seed
                ));
    }

}
