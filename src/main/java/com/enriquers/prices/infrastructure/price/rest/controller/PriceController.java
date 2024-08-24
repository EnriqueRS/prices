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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/prices")
public class PriceController {
  private final PriceInPort pricePort;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<PriceResponseDTO> findAll() {
    return PriceDTOMapper.toPriceResponseDTO(pricePort.findAll());
  }

  @GetMapping("/pvp")
  @ResponseStatus(HttpStatus.OK)
  public PriceResponseDTO findPVP(
      @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm:ss") Date requestTime,
      @RequestParam  Integer productId,
      @RequestParam Integer brandId) {
    PriceQuery request = new PriceQuery(
        LocalDateTime.ofInstant(requestTime.toInstant(), ZoneId.systemDefault()), productId, brandId);
    Price pvpPrice = pricePort.findPVP(request);
    if (pvpPrice == null) {
      throw new PriceException("PVP price not found for product " + productId + " and brand " + brandId + " at " + requestTime + ".");
    }
    return PriceDTOMapper.toPriceResponseDTO(pvpPrice);
  }
}
