package by.bsuir.ief.rest.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by andrey on 24.04.2016.
 */
@Component
@Aspect
public class LogDao {

    private static Logger logger = Logger.getLogger(LogDao.class);


    @Pointcut("execution(* *(..)) && within(by.bsuir.ief.rest.dao.pisl.*)")
    private void daoMethodsPisl() {
    };


    @Pointcut("execution(* *(..)) && within(by.bsuir.ief.rest.dao.hibernatedao.*)")
    private void daoMethods() {
    };

    @Around("daoMethodsPisl()")
    public Object logActionDaoPisl(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("method begin: " + joinPoint.getSignature().toString() + " >>");
        for (Object object : joinPoint.getArgs()) {
            System.out.println("Param : " + object);
            logger.info("Param : " + object);
        }
        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("method end: " + joinPoint.getSignature().toString() + ", time=" + time + " ms <<");
        return o;
    }


    @Around("daoMethods()")
    public Object logActionDao(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        logger.info("method | " +joinPoint.getSignature().toShortString());
        System.out.println("method begin: " + joinPoint.getSignature().toString() + " >>");
        for (Object object : joinPoint.getArgs()) {
            System.out.println("Param : " + object);
            logger.info("Param : " + object);
        }
        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("method end: " + joinPoint.getSignature().toString() + ", time=" + time + " ms <<");
        return o;
    }

}
