package org.suehay.microservicesorder.services;

import org.suehay.microservicesorder.models.request.OrderRequest;
import org.suehay.microservicesorder.models.response.OrderResponse;

public interface OrderService {

    OrderResponse create(OrderRequest order);
}