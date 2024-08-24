package com.enriquers.prices.application.price.port;

import com.enriquers.prices.domain.price.model.Price;
import com.enriquers.prices.domain.price.model.PriceQuery;
import java.util.List;

public interface PriceInPort {

  List<Price> findAll();

  Price findPVP(PriceQuery request);
}
