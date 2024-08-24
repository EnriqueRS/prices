package com.enriquers.prices;


import static com.enriquers.prices.PriceTestsHelper.BASE_ENDPOINT;
import static com.enriquers.prices.PriceTestsHelper.INTEGRATION_BRAND_ID;
import static com.enriquers.prices.PriceTestsHelper.INTEGRATION_END_DATE;
import static com.enriquers.prices.PriceTestsHelper.INTEGRATION_FINAL_PRICE;
import static com.enriquers.prices.PriceTestsHelper.INTEGRATION_PRICE_LIST;
import static com.enriquers.prices.PriceTestsHelper.INTEGRATION_PRODUCT_ID;
import static com.enriquers.prices.PriceTestsHelper.INTEGRATION_REQUEST_TIME;
import static com.enriquers.prices.PriceTestsHelper.INTEGRATION_REQUEST_TIME_INVALID;
import static com.enriquers.prices.PriceTestsHelper.INTEGRATION_START_DATE;
import static com.enriquers.prices.PriceTestsHelper.PVP_ENDPOINT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.enriquers.prices.infrastructure.price.rest.dto.PriceResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceIntegrationTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void givenValidRequest_whenGetPvp_thenReturnsExpectedPrice() {
    final String finalUrl = PVP_ENDPOINT
        .replace("{brandId}", INTEGRATION_BRAND_ID.toString())
        .replace("{productId}", INTEGRATION_PRODUCT_ID.toString())
        .replace("{requestTime}", INTEGRATION_REQUEST_TIME);
    ResponseEntity<PriceResponseDTO> response = restTemplate.getForEntity(finalUrl,
        PriceResponseDTO.class);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    PriceResponseDTO priceResponseDTO = response.getBody();
    assertNotNull(priceResponseDTO);

    assertEquals(INTEGRATION_FINAL_PRICE, priceResponseDTO.finalPrice());
    assertEquals(INTEGRATION_PRICE_LIST, priceResponseDTO.priceList());
    assertEquals(INTEGRATION_PRODUCT_ID, priceResponseDTO.productId());
    assertEquals(INTEGRATION_BRAND_ID, priceResponseDTO.brandId());
    assertEquals(INTEGRATION_START_DATE, priceResponseDTO.startDate());
    assertEquals(INTEGRATION_END_DATE, priceResponseDTO.endDate());
  }

  @Test
  void givenInvalidRequest_whenGetPvp_thenReturnsNotFound() {
    final String finalUrl = PVP_ENDPOINT
        .replace("{brandId}", INTEGRATION_BRAND_ID.toString())
        .replace("{productId}", INTEGRATION_PRODUCT_ID.toString())
        .replace("{requestTime}", INTEGRATION_REQUEST_TIME_INVALID);
    ResponseEntity<PriceResponseDTO> response = restTemplate.getForEntity(finalUrl,
        PriceResponseDTO.class);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  void givenValidRequest_whenGetAll_thenReturnsAllPrices() {
    ResponseEntity<PriceResponseDTO[]> response = restTemplate.getForEntity(BASE_ENDPOINT,
        PriceResponseDTO[].class);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    PriceResponseDTO[] priceResponseDTO = response.getBody();
    assertNotNull(priceResponseDTO);

    assertEquals(INTEGRATION_FINAL_PRICE, priceResponseDTO[0].finalPrice());
    assertEquals(INTEGRATION_PRICE_LIST, priceResponseDTO[0].priceList());
    assertEquals(INTEGRATION_PRODUCT_ID, priceResponseDTO[0].productId());
    assertEquals(INTEGRATION_BRAND_ID, priceResponseDTO[0].brandId());
    assertEquals(INTEGRATION_START_DATE, priceResponseDTO[0].startDate());
    assertEquals(INTEGRATION_END_DATE, priceResponseDTO[0].endDate());
  }
}
