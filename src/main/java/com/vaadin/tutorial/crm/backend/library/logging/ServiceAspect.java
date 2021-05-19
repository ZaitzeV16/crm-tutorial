package com.vaadin.tutorial.crm.backend.library.logging;

import com.vaadin.tutorial.crm.backend.library.base.dto.base.BaseDTO;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Log4j
public class ServiceAspect {
    @Around("@annotation(EventLog)")
    public Object createEventLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();
        try {
            if (!(joinPoint.getTarget() instanceof LoggableService)) {
                throw new EventLogAspectException(joinPoint.getTarget().getClass().getCanonicalName() + " is not implement LoggableService interface");
            }

            Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

            if (method.getReturnType().equals(Void.TYPE)) {
                throw new EventLogAspectException(method.getName() + " has void return type");
            }

            Long id = this.getIdFromProceed(proceed);

            LoggableService service = (LoggableService) joinPoint.getTarget();

            service.createEventLog(
                    id,
                    this.getMessageFromAnnotation(method.getAnnotation(EventLog.class))
            );

        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
        return proceed;
    }

    private Long getIdFromProceed(Object proceed) throws EventLogAspectException {
        if (proceed instanceof BaseDTO) {
            return ((BaseDTO) proceed).getId();
        } else if (proceed instanceof BaseEntity) {
            return ((BaseEntity) proceed).getId();
        }
        throw new EventLogAspectException("The type of return object is not BaseDTO or BaseEntity. Type is " + proceed.getClass().getCanonicalName());
    }

//    private Long getIdFromProceed(Object proceed) throws EventLogAspectException {
//        if (proceed instanceof BaseDTO) {
//            return ((BaseDTO) proceed).getId();
//        } else if (proceed instanceof BaseEntity) {
//            return ((BaseEntity) proceed).getId();
//        }
//        throw new EventLogAspectException("The type of return object is not BaseDTO or BaseEntity. Type is " + proceed.getClass().getCanonicalName());
//    }

    private String getMessageFromAnnotation(EventLog annotation) throws EventLogAspectException {
        if (annotation == null) {
            throw new EventLogAspectException("U not use EventLog annotation");
        }
        return annotation.value();
    }
}
