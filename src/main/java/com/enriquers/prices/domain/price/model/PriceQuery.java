package com.enriquers.prices.domain.price.model;

import java.time.LocalDateTime;

public record PriceQuery(LocalDateTime requestTime, Integer productId, Integer brandId) {

}
