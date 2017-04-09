package co.edu.udea.iw.exception;

import co.edu.udea.iw.logs.Log4jLoggerOwn;

/*
 * @author juan.sanchezc@udea.edu.co
 */

/*
 * Clase para manejar la excepciones ocurridas en la ejecucion del proyecto
 */
public class ExceptionHandler extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionHandler() {
		super();
	}

	public ExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExceptionHandler(String message, Throwable cause) {
		super(message, cause);
		Log4jLoggerOwn.log.error(message);
	}

	public ExceptionHandler(String message) {
		super(message);
	}

	public ExceptionHandler(Throwable cause) {
		super(cause);
	}
	
	
}
