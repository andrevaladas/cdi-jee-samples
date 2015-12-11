package com.chronosystems.cdi.interceptors;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

import com.chronosystems.cdi.Log;

@Logged
@Interceptor
//Use the @Priority annotation to specify interceptors globally for an application that consists of multiple modules
@Priority(Interceptor.Priority.APPLICATION) //You do not need to specify the interceptor in the beans.xml file when you use the @Priority annotation.
public class LoggedInterceptor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject	@Log
	private Logger LOG;
	
	public LoggedInterceptor() {
    }

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext) throws Exception {

    	LOG.info("Entering method: "
                + invocationContext.getMethod().getName() + " in class "
                + invocationContext.getMethod().getDeclaringClass().getName());

        return invocationContext.proceed();
    }
}