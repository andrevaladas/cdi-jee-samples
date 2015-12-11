package com.chronosystems.cdi.stereotypes;

import java.io.Serializable;

@Action
public class LoginAction implements Serializable {

	private static final long serialVersionUID = 1L;

	public String execute() {
		return "LoginAction";
	}

}
