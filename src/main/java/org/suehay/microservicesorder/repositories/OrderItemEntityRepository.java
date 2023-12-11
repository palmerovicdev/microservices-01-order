package org.suehay.microservicesorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suehay.microservicesorder.models.entities.OrderItemEntity;

public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity, Long> {
}