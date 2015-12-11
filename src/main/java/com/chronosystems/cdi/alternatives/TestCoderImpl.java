package com.chronosystems.cdi.alternatives;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import org.slf4j.Logger;

import com.chronosystems.cdi.Log;

@Alternative
//@Priority(Interceptor.Priority.PLATFORM_BEFORE)
//@Priority(Interceptor.Priority.LIBRARY_BEFORE)
@Priority(Interceptor.Priority.APPLICATION)
//@Priority(Interceptor.Priority.PLATFORM_AFTER)
public class TestCoderImpl implements Coder {

	@Inject	@Log
	private Logger LOG;

	@Override
	public String execute() {
		String msg = "@Alternative class";
		LOG.info(msg);
		return msg;
	}
}