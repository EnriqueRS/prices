package com.enriquers.prices.infrastructure.price.rest.controller;

import com.enriquers.prices.application.price.port.PriceInPort;
import com.enriquers.prices.domain.price.model.Price;
import com.enriquers.prices.domain.price.model.PriceQuery;
import com.enriquers.prices.infrastructure.price.exceptions.PriceException;
import com.enriquers.prices.infrastructure.price.rest.dto.PriceResponseDTO;
import com.enriquers.prices.infrastructure.price.rest.dto.mapper.PriceDTOMapper;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PriceController implements PriceControllerAPI {
  private final PriceInPort pricePort;

  @Override
  public List<PriceResponseDTO> findAll() {
    return PriceDTOMapper.toPriceResponseDTO(pricePort.findAll());
  }

  @Override
  public PriceResponseDTO findPVP(Date requestTime, Integer productId, Integer brandId)
      throws PriceException {
    PriceQuery request = new PriceQuery(
        LocalDateTime.ofInstant(requestTime.toInstant(), ZoneId.systemDefault()), productId, brandId);
    Price pvpPrice = pricePort.findPVP(request);
    if (pvpPrice == null) {
      throw new PriceException("PVP price not found for product " + productId + " and brand " + brandId + " at " + requestTime + ".");
    }
    return PriceDTOMapper.toPriceResponseDTO(pvpPrice);
  }
}
