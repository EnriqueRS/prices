package com.enriquers.prices.infrastructure.price.rest.dto.mapper;

import com.enriquers.prices.domain.price.model.Price;
import com.enriquers.prices.infrastructure.price.rest.dto.PriceResponseDTO;
import java.util.Collections;
import java.util.List;

public class PriceDTOMapper {

  PriceDTOMapper() {
  }

  public static PriceResponseDTO toPriceResponseDTO(Price price) {
    if (price == null) {
      return null;
    }
    return new PriceResponseDTO(price.getProductId(), price.getBrandId(), price.getPriceList(), price.getStartDate(), price.getEndDate(), price.getFinalPrice());
  }

  public static List<PriceResponseDTO> toPriceResponseDTO(List<Price> priceList) {
    if (priceList == null) {
      return Collections.emptyList();
    }
    return priceList.stream().map(PriceDTOMapper::toPriceResponseDTO).toList();
  }
}
