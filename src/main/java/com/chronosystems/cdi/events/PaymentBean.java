package com.chronosystems.cdi.events;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Inject;
import javax.validation.constraints.Digits;

import org.slf4j.Logger;

import com.chronosystems.cdi.Log;
import com.chronosystems.cdi.interceptors.Logged;

//@Named
//@SessionScoped
@ApplicationScoped
public class PaymentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject	@Log
	private Logger LOG;
	
	@Inject
    @Credit
    Event<PaymentEvent> creditEvent;

    @Inject
    @Debit
    Event<PaymentEvent> debitEvent;
    
    public static final int DEBIT = 1;
    public static final int CREDIT = 2;
    private int paymentOption = DEBIT;
    
    @Digits(integer = 10, fraction = 2, message = "Invalid value")
    private BigDecimal value;

    private Date datetime;
    
    @Logged
    public String pay() {
        this.setDatetime(Calendar.getInstance().getTime());
        switch (paymentOption) {
            case DEBIT:
                PaymentEvent debitPayload = new PaymentEvent();
                debitPayload.setPaymentType("Debit");
                debitPayload.setValue(value);
                debitPayload.setDatetime(datetime);
                debitEvent.fire(debitPayload);
                break;
            case CREDIT:
                PaymentEvent creditPayload = new PaymentEvent();
                creditPayload.setPaymentType("Credit");
                creditPayload.setValue(value);
                creditPayload.setDatetime(datetime);
                creditEvent.fire(creditPayload);
                break;
            default:
            	LOG.error("Invalid payment option!");
        }
        return "response";
    }
    
    @Logged
    public void reset() {
        setPaymentOption(DEBIT);
        setValue(BigDecimal.ZERO);
    }

    /**
     * IF_EXISTS @Observes
     * 
     * @param event
     */
    public void customCreditPayment(@Observes(notifyObserver=Reception.IF_EXISTS) @Credit PaymentEvent event) {
    	LOG.info(String.format("@Observes IF_EXISTS PaymentHandler - Credit Handler: %s{0}", event.toString()));
    }

	public int getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(int paymentOption) {
		this.paymentOption = paymentOption;
	}

	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}