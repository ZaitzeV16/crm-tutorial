package com.vaadin.tutorial.crm.backend.library.base.seed;

import com.vaadin.tutorial.crm.backend.library.exception.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;


@Service
public class MainSeedService {

    private final Environment env;

    private final List<? extends BaseSeedService<?, ?>> seedServices;
    private final List<? extends BaseSeedService<?, ?>> skippedSeedServices;
    private final List<? extends BaseSeedService<?, ?>> notSkippedSeedServices;

    @Autowired
    public MainSeedService(Environment env, List<? extends BaseSeedService<?, ?>> seedServices) {
        this.env = env;
        this.seedServices = seedServices;
        this.skippedSeedServices = this.seedServices.stream().filter(this::toBeSkipped).collect(toList());
        this.notSkippedSeedServices = this.seedServices.stream().filter(this::notToBeSkipped).collect(toList());
    }

    private boolean toBeSkipped(BaseSeedService<?, ?> seedService) {
        SeedService annotation = seedService.getClass().getAnnotation(SeedService.class);
        if (annotation != null) {
            return annotation.skip();
        }
        throw new RuntimeException("anyád");
    }

    private boolean notToBeSkipped(BaseSeedService<?, ?> seedService) {
        return !this.toBeSkipped(seedService);
    }

    @SafeVarargs    // TODO: 2021. 05. 14. Zi - he?
    public final void createSeed(Class<? extends BaseSeedService<?, ?>>... exclusions) {
//    public void createSeed(Collection<Class<? extends BaseSeedService<?, ?>>> exclusions) {
        List<? extends BaseSeedService<?, ?>> orderedNotSkippedSeedServices = this.notSkippedSeedServices
                .stream()
                .sorted(this::compareSeedServices)
                .collect(toList());


        List<?> currentSeed;
        for (BaseSeedService<?, ?> seedService : orderedNotSkippedSeedServices) {
            if (Arrays.stream(exclusions).anyMatch(exclusion -> exclusion.equals(seedService.getClass()))) {
                continue;
            }
            currentSeed = seedService.createSeed();
        }
    }

    private int compareSeedServices(BaseSeedService<?, ?> ssi1, BaseSeedService<?, ?> ssi2) {
        Class<? extends BaseSeedService> ssi1Class = ssi1.getClass();
        SeedService annotation1 = ssi1Class.getAnnotation(SeedService.class);

        Class<? extends BaseSeedService> ssi2Class = ssi2.getClass();
        SeedService annotation2 = ssi2Class.getAnnotation(SeedService.class);

        boolean firstDependsOnSecond = Arrays.asList(annotation1.dependsOn()).contains(ssi2Class);
        boolean secondDependsOnFirst = Arrays.asList(annotation2.dependsOn()).contains(ssi1Class);

        if (firstDependsOnSecond && secondDependsOnFirst) {
            String ssi1ClassCanonicalName = ssi1Class.getCanonicalName();
            String ssi2ClassCanonicalName = ssi2Class.getCanonicalName();
            String msg = String.join(
                    " ",
                    List.of(
                            "Dependency cycle between SeedServices!!:",
                            ssi1ClassCanonicalName,
                            "depends on",
                            ssi2ClassCanonicalName,
                            "and",
                            ssi2ClassCanonicalName,
                            "depends on",
                            ssi1ClassCanonicalName
                    ));
            throw new ConflictException(msg);
        }

        if (firstDependsOnSecond) {
            return 1;
        }

        if (secondDependsOnFirst) {
            return -1;
        }

        return 0;
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

    @PostConstruct
    public void generate() {
        boolean profileContainsSeed = Arrays.stream(this.env.getActiveProfiles())
                .anyMatch(profile -> profile.toLowerCase().contains("seed"));
        if (profileContainsSeed) {
            this.createSeed();
        }
    }

}
