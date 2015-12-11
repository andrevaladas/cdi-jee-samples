package com.chronosystems.cdi.specializes;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.chronosystems.cdi.Log;

@Default @Asynchronous
public class AsynchronousService implements Service {
	
	@Inject	@Log
	private Logger LOG;

	@Override
	public void execute() {
		LOG.info("AsynchronousService");
	}
}