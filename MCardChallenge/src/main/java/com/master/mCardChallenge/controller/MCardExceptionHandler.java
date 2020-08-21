package com.master.mCardChallenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.master.mCardChallenge.exception.MCardException;
import com.master.mCardChallenge.exception.MCardExceptionResponse;
import com.master.mCardChallenge.exception.MCardFileException;

@ControllerAdvice
public class MCardExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ MCardException.class, Exception.class })
    public ResponseEntity<String> handleException(Exception ex) {
		/*
		 * MCardExceptionResponse mCardErrResponse=new MCardExceptionResponse();
		 * mCardErrResponse.setErrCode("M900");
		 * mCardErrResponse.setDesc("Internal Server Error");
		 */
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({ MCardFileException.class })
    public ResponseEntity<String> handleException(MCardFileException ex) {
		/*
		 * MCardExceptionResponse mCardErrResponse=new MCardExceptionResponse();
		 * mCardErrResponse.setErrCode("M901"); 
		 * mCardErrResponse.setDesc(ex.getError());
		 */
		return new ResponseEntity<String>(ex.getError(),HttpStatus.NOT_FOUND);
	}
}
