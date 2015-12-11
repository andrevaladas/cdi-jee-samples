package com.chronosystems.cdi.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import com.chronosystems.cdi.Log;
import com.chronosystems.cdi.alternatives.Coder;

@RunWith(WeldJUnit4Runner.class)
public class AlternativeTest {

	@Inject	@Log
	private Logger LOG;
	
    @Inject
    private Coder coder;

    @Test
    public void testCDI() {
        String executed = coder.execute();
        LOG.info(String.format("The final return is: %s", executed));
    }

}
