package org.mdeforge.mdeforgeui.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Configuration
public class Logging {

    private static final Logger log = LoggerFactory.getLogger(Logging.class);

    @AfterReturning(value = "org.mdeforge.mdeforgeui.Aspect.CommonJoinPointConfig.loggingControllers()", returning = "result")
    public void controllerLogging(JoinPoint joinPoint, Object result){
        log.info("after {} - result: {} ", joinPoint, result);
    }

    @AfterReturning(value = "org.mdeforge.mdeforgeui.Aspect.CommonJoinPointConfig.loggingServices()", returning = "result")
    public void servicesLogging(JoinPoint joinPoint, Object result){
        log.info("after {} - result: {} ", joinPoint, result);
    }

    @AfterReturning(value = "org.mdeforge.mdeforgeui.Aspect.CommonJoinPointConfig.loggingSecurity()", returning = "result")
    public void securityLogging(JoinPoint joinPoint, Object result){
        log.info("after {} - result: {} ", joinPoint, result);
    }


}
