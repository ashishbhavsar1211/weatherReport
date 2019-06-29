package com.mobiquity.weather.exception;

import java.nio.file.AccessDeniedException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

	public RestResponseExceptionHandler() {
		super();
	}
	
	@Override
	protected final ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST,
				request);
	}
	
	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<Object> handleAccessDeniedException(final Exception ex, final WebRequest request) {
		System.out.println("request" + request.getUserPrincipal());
		return new ResponseEntity<Object>("Access denied", new HttpHeaders(), HttpStatus.FORBIDDEN);
	}

	private Object message(HttpStatus badRequest, HttpMessageNotReadableException ex) {
		String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
		String devMessage = ExceptionUtils.getRootCauseMessage(ex);
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST, message, devMessage);
		return error;
	}
}
