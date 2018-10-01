package org.mdeforge.mdeforgeui.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class CommonJoinPointConfig {

    @Pointcut("execution(* org.mdeforge.mdeforgeui.Controller.*.*(..))")
    public void loggingControllers(){}

    @Pointcut("execution(* org.mdeforge.mdeforgeui.Service.*.*(..))")
    public void loggingServices(){}

    @Pointcut("execution(* org.mdeforge.mdeforgeui.Security.*.*(..))")
    public void loggingSecurity(){}

}
