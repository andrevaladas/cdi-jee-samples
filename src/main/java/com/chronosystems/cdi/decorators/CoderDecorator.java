package com.chronosystems.cdi.decorators;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import com.chronosystems.cdi.alternatives.Coder;

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public abstract class CoderDecorator implements Coder {
    
    @Inject
    @Delegate
    @Any
    Coder coder;

    @Override
    public String execute() {
    	return coder.execute() + " WITH >>> @Decorator implementation";
    }
}