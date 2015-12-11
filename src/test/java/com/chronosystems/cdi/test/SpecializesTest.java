package com.chronosystems.cdi.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.chronosystems.cdi.specializes.Asynchronous;
import com.chronosystems.cdi.specializes.Service;

@RunWith(WeldJUnit4Runner.class)
public class SpecializesTest {

    @Inject
    private Service service;

    @Inject @Asynchronous
    private Service service2;

    @Test
    public void testCDI() {
        service.execute();
        service2.execute();
    }

}
