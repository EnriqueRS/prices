package com.enriquers.prices.application.price.adapter;


import com.enriquers.prices.application.price.port.PriceInPort;
import com.enriquers.prices.application.price.port.PriceOutPort;
import com.enriquers.prices.domain.price.model.Price;
import com.enriquers.prices.domain.price.model.PriceQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceInAdapter implements PriceInPort {

  private final PriceOutPort port;


  @Override
  public List<Price> findAll() {
    return port.findAll();
  }

  @Override
  public Price findPVP(PriceQuery priceQuery) {
    return port.findPrice(priceQuery);
  }
}
