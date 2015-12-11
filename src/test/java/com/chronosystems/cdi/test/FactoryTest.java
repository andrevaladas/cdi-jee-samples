package com.chronosystems.cdi.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.chronosystems.cdi.factories.Das;
import com.chronosystems.cdi.factories.Dis;

@RunWith(WeldJUnit4Runner.class)
public class FactoryTest {

    @Inject
    private Das das;

    @Inject
    private Dis dis;

    @Test
    public void testCDI() {
    	das.test();
    	dis.test();
    }

}
