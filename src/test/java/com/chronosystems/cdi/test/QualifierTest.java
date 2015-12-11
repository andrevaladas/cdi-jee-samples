package com.chronosystems.cdi.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import com.chronosystems.cdi.Log;
import com.chronosystems.cdi.qualifiers.Greeting;
import com.chronosystems.cdi.qualifiers.Informal;

@RunWith(WeldJUnit4Runner.class)
public class QualifierTest {

    @Inject
    private Greeting greeting;

    @Inject @Informal
    private Greeting greetingInformal;

    @Inject	@Log
	private Logger LOG;

    @Test
    public void testCDI() {
    	LOG.info("greeting @default: " + greeting.greet("valadas"));
    }

    @Test
    public void testCDI2() {
    	LOG.info("greeting with qualifier @Informal: " + greetingInformal.greet("valadas"));
    }
}
