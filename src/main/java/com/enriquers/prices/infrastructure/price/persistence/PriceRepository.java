package com.enriquers.prices.infrastructure.price.persistence;


import com.enriquers.prices.infrastructure.price.persistence.model.PriceEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

  @Query("SELECT p FROM PriceEntity p "
      + "WHERE p.brandId = :brandId AND p.productId = :productId "
      + "AND :dateRequest BETWEEN p.startDate AND p.endDate "
      + "ORDER BY p.priority DESC, p.startDate DESC LIMIT 1")
  Optional<PriceEntity> findPVP(Integer brandId, Integer productId, LocalDateTime dateRequest);
}
