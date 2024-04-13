package com.enriquers.prices.infrastructure.price.persistence.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Unique identifier of the Price.")
  private Long id;

  @Column(name = "BRAND_ID")
  @Schema(description = "foreign key of the group brand.")
  private Integer brandId;

  @Column(name = "START_DATE")
  @Schema(description = "Start date of the Price.")
  private LocalDateTime startDate;

  @Column(name = "END_DATE")
  @Schema(description = "End date of the Price.")
  private LocalDateTime endDate;

  @Column(name = "PRICE_LIST")
  @Schema(description = "Price list identifier.")
  private Integer priceList;

  @Column(name = "PRODUCT_ID")
  @Schema(description = "Product identifier.")
  private Integer productId;

  @Column(name = "PRIORITY")
  @Schema(description = "Price application disambiguator. If two rates coincide in a date range, the one with the highest priority (highest numerical value) is applied.")
  private Integer priority;

  @Column(name = "PRICE")
  @Schema(description = "Final price value.")
  private BigDecimal finalPrice;

  @Column(name = "CURR")
  @Schema(description = "Currency ISO.")
  private String curr;

}
