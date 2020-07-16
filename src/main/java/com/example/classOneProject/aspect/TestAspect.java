package com.example.classOneProject.aspect;

import com.example.classOneProject.dto.Responce;
import com.example.classOneProject.dto.UserPrinciple;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Aspect
@Configuration
public class TestAspect {
    Logger logger = LoggerFactory.getLogger(TestAspect.class);


    //    @Before("allControllerAndService()")
//    public void TestLog() {
//        logger.info("Aspect Called");
//    }
    @Around("allController()")
    public Responce TestLog2(ProceedingJoinPoint joinPoint) {// "ProceedingJoinPoint" for get args(..) ,methodName,signature,class name etc
        Object[] signatures = joinPoint.getArgs();
        HttpServletRequest incomingRequest = null;
        for (int i = 0; i < signatures.length; i++) {
            if (signatures[i] instanceof HttpServletRequest) {
                incomingRequest = (HttpServletRequest) signatures[i];
                break;
            }
        }
        if (incomingRequest != null) {
            Authentication authentication;
            logger.info(incomingRequest.getRequestURI() + " IP ADDRESS" + incomingRequest.getRemoteAddr());
            logger.info(joinPoint.getSignature().getDeclaringTypeName());//for get packageName
            logger.info(joinPoint.getSignature().getName());//for get methodName
            logger.info(joinPoint.getTarget().getClass().getSimpleName());//for get for get class nane
            /*
            why here print "anonymousUser"
             */
            logger.info(SecurityContextHolder.getContext().getAuthentication().getName());
        }
        try {
            Responce responce = (Responce) joinPoint.proceed();
            logger.info("Aspect Call Ended");
            return responce;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Pointcut("(execution(public * com.example.classOneProject.controller.*.*(..)) " +
            "|| execution(public * com.example.classOneProject.service.imple.*.*(..))) " +
            "&& !execution(public * com.example.classOneProject.service.imple.CustomUserDetailsService.*(..)) ) ")
    public void allControllerAndService() {

    }

    @Pointcut("(execution(public * com.example.classOneProject.controller.*.*(..))&&args(..))" +
            "&& !execution(public * com.example.classOneProject.controller.TestController.*(..))" +
            "&& !execution(public * com.example.classOneProject.EmployeeController.EmployeeControllers.*(..))")
    public void allController() {

    }
}
