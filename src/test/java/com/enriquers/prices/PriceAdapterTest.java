package com.enriquers.prices;

import static com.enriquers.prices.PriceTestsHelper.BRAND_ID_1;
import static com.enriquers.prices.PriceTestsHelper.BRAND_ID_2;
import static com.enriquers.prices.PriceTestsHelper.BRAND_ID_3;
import static com.enriquers.prices.PriceTestsHelper.BRAND_ID_4;
import static com.enriquers.prices.PriceTestsHelper.BRAND_ID_5;
import static com.enriquers.prices.PriceTestsHelper.CURRENCY_VALUE_1;
import static com.enriquers.prices.PriceTestsHelper.CURRENCY_VALUE_2;
import static com.enriquers.prices.PriceTestsHelper.CURRENCY_VALUE_3;
import static com.enriquers.prices.PriceTestsHelper.CURRENCY_VALUE_4;
import static com.enriquers.prices.PriceTestsHelper.CURRENCY_VALUE_5;
import static com.enriquers.prices.PriceTestsHelper.END_DATE_1;
import static com.enriquers.prices.PriceTestsHelper.END_DATE_2;
import static com.enriquers.prices.PriceTestsHelper.END_DATE_3;
import static com.enriquers.prices.PriceTestsHelper.END_DATE_4;
import static com.enriquers.prices.PriceTestsHelper.END_DATE_5;
import static com.enriquers.prices.PriceTestsHelper.FINAL_PRICE_1;
import static com.enriquers.prices.PriceTestsHelper.FINAL_PRICE_2;
import static com.enriquers.prices.PriceTestsHelper.FINAL_PRICE_3;
import static com.enriquers.prices.PriceTestsHelper.FINAL_PRICE_4;
import static com.enriquers.prices.PriceTestsHelper.FINAL_PRICE_5;
import static com.enriquers.prices.PriceTestsHelper.PRICE_LIST_1;
import static com.enriquers.prices.PriceTestsHelper.PRICE_LIST_2;
import static com.enriquers.prices.PriceTestsHelper.PRICE_LIST_3;
import static com.enriquers.prices.PriceTestsHelper.PRICE_LIST_4;
import static com.enriquers.prices.PriceTestsHelper.PRICE_LIST_5;
import static com.enriquers.prices.PriceTestsHelper.PRODUCT_ID_1;
import static com.enriquers.prices.PriceTestsHelper.PRODUCT_ID_2;
import static com.enriquers.prices.PriceTestsHelper.PRODUCT_ID_3;
import static com.enriquers.prices.PriceTestsHelper.PRODUCT_ID_4;
import static com.enriquers.prices.PriceTestsHelper.PRODUCT_ID_5;
import static com.enriquers.prices.PriceTestsHelper.REQUEST_TIME_1;
import static com.enriquers.prices.PriceTestsHelper.REQUEST_TIME_2;
import static com.enriquers.prices.PriceTestsHelper.REQUEST_TIME_3;
import static com.enriquers.prices.PriceTestsHelper.REQUEST_TIME_4;
import static com.enriquers.prices.PriceTestsHelper.REQUEST_TIME_5;
import static com.enriquers.prices.PriceTestsHelper.START_DATE_1;
import static com.enriquers.prices.PriceTestsHelper.START_DATE_2;
import static com.enriquers.prices.PriceTestsHelper.START_DATE_3;
import static com.enriquers.prices.PriceTestsHelper.START_DATE_4;
import static com.enriquers.prices.PriceTestsHelper.START_DATE_5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.enriquers.prices.infrastructure.price.persistence.PriceRepository;
import com.enriquers.prices.infrastructure.price.persistence.model.PriceEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class PriceAdapterTest {

  @Autowired
  private PriceRepository priceRepository;


  @Test
  void givenExistingPrice_whenFindPrice_thenReturnsPriceTest1() {
    LocalDateTime requestTime = REQUEST_TIME_1;
    Integer productId = PRODUCT_ID_1;
    Integer brandId = BRAND_ID_1;

    Optional<PriceEntity> priceEntityOptional = priceRepository.findPVP(brandId, productId, requestTime);

    assertNotNull(priceEntityOptional);
    assertFalse(priceEntityOptional.isEmpty());
    PriceEntity price = priceEntityOptional.get();

    assertEquals(FINAL_PRICE_1, price.getFinalPrice());
    assertEquals(BRAND_ID_1, price.getBrandId());
    assertEquals(PRODUCT_ID_1, price.getProductId());
    assertEquals(PRICE_LIST_1, price.getPriceList());
    assertEquals(CURRENCY_VALUE_1, price.getCurr());
    assertEquals(START_DATE_1, price.getStartDate());
    assertEquals(END_DATE_1, price.getEndDate());
  }

  @Test
  void givenExistingPrice_whenFindPrice_thenReturnsPriceTest2() {
    LocalDateTime requestTime = REQUEST_TIME_2;
    Integer productId = PRODUCT_ID_2;
    Integer brandId = BRAND_ID_2;

    Optional<PriceEntity> priceEntityOptional = priceRepository.findPVP(brandId, productId, requestTime);

    assertNotNull(priceEntityOptional);
    assertFalse(priceEntityOptional.isEmpty());
    PriceEntity price = priceEntityOptional.get();

    assertEquals(FINAL_PRICE_2, price.getFinalPrice());
    assertEquals(BRAND_ID_2, price.getBrandId());
    assertEquals(PRODUCT_ID_2, price.getProductId());
    assertEquals(PRICE_LIST_2, price.getPriceList());
    assertEquals(CURRENCY_VALUE_2, price.getCurr());
    assertEquals(START_DATE_2, price.getStartDate());
    assertEquals(END_DATE_2, price.getEndDate());
  }

  @Test
  void givenExistingPrice_whenFindPrice_thenReturnsPriceTest3() {
    LocalDateTime requestTime = REQUEST_TIME_3;
    Integer productId = PRODUCT_ID_3;
    Integer brandId = BRAND_ID_3;

    Optional<PriceEntity> priceEntityOptional = priceRepository.findPVP(brandId, productId, requestTime);

    assertNotNull(priceEntityOptional);
    assertFalse(priceEntityOptional.isEmpty());
    PriceEntity price = priceEntityOptional.get();

    assertEquals(FINAL_PRICE_3, price.getFinalPrice());
    assertEquals(BRAND_ID_3, price.getBrandId());
    assertEquals(PRODUCT_ID_3, price.getProductId());
    assertEquals(PRICE_LIST_3, price.getPriceList());
    assertEquals(CURRENCY_VALUE_3, price.getCurr());
    assertEquals(START_DATE_3, price.getStartDate());
    assertEquals(END_DATE_3, price.getEndDate());
  }

  @Test
  void givenExistingPrice_whenFindPrice_thenReturnsPriceTest4() {
    LocalDateTime requestTime = REQUEST_TIME_4;
    Integer productId = PRODUCT_ID_4;
    Integer brandId = BRAND_ID_4;

    Optional<PriceEntity> priceEntityOptional = priceRepository.findPVP(brandId, productId, requestTime);

    assertNotNull(priceEntityOptional);
    assertFalse(priceEntityOptional.isEmpty());
    PriceEntity price = priceEntityOptional.get();

    assertEquals(FINAL_PRICE_4, price.getFinalPrice());
    assertEquals(BRAND_ID_4, price.getBrandId());
    assertEquals(PRODUCT_ID_4, price.getProductId());
    assertEquals(PRICE_LIST_4, price.getPriceList());
    assertEquals(CURRENCY_VALUE_4, price.getCurr());
    assertEquals(START_DATE_4, price.getStartDate());
    assertEquals(END_DATE_4, price.getEndDate());
  }

  @Test
  void givenExistingPrice_whenFindPrice_thenReturnsPriceTest5() {
    LocalDateTime requestTime = REQUEST_TIME_5;
    Integer productId = PRODUCT_ID_5;
    Integer brandId = BRAND_ID_5;

    Optional<PriceEntity> priceEntityOptional = priceRepository.findPVP(brandId, productId, requestTime);

    assertNotNull(priceEntityOptional);
    assertFalse(priceEntityOptional.isEmpty());
    PriceEntity price = priceEntityOptional.get();

    assertEquals(FINAL_PRICE_5, price.getFinalPrice());
    assertEquals(BRAND_ID_5, price.getBrandId());
    assertEquals(PRODUCT_ID_5, price.getProductId());
    assertEquals(PRICE_LIST_5, price.getPriceList());
    assertEquals(CURRENCY_VALUE_5, price.getCurr());
    assertEquals(START_DATE_5, price.getStartDate());
    assertEquals(END_DATE_5, price.getEndDate());
  }

  @Test
  void givenNonExistingPrice_whenFindPrice_thenReturnsEmpty() {
    LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
    Integer productId = 1234;
    Integer brandId = 1234;

    Optional<PriceEntity> priceEntityOptional = priceRepository.findPVP(brandId, productId, requestTime);

    assertNotNull(priceEntityOptional);
    assertTrue(priceEntityOptional.isEmpty());
  }

  @Test
  void givenNonExistingPrice_whenFindPrice_thenReturnsEmpty2() {
    LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
    Integer productId = 1234;
    Integer brandId = 1234;

    Optional<PriceEntity> priceEntityOptional = priceRepository.findPVP(brandId, productId, requestTime);

    assertNotNull(priceEntityOptional);
    assertTrue(priceEntityOptional.isEmpty());
  }

  @Test
  void whenFindAllPrices_thenReturnsAllPrices() {
    List<PriceEntity> prices = priceRepository.findAll();

    assertNotNull(prices);
    assertEquals(4, prices.size());
  }
}
