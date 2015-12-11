package com.chronosystems.cdi.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class NumberProducer {

	private int maxNumber = 100;

	@Produces
	@MaxNumber
	int maxNumber() {
		return maxNumber;
	}
}
