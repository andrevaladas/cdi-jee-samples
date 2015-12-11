package com.chronosystems.cdi.producers;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.chronosystems.cdi.Log;

public class NumberPrinter {

	@Inject @Log
	private Logger LOG;
	
	@Inject	@Random
	private Instance<Integer> randomInt;
	
	public void print() {
		LOG.info(randomInt.get().toString());
	}

}
