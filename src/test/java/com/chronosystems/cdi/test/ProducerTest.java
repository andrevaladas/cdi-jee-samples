package com.chronosystems.cdi.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.chronosystems.cdi.producers.NumberPrinter;

@RunWith(WeldJUnit4Runner.class)
public class ProducerTest {

    @Inject
    private NumberPrinter numberPrinter;

    @Test
    public void testCDI() {
    	numberPrinter.print();
    	numberPrinter.print();
    	numberPrinter.print();
    }

}
