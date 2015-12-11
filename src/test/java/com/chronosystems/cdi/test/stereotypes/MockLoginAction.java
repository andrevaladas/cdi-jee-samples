package com.chronosystems.cdi.test.stereotypes;

import com.chronosystems.cdi.stereotypes.Action;
import com.chronosystems.cdi.stereotypes.LoginAction;

@Action
@Mock
//@Priority(Interceptor.Priority.APPLICATION)
public class MockLoginAction extends LoginAction {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() {
		return "MockLoginAction";
	}
	
}