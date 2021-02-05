package ir.cliqmind.am.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logging {

    private static final Logger log = LoggerFactory.getLogger(Logging.class);

    @Around("execution(* ir.cliqmind.am.api.*.*(..))")
    public Object logApiCall(ProceedingJoinPoint joinPoint) throws Throwable{
        String method = joinPoint.getTarget() + "." + joinPoint.getSignature().getName();
        log.info("Request {} , Input args = {}", method, Arrays.toString(joinPoint.getArgs()));
        Object retVal;
        try{
            retVal = joinPoint.proceed();
            log.info("Request {} , Result = {}", method, retVal);
        }
        catch (Throwable throwable){
            log.error("Request {} , Error = {}", method, throwable);
            throw throwable;
        }
        return retVal;
    }

}
