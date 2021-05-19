package com.vaadin.tutorial.crm.backend.library.base.seed;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
@Inherited
public @interface SeedService {

    @AliasFor(annotation = Service.class)
    String value() default "";

    boolean skip() default false;

}
