package com.enriquers.prices.infrastructure.price.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceResponseDTO(Integer productId, Integer brandId, Integer priceList, LocalDateTime startDate, LocalDateTime endDate, BigDecimal finalPrice) {

}
