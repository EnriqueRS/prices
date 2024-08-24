package com.enriquers.prices;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PriceTestsHelper {

  //Test1
  static LocalDateTime REQUEST_TIME_1 = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
  static Integer PRODUCT_ID_1 = 35455;
  static Integer BRAND_ID_1 = 1;
  static final Integer PRICE_LIST_1 = 1;
  static final String CURRENCY_VALUE_1 = "EUR";
  static final LocalDateTime START_DATE_1 = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
  static final LocalDateTime END_DATE_1 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
  static BigDecimal FINAL_PRICE_1 = new BigDecimal("35.50");

  // Test 2
  static LocalDateTime REQUEST_TIME_2 = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
  static Integer PRODUCT_ID_2 = 35455;
  static Integer BRAND_ID_2 = 1;
  static final Integer PRICE_LIST_2 = 2;
  static final String CURRENCY_VALUE_2 = "EUR";
  static final LocalDateTime START_DATE_2 = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
  static final LocalDateTime END_DATE_2 = LocalDateTime.of(2020, 6, 14, 18, 30, 0);
  static final BigDecimal FINAL_PRICE_2 = new BigDecimal("25.45");

  //Test 3
  static LocalDateTime REQUEST_TIME_3 = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
  static Integer PRODUCT_ID_3 = 35455;
  static Integer BRAND_ID_3 = 1;
  static final Integer PRICE_LIST_3 = 1;
  static final String CURRENCY_VALUE_3 = "EUR";
  static final LocalDateTime START_DATE_3 = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
  static final LocalDateTime END_DATE_3 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
  static final BigDecimal FINAL_PRICE_3 = new BigDecimal("35.50");

  //Test 4
  static LocalDateTime REQUEST_TIME_4 = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
  static Integer PRODUCT_ID_4 = 35455;
  static Integer BRAND_ID_4 = 1;
  static final Integer PRICE_LIST_4 = 3;
  static final String CURRENCY_VALUE_4 = "EUR";
  static final LocalDateTime START_DATE_4 = LocalDateTime.of(2020, 6, 15, 0, 0, 0);
  static final LocalDateTime END_DATE_4 = LocalDateTime.of(2020, 6, 15, 11, 0, 0);
  static final BigDecimal FINAL_PRICE_4 = new BigDecimal("30.50");

  //Test 5
  static LocalDateTime REQUEST_TIME_5 = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
  static Integer PRODUCT_ID_5 = 35455;
  static Integer BRAND_ID_5 = 1;
  static Integer PRICE_LIST_5 = 4;
  static final String CURRENCY_VALUE_5 = "EUR";
  static final LocalDateTime START_DATE_5 = LocalDateTime.of(2020, 6, 15, 16, 0, 0);
  static final LocalDateTime END_DATE_5 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
  static final BigDecimal FINAL_PRICE_5 = new BigDecimal("38.95");

  //Integration Test
  static final String BASE_ENDPOINT = "/api/v1/prices";
  static final String PVP_ENDPOINT =
      BASE_ENDPOINT + "/pvp?brandId={brandId}&productId={productId}&requestTime={requestTime}";
  static final String INTEGRATION_REQUEST_TIME = "14.06.2020 10:00:00";
  static final String INTEGRATION_REQUEST_TIME_INVALID = "14.06.2021 10:00:00";
  static final Integer INTEGRATION_BRAND_ID = 1;
  static final Integer INTEGRATION_PRODUCT_ID = 35455;
  static final Integer INTEGRATION_PRICE_LIST = 1;
  static final LocalDateTime INTEGRATION_START_DATE = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
  static final LocalDateTime INTEGRATION_END_DATE = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
  static BigDecimal INTEGRATION_FINAL_PRICE = new BigDecimal("35.50");
}
