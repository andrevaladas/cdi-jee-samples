package com.chronosystems.cdi.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import com.chronosystems.cdi.Log;
import com.chronosystems.cdi.stereotypes.LoginAction;

@RunWith(WeldJUnit4Runner.class)
public class StereotypeTest {

	@Inject	@Log
	private Logger LOG;
	
    @Inject
    private LoginAction loginAction;

    @Test
    public void testCDI() {
        String executed = loginAction.execute();
        LOG.info(String.format("The final return is: %s", executed));
    }

}
