package com.connectmanaged.webbasedprogramlauncher.exception;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class TicketServiceExceptionHandler {
	
	@Value("${app.version}")
	private String appVersion;
	
	@ExceptionHandler(value = BindException.class)
	public ModelAndView bindException(BindException exception) {
		ModelAndView model= new ModelAndView("error");
		model.addObject("timestamp", LocalDate.now());
		model.addObject("message", exception.getMessage());
		model.addObject("exception", exception);
		model.addObject("currentversion",appVersion);
		return model;
	}


	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView nullPointerException(NullPointerException exception) {
		ModelAndView model= new ModelAndView("error");
		model.addObject("timestamp", LocalDate.now());
		model.addObject("message", exception.getMessage());
		model.addObject("exception", exception);
		model.addObject("currentversion",appVersion);
		return model;
	}

	@ExceptionHandler(value = {TicketServiceException.class,RuntimeException.class})
	public ModelAndView ticketServiceException(TicketServiceException exception) {
		ModelAndView model= new ModelAndView("error");
		model.addObject("timestamp", LocalDate.now());
		model.addObject("message", exception.getMessage());
		model.addObject("exception", exception);
		model.addObject("currentversion",appVersion);
		return model;
	}
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception exception) {
		ModelAndView model= new ModelAndView("error");
		model.addObject("timestamp", LocalDate.now());
		model.addObject("message", exception.getMessage());
		model.addObject("exception", exception);
		model.addObject("currentversion",appVersion);
		return model;
	}

}
