package com.chronosystems.cdi.events;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import static javax.enterprise.event.TransactionPhase.*;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.chronosystems.cdi.Log;
import com.chronosystems.cdi.interceptors.Logged;

@Logged
//@SessionScoped
@ApplicationScoped
public class PaymentHandler implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject	@Log
	private Logger LOG;

    public void creditPayment(@Observes @Credit PaymentEvent event) {
    	LOG.info(String.format("PaymentHandler - Credit Handler: %s", event.toString()));

        // call a specific Credit handler class...
    }
    public void beforeCompletion(@Observes(during=BEFORE_COMPLETION) @Credit PaymentEvent event) {
    	LOG.info(String.format("PaymentHandler - Credit Handler BEFORE_COMPLETION: %s", event.toString()));
    }
    public void afterSuccess(@Observes(during=AFTER_SUCCESS) @Credit PaymentEvent event) {
    	LOG.info(String.format("PaymentHandler - Credit Handler AFTER_SUCCESS: %s", event.toString()));
    }
    public void afterCompletion(@Observes(during=AFTER_COMPLETION) @Credit PaymentEvent event) {
    	LOG.info(String.format("PaymentHandler - Credit Handler AFTER_COMPLETION: %s", event.toString()));
    }
    public void afterFailure(@Observes(during=AFTER_FAILURE) @Credit PaymentEvent event) {
    	LOG.info(String.format("PaymentHandler - Credit Handler AFTER_FAILURE: %s", event.toString()));
    }
    
    
    public void debitPayment(@Observes @Debit PaymentEvent event) {
    	LOG.info(String.format("PaymentHandler - Debit Handler: %s", event.toString()));
 
        // call a specific Debit handler class...
    }
}