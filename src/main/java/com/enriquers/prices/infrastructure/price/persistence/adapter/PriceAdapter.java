package com.enriquers.prices.infrastructure.price.persistence.adapter;


import com.enriquers.prices.application.price.port.PriceOutPort;
import com.enriquers.prices.domain.price.model.Price;
import com.enriquers.prices.domain.price.model.PriceQuery;
import com.enriquers.prices.infrastructure.price.exceptions.PriceException;
import com.enriquers.prices.infrastructure.price.persistence.PriceRepository;
import com.enriquers.prices.infrastructure.price.persistence.mapper.PriceMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriceAdapter implements PriceOutPort {

  private final PriceRepository priceRepository;

  @Override
  public List<Price> findAll() {
    return PriceMapper.toDomain(priceRepository.findAll());
  }

  @Override
  public Price findPrice(PriceQuery priceQuery) throws PriceException {
    return priceRepository.findPVP(priceQuery.brandId(), priceQuery.productId(),
            priceQuery.requestTime())
        .map(PriceMapper::toDomain)
        .orElse(null);
  }

}
