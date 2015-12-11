package com.chronosystems.cdi.alternatives;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.chronosystems.cdi.Log;

public class CoderImpl implements Coder {

	@Inject	@Log
	private Logger LOG;
	
	@Override
	public String execute() {
		String msg = "@Default class";
		LOG.info(msg);
		return msg;
	}
}