package by.bsuir.ief.rest.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by andrey on 24.04.2016.
 */
@Component
@Aspect
public class LogService {

    private static Logger logger = Logger.getLogger(LogService.class);

    @Pointcut("execution(* *(..)) && within(by.bsuir.ief.rest.model.service.*)")
    private void serviceMethods() {
    };



    @Around("serviceMethods()")
    public Object logActionService(ProceedingJoinPoint joinpoint) throws Throwable {
        long start = System.currentTimeMillis();
        logger.info("method | " +joinpoint.getSignature().toShortString());
        System.out.println("method begin: " + joinpoint.getSignature().toShortString() + " >>");
        for (Object object : joinpoint.getArgs()) {
            System.out.println("Param : " + object);
            logger.info("Param : " + object);
        }
        Object object = null;
        try {
            object = joinpoint.proceed();
        } catch (Throwable e) {
            throw e;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("method end: " + joinpoint.getSignature().toShortString() + ", time=" + time + " ms <<");
        return object;
    }

}
