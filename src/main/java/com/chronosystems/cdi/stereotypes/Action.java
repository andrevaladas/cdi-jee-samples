package com.chronosystems.cdi.stereotypes;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;

import com.chronosystems.cdi.interceptors.Logged;

@ApplicationScoped
@Logged
@Stereotype
@Target(TYPE)
@Retention(RUNTIME)
public @interface Action {}