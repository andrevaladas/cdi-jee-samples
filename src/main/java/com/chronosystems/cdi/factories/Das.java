package com.chronosystems.cdi.factories;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.chronosystems.cdi.Log;

@ApplicationScoped
public class Das implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject @Log
	Logger LOG;
	
	@Inject
    @ModelQueryQualifier
    @ModelQueryType(ModelQueryType.ModelQueries.DAS)
    private ModelQuery model;
	
	public void test() {
		LOG.info(model.toString());
	}
}