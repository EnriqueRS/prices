package com.enriquers.prices.infrastructure.price.rest.controller;

import com.enriquers.prices.infrastructure.price.rest.dto.PriceResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/prices")
@Tag(name="PriceController", description="Controller for retrieving prices and PVP price")
public interface PriceControllerAPI {

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @Operation(summary = "View a list of available prices")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully retrieved prices",
      content = @Content(schema = @Schema(implementation = PriceResponseDTO.class))),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  List<PriceResponseDTO> findAll();

  @GetMapping("/pvp")
  @ResponseStatus(HttpStatus.OK)
  @Operation(summary = "Get PVP price for a product and brand at a specific time")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully retrieved PVP price",
          content = @Content(schema = @Schema(implementation = PriceResponseDTO.class))),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "500", description = "Internal server error"),
      @ApiResponse(responseCode = "404", description = "PVP price not found"),
      @ApiResponse(responseCode = "500", description = "Parse error in request time")
  })
  PriceResponseDTO findPVP(
      @Parameter(description = "Request time in format dd.MM.yyyy hh:mm:ss",
      example = "14.06.2020 10:00:00",
      required = true)
      @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm:ss") Date requestTime,
      @Parameter(description = "Product identifier", example = "35455", required = true)
      @RequestParam Integer productId,
      @Parameter(description = "Brand identifier", example = "1", required = true)
      @RequestParam Integer brandId);
}
