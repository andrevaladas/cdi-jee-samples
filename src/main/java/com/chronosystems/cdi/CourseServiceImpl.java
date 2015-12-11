package com.chronosystems.cdi;

import javax.inject.Inject;

import org.slf4j.Logger;

public class CourseServiceImpl implements CourseService {

	@Inject	@Log
	private Logger LOG;

	@Override
	public void registerCourse(String course) {
		LOG.info("adding course: " + course);
	}

}