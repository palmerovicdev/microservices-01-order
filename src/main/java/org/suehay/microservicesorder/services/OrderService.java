package org.suehay.microservicesorder.services;

import org.suehay.microservicesorder.models.request.OrderRequest;
import org.suehay.microservicesorder.models.response.OrderItemResponse;
import org.suehay.microservicesorder.models.response.OrderResponse;

import java.util.List;

public interface OrderService {

    List<OrderItemResponse> create(OrderRequest order);
    List<OrderResponse> findAll();
}