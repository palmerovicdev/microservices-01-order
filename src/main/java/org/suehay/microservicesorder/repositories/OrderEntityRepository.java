package org.suehay.microservicesorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suehay.microservicesorder.models.entities.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
}