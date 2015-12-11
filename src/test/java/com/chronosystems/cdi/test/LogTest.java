package com.chronosystems.cdi.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.chronosystems.cdi.CourseService;

@RunWith(WeldJUnit4Runner.class)
public class LogTest {

    @Inject
    private CourseService courseService;

    @Test
    public void testCDI() {
        courseService.registerCourse("learning jave ee");
    }

}
