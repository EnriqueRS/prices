package com.enriquers.prices.infrastructure.price.persistence.mapper;


import com.enriquers.prices.domain.price.model.Price;
import com.enriquers.prices.infrastructure.price.persistence.model.PriceEntity;
import java.util.List;

public class PriceMapper {

  private PriceMapper() {
  }

  public static Price toDomain(PriceEntity priceEntity) {
    if (priceEntity == null)  {
      return null;
    }
    return Price.builder()
        .id(priceEntity.getId())
        .brandId(priceEntity.getBrandId())
        .startDate(priceEntity.getStartDate())
        .endDate(priceEntity.getEndDate())
        .priceList(priceEntity.getPriceList())
        .productId(priceEntity.getProductId())
        .priority(priceEntity.getPriority())
        .finalPrice(priceEntity.getFinalPrice())
        .curr(priceEntity.getCurr())
        .build();
  }

  public static List<Price> toDomain(List<PriceEntity> priceEntities) {
    return priceEntities.stream().map(PriceMapper::toDomain).toList();
  }

}
