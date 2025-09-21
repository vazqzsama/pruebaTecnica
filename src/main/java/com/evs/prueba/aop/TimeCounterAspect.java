package com.evs.prueba.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@Slf4j
public class TimeCounterAspect {

    private Long inicio;

    @Pointcut("execution(* com.evs.prueba.controller.*.*(..))")
    public void allControllerEndPoints() {}

    @Before("allControllerEndPoints()")
    public void logBefore(JoinPoint joinPoint) {
        //log.info("Before endpoint: {}", joinPoint.getSignature().getName());
    }

    @After("allControllerEndPoints()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("Finalizo endpoint: {} time: {}ms" , joinPoint.getSignature().getName(), calcularTiempo());
    }

    @AfterReturning(pointcut = "allControllerEndPoints()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        //log.info("Endpoint returned: {} time: {}ms", result, calcularTiempo());
    }

    @AfterThrowing(pointcut = "allControllerEndPoints()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        log.error("Endpoint {} threw exception(time {}ms): ", joinPoint.getSignature().getName(),calcularTiempo(), error);
    }

    @Around("allControllerEndPoints()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        this.inicio = System.currentTimeMillis();
        log.info("Inicio endpoint: {}", joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }

    private Long calcularTiempo(){
        return System.currentTimeMillis()-inicio;
    }

}
