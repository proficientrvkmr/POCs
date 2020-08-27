package com.practice.aopsecuritydemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticateUserAspect {

    @Before("execution(* welcome(..))")
    public void authenticateUser(){
        System.out.println("=====>>> Authenticate User here.");
    }
}
