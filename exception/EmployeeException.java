package com.cg.ems.exception;

public class EmployeeException extends Exception {

	public EmployeeException(String msg)
	{
		super(msg);
	}

	public EmployeeException() {
		super();
	
	}

	public EmployeeException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0,arg1,arg2,arg3);
		
	}

	public EmployeeException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public EmployeeException(Throwable cause) {
		super(cause);
		
	}
	
	
}
