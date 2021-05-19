package com.vaadin.tutorial.crm.backend.library.base.dto.base.annotation;

import hu.hellp.mdss.annotation.MdsBaseModelProducer;
import hu.hellp.mdss.annotation.MdsDTO;
import hu.hellp.mdss.annotation.MdsProcessorMethodConfig;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@MdsDTO(
        targetModel = Object.class,
        getOriginalModelWith = @MdsBaseModelProducer(
                processorClass = Object.class,
                methodName = "findById",
                config = @MdsProcessorMethodConfig(params = "this.id")))
public @interface MdsUpdateDTO {

    @AliasFor(annotation = MdsDTO.class)
    Class<?> targetModel();

    @AliasFor(annotation = MdsDTO.class)
    MdsBaseModelProducer getOriginalModelWith() default @MdsBaseModelProducer(
            processorClass = Object.class,
            methodName = "findById",
            config = @MdsProcessorMethodConfig(params = "this.id"));

    // TODO: 2021. 05. 14. Zi - emmég itt nagyon nem jó
//    @AliasFor(annotation = MdsBaseModelProducer.class, attribute = "processorClass")
//    @OverridesAttribute(constraint = MdsBaseModelProducer.class, name = "processorClass")
    Class<?> processorClass();

}
