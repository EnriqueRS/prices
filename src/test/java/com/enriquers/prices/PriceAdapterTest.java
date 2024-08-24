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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.enriquers.prices.domain.price.model.Price;
import com.enriquers.prices.domain.price.model.PriceQuery;
import com.enriquers.prices.infrastructure.price.persistence.PriceRepository;
import com.enriquers.prices.infrastructure.price.persistence.adapter.PriceAdapter;
import com.enriquers.prices.infrastructure.price.persistence.model.PriceEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
class PriceAdapterTest {

  @Mock
  private PriceRepository priceRepository;

  @InjectMocks
  private PriceAdapter priceAdapter;

  @Test
  @DisplayName("Given existing price, when findPrice is called, then returns expected price (Test 1)")
  void givenExistingPrice_whenFindPrice_thenReturnsPriceTest1() {
    LocalDateTime requestTime = REQUEST_TIME_1;
    Integer productId = PRODUCT_ID_1;
    Integer brandId = BRAND_ID_1;

    Mockito.when(priceRepository.findPVP(brandId, productId, requestTime))
        .thenReturn(Optional.of(PriceEntity.builder()
            .brandId(BRAND_ID_1)
            .productId(PRODUCT_ID_1)
            .priceList(PRICE_LIST_1)
            .curr(CURRENCY_VALUE_1)
            .finalPrice(FINAL_PRICE_1)
            .startDate(START_DATE_1)
            .endDate(END_DATE_1)
            .build()));

    Price priceExpected = Price.builder()
        .brandId(BRAND_ID_1)
        .productId(PRODUCT_ID_1)
        .priceList(PRICE_LIST_1)
        .curr(CURRENCY_VALUE_1)
        .finalPrice(FINAL_PRICE_1)
        .startDate(START_DATE_1)
        .endDate(END_DATE_1)
        .build();

    PriceQuery priceQuery = new PriceQuery(requestTime, productId, brandId);
    Price priceResult = priceAdapter.findPrice(priceQuery);

    assertNotNull(priceResult);
    assertEquals(priceExpected.getId(), priceResult.getId());
    assertEquals(priceExpected.getBrandId(), priceResult.getBrandId());
    assertEquals(priceExpected.getProductId(), priceResult.getProductId());
    assertEquals(priceExpected.getPriceList(), priceResult.getPriceList());
    assertEquals(priceExpected.getCurr(), priceResult.getCurr());
    assertEquals(priceExpected.getFinalPrice(), priceResult.getFinalPrice());
    assertEquals(priceExpected.getStartDate(), priceResult.getStartDate());
    assertEquals(priceExpected.getEndDate(), priceResult.getEndDate());
  }

  @Test
  @DisplayName("Given existing price, when findPrice is called, then returns expected price (Test 2)")
  void givenExistingPrice_whenFindPrice_thenReturnsPriceTest2() {
    LocalDateTime requestTime = REQUEST_TIME_2;
    Integer productId = PRODUCT_ID_2;
    Integer brandId = BRAND_ID_2;

    Mockito.when(priceRepository.findPVP(brandId, productId, requestTime))
        .thenReturn(Optional.of(PriceEntity.builder()
            .brandId(BRAND_ID_2)
            .productId(PRODUCT_ID_2)
            .priceList(PRICE_LIST_2)
            .curr(CURRENCY_VALUE_2)
            .finalPrice(FINAL_PRICE_2)
            .startDate(START_DATE_2)
            .endDate(END_DATE_2)
            .build()));

    Price priceExpected = Price.builder()
        .brandId(BRAND_ID_2)
        .productId(PRODUCT_ID_2)
        .priceList(PRICE_LIST_2)
        .curr(CURRENCY_VALUE_2)
        .finalPrice(FINAL_PRICE_2)
        .startDate(START_DATE_2)
        .endDate(END_DATE_2)
        .build();

    PriceQuery priceQuery = new PriceQuery(requestTime, productId, brandId);
    Price priceResult = priceAdapter.findPrice(priceQuery);

    assertNotNull(priceResult);
    assertEquals(priceExpected.getId(), priceResult.getId());
    assertEquals(priceExpected.getBrandId(), priceResult.getBrandId());
    assertEquals(priceExpected.getProductId(), priceResult.getProductId());
    assertEquals(priceExpected.getPriceList(), priceResult.getPriceList());
    assertEquals(priceExpected.getCurr(), priceResult.getCurr());
    assertEquals(priceExpected.getFinalPrice(), priceResult.getFinalPrice());
    assertEquals(priceExpected.getStartDate(), priceResult.getStartDate());
    assertEquals(priceExpected.getEndDate(), priceResult.getEndDate());
  }

  @Test
  @DisplayName("Given existing price, when findPrice is called, then returns expected price (Test 3)")
  void givenExistingPrice_whenFindPrice_thenReturnsPriceTest3() {
    LocalDateTime requestTime = REQUEST_TIME_3;
    Integer productId = PRODUCT_ID_3;
    Integer brandId = BRAND_ID_3;

    Mockito.when(priceRepository.findPVP(brandId, productId, requestTime))
        .thenReturn(Optional.of(PriceEntity.builder()
            .brandId(BRAND_ID_3)
            .productId(PRODUCT_ID_3)
            .priceList(PRICE_LIST_3)
            .curr(CURRENCY_VALUE_3)
            .finalPrice(FINAL_PRICE_3)
            .startDate(START_DATE_3)
            .endDate(END_DATE_3)
            .build()));

    PriceQuery priceQuery = new PriceQuery(requestTime, productId, brandId);
    Price priceResult = priceAdapter.findPrice(priceQuery);

    assertNotNull(priceResult);
    assertEquals(BRAND_ID_3, priceResult.getBrandId());
    assertEquals(PRODUCT_ID_3, priceResult.getProductId());
    assertEquals(PRICE_LIST_3, priceResult.getPriceList());
    assertEquals(CURRENCY_VALUE_3, priceResult.getCurr());
    assertEquals(FINAL_PRICE_3, priceResult.getFinalPrice());
    assertEquals(START_DATE_3, priceResult.getStartDate());
    assertEquals(END_DATE_3, priceResult.getEndDate());
  }

  @Test
  @DisplayName("Given existing price, when findPrice is called, then returns expected price (Test 4)")
  void givenExistingPrice_whenFindPrice_thenReturnsPriceTest4() {
    LocalDateTime requestTime = REQUEST_TIME_4;
    Integer productId = PRODUCT_ID_4;
    Integer brandId = BRAND_ID_4;

    Mockito.when(priceRepository.findPVP(brandId, productId, requestTime))
        .thenReturn(Optional.of(PriceEntity.builder()
            .brandId(BRAND_ID_4)
            .productId(PRODUCT_ID_4)
            .priceList(PRICE_LIST_4)
            .curr(CURRENCY_VALUE_4)
            .finalPrice(FINAL_PRICE_4)
            .startDate(START_DATE_4)
            .endDate(END_DATE_4)
            .build()));

    Price priceExpected = Price.builder()
        .brandId(BRAND_ID_4)
        .productId(PRODUCT_ID_4)
        .priceList(PRICE_LIST_4)
        .curr(CURRENCY_VALUE_4)
        .finalPrice(FINAL_PRICE_4)
        .startDate(START_DATE_4)
        .endDate(END_DATE_4)
        .build();

    PriceQuery priceQuery = new PriceQuery(requestTime, productId, brandId);
    Price priceResult = priceAdapter.findPrice(priceQuery);

    assertNotNull(priceResult);
    assertEquals(priceExpected.getId(), priceResult.getId());
    assertEquals(priceExpected.getBrandId(), priceResult.getBrandId());
    assertEquals(priceExpected.getProductId(), priceResult.getProductId());
    assertEquals(priceExpected.getPriceList(), priceResult.getPriceList());
    assertEquals(priceExpected.getCurr(), priceResult.getCurr());
    assertEquals(priceExpected.getFinalPrice(), priceResult.getFinalPrice());
    assertEquals(priceExpected.getStartDate(), priceResult.getStartDate());
    assertEquals(priceExpected.getEndDate(), priceResult.getEndDate());
  }

  @Test
  @DisplayName("Given existing price, when findPrice is called, then returns expected price (Test 5)")
  void givenExistingPrice_whenFindPrice_thenReturnsPriceTest5() {
    LocalDateTime requestTime = REQUEST_TIME_5;
    Integer productId = PRODUCT_ID_5;
    Integer brandId = BRAND_ID_5;

    Mockito.when(priceRepository.findPVP(brandId, productId, requestTime))
        .thenReturn(Optional.of(PriceEntity.builder()
            .brandId(BRAND_ID_5)
            .productId(PRODUCT_ID_5)
            .priceList(PRICE_LIST_5)
            .curr(CURRENCY_VALUE_5)
            .finalPrice(FINAL_PRICE_5)
            .startDate(START_DATE_5)
            .endDate(END_DATE_5)
            .build()));

    Price priceExpected = Price.builder()
        .brandId(BRAND_ID_5)
        .productId(PRODUCT_ID_5)
        .priceList(PRICE_LIST_5)
        .curr(CURRENCY_VALUE_5)
        .finalPrice(FINAL_PRICE_5)
        .startDate(START_DATE_5)
        .endDate(END_DATE_5)
        .build();

    PriceQuery priceQuery = new PriceQuery(requestTime, productId, brandId);
    Price priceResult = priceAdapter.findPrice(priceQuery);

    assertNotNull(priceResult);
    assertEquals(priceExpected.getId(), priceResult.getId());
    assertEquals(priceExpected.getBrandId(), priceResult.getBrandId());
    assertEquals(priceExpected.getProductId(), priceResult.getProductId());
    assertEquals(priceExpected.getPriceList(), priceResult.getPriceList());
    assertEquals(priceExpected.getCurr(), priceResult.getCurr());
    assertEquals(priceExpected.getFinalPrice(), priceResult.getFinalPrice());
    assertEquals(priceExpected.getStartDate(), priceResult.getStartDate());
    assertEquals(priceExpected.getEndDate(), priceResult.getEndDate());
  }

  @Test
  @DisplayName("Given non-existing price, when findPrice is called, then returns empty result")
  void givenNonExistingPrice_whenFindPrice_thenReturnsEmpty() {
    LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
    Integer productId = 1234;
    Integer brandId = 1234;

    Mockito.when(priceRepository.findPVP(brandId, productId, requestTime))
        .thenReturn(Optional.empty());

    PriceQuery priceQuery = new PriceQuery(requestTime, productId, brandId);
    Price priceResult = priceAdapter.findPrice(priceQuery);

    assertNull(priceResult);
  }

  @Test
  @DisplayName("Given non-existing price, when findPrice is called, then returns empty result (Test 2)")
  void givenNonExistingPrice_whenFindPrice_thenReturnsEmpty2() {
    LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
    Integer productId = 1234;
    Integer brandId = 1234;

    Mockito.when(priceRepository.findPVP(brandId, productId, requestTime))
        .thenReturn(Optional.empty());

    PriceQuery priceQuery = new PriceQuery(requestTime, productId, brandId);
    Price priceResult = priceAdapter.findPrice(priceQuery);

    assertNull(priceResult);
  }

  @Test
  @DisplayName("When findAllPrices is called, then returns all prices")
  void whenFindAllPrices_thenReturnsAllPrices() {
    Mockito.when(priceRepository.findAll())
        .thenReturn(List.of(
            PriceEntity.builder()
                .brandId(BRAND_ID_1)
                .productId(PRODUCT_ID_1)
                .priceList(PRICE_LIST_1)
                .curr(CURRENCY_VALUE_1)
                .finalPrice(FINAL_PRICE_1)
                .startDate(START_DATE_1)
                .endDate(END_DATE_1)
                .build(),
            PriceEntity.builder()
                .brandId(BRAND_ID_2)
                .productId(PRODUCT_ID_2)
                .priceList(PRICE_LIST_2)
                .curr(CURRENCY_VALUE_2)
                .finalPrice(FINAL_PRICE_2)
                .startDate(START_DATE_2)
                .endDate(END_DATE_2)
                .build(),
            PriceEntity.builder()
                .brandId(BRAND_ID_3)
                .productId(PRODUCT_ID_3)
                .priceList(PRICE_LIST_3)
                .curr(CURRENCY_VALUE_3)
                .finalPrice(FINAL_PRICE_3)
                .startDate(START_DATE_3)
                .endDate(END_DATE_3)
                .build(),
            PriceEntity.builder()
                .brandId(BRAND_ID_4)
                .productId(PRODUCT_ID_4)
                .priceList(PRICE_LIST_4)
                .curr(CURRENCY_VALUE_4)
                .finalPrice(FINAL_PRICE_4)
                .startDate(START_DATE_4)
                .endDate(END_DATE_4)
                .build()));
    List<Price> allPrices = priceAdapter.findAll();

    assertNotNull(allPrices);
    assertEquals(4, allPrices.size());
  }
}
