package com.enriquers.prices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.enriquers.prices.infrastructure.price.persistence.model.PriceEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceModelTest {
  private PriceEntity priceEntity;

  @BeforeEach
  void setUp() {
    priceEntity = new PriceEntity();
  }

  @Test
  @DisplayName("Given a PriceEntity, when setting and getting id, then it should return the correct id")
  void idTest() {
    Long id = 1L;
    priceEntity.setId(id);
    assertEquals(id, priceEntity.getId());
  }

  @Test
  @DisplayName("Given a PriceEntity, when setting and getting brandId, then it should return the correct brandId")
  void brandIdTest() {
    Integer brandId = 1;
    priceEntity.setBrandId(brandId);
    assertEquals(brandId, priceEntity.getBrandId());
  }

  @Test
  @DisplayName("Given a PriceEntity, when setting and getting startDate, then it should return the correct startDate")
  void startDateTest() {
    LocalDateTime startDate = LocalDateTime.now();
    priceEntity.setStartDate(startDate);
    assertEquals(startDate, priceEntity.getStartDate());
  }

  @Test
  @DisplayName("Given a PriceEntity, when setting and getting endDate, then it should return the correct endDate")
  void endDateTest() {
    LocalDateTime endDate = LocalDateTime.now();
    priceEntity.setEndDate(endDate);
    assertEquals(endDate, priceEntity.getEndDate());
  }

  @Test
  @DisplayName("Given a PriceEntity, when setting and getting priceList, then it should return the correct priceList")
  void priceListTest() {
    Integer priceList = 1;
    priceEntity.setPriceList(priceList);
    assertEquals(priceList, priceEntity.getPriceList());
  }

  @Test
  @DisplayName("Given a PriceEntity, when setting and getting productId, then it should return the correct productId")
  void productIdTest() {
    Integer productId = 1;
    priceEntity.setProductId(productId);
    assertEquals(productId, priceEntity.getProductId());
  }

  @Test
  @DisplayName("Given a PriceEntity, when setting and getting priority, then it should return the correct priority")
  void priorityTest() {
    Integer priority = 1;
    priceEntity.setPriority(priority);
    assertEquals(priority, priceEntity.getPriority());
  }

  @Test
  @DisplayName("Given a PriceEntity, when setting and getting finalPrice, then it should return the correct finalPrice")
  void finalPriceTest() {
    BigDecimal finalPrice = BigDecimal.valueOf(100.0);
    priceEntity.setFinalPrice(finalPrice);
    assertEquals(finalPrice, priceEntity.getFinalPrice());
  }

  @Test
  @DisplayName("Given a PriceEntity, when setting and getting curr, then it should return the correct curr")
  void currTest() {
    String curr = "EUR";
    priceEntity.setCurr(curr);
    assertEquals(curr, priceEntity.getCurr());
  }
}
