package com.connectmanaged.webbasedprogramlauncher.exception;

public class TicketServiceException extends RuntimeException{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	public TicketServiceException() {
		super();
	}

	public TicketServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TicketServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public TicketServiceException(String message) {
		super(message);
	}

	public TicketServiceException(Throwable cause) {
		super(cause);
	}
	

}
