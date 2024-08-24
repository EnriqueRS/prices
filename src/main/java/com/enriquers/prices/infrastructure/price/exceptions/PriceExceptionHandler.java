package com.enriquers.prices.infrastructure.price.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class PriceExceptionHandler {

  @ExceptionHandler(PriceException.class)
  public ResponseEntity<PriceError> handlePriceException(PriceException e) {
    log.error("Price exception", e);
    PriceError error = new PriceError(e.getMessage());
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(PriceNotFoundException.class)
  public ResponseEntity<PriceError> handlePriceNotFoundException(PriceNotFoundException e) {
    log.error("Price not found exception", e);
    PriceError error = new PriceError(e.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<PriceError> handleException(Exception e) {
    log.error("Internal server error", e);
    PriceError error = new PriceError(e.getMessage());
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
