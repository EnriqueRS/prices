package com.enriquers.prices.infrastructure.price.exceptions;

public class PriceException extends RuntimeException {

  private static final String PVP_NOT_FOUND = "PVP not found";

    public PriceException(String message) {
      super(message);
    }

    public PriceException(String message, Throwable cause) {
      super(message, cause);
    }
}
