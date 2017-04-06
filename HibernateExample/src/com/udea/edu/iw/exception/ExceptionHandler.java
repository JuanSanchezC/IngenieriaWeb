package com.udea.edu.iw.exception;

import org.apache.log4j.Logger;

/*
 * @author: juan.sanchezc@udea.edu.co
 */
public class ExceptionHandler extends Exception {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass());	

	public ExceptionHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(String message, Throwable cause) {
		super(message, cause);
		log.error(message, cause);
	}

	public ExceptionHandler(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}	
}
