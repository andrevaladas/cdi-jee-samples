package com.chronosystems.cdi.test;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.chronosystems.cdi.events.PaymentBean;

@RunWith(WeldJUnit4Runner.class)
public class EventsTest {

    @Inject
    private PaymentBean bean;

    @Test
    public void testCDI() {
        bean.setPaymentOption(PaymentBean.CREDIT);
        bean.setValue(new BigDecimal(100));
        bean.pay();
        
        bean.setPaymentOption(PaymentBean.DEBIT);
        bean.setValue(new BigDecimal(50));
        bean.pay();
    }

}
