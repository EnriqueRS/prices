package com.enriquers.prices.infrastructure.price.exceptions;

import java.time.OffsetDateTime;

public class PriceNotFoundException extends RuntimeException {

  private static final String PVP_NOT_FOUND = "PVP price not found for product {productId} and brand {brandId} at {requestTime}.";

    public PriceNotFoundException(String message) {
      super(message);
    }

    public PriceNotFoundException(Integer productId, Integer brandId, OffsetDateTime requestTime) {
      super( PVP_NOT_FOUND.replace("{productId}", productId.toString())
                          .replace("{brandId}", brandId.toString())
                          .replace("{requestTime}", requestTime.toString()));
    }

    public PriceNotFoundException(String message, Throwable cause) {
      super(message, cause);
    }
}
