package com.enriquers.prices.application.price.port;


import com.enriquers.prices.domain.price.model.Price;
import com.enriquers.prices.domain.price.model.PriceQuery;
import java.util.List;

public interface PriceOutPort {

  List<Price> findAll();

  Price findPrice(PriceQuery priceQuery);

}
