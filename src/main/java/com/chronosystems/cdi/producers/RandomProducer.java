package com.chronosystems.cdi.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class RandomProducer {

	@Inject @MaxNumber
	private int maxNumber;

	java.util.Random random = new java.util.Random(System.currentTimeMillis());

	java.util.Random getRandom() {
		return random;
	}
	
	@Produces
	@Random
	int next() {
		return getRandom().nextInt(maxNumber);
	}
}
