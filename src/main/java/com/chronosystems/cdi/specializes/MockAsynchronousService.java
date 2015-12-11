package com.chronosystems.cdi.specializes;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.chronosystems.cdi.Log;

@Alternative
//@Specializes // always call this implementation
public class MockAsynchronousService extends AsynchronousService {
	
	@Inject	@Log
	private Logger LOG;

	@Override
	public void execute() {
		LOG.info("MockAsynchronousService");
	}
}