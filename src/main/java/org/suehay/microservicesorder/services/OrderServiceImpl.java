package org.suehay.microservicesorder.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.suehay.microservicesorder.models.entities.OrderEntity;
import org.suehay.microservicesorder.models.entities.OrderItemEntity;
import org.suehay.microservicesorder.models.request.OrderRequest;
import org.suehay.microservicesorder.models.response.BaseResponse;
import org.suehay.microservicesorder.models.response.OrderItemResponse;
import org.suehay.microservicesorder.models.response.OrderResponse;
import org.suehay.microservicesorder.repositories.OrderEntityRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderEntityRepository orderEntityRepository;
    private final WebClient.Builder webClient;

    @Override
    public List<OrderItemResponse> create(OrderRequest order) {
        var baseResponse = webClient.build()
                                    .post()
                                    .uri("http://localhost:8081/api/inventory/in-stock")
                                    .bodyValue(order.getItems())
                                    .retrieve()
                                    .bodyToMono(BaseResponse.class)
                                    .block();
        if (Objects.nonNull(baseResponse) && baseResponse.isSuccess()) {

            OrderEntity orderEntity = OrderEntity.builder()
                                                 .orderNumber(order.getOrderNumber())
                                                 .items(order.getItems().stream().map(orderItemRequest -> {
                                                     OrderItemEntity orderItemEntity = new OrderItemEntity();
                                                     orderItemEntity.setSku(orderItemRequest.getSku());
                                                     orderItemEntity.setPrice(orderItemRequest.getPrice());
                                                     orderItemEntity.setQuantity(orderItemRequest.getQuantity());
                                                     return orderItemEntity;
                                                 }).collect(java.util.stream.Collectors.toList())).build();
            orderEntity.getItems().forEach(orderItemEntity -> orderItemEntity.setOrder(orderEntity));
            orderEntityRepository.save(orderEntity);

            return orderEntity.getItems().stream().map(OrderItemResponse::fromOrderEntity).collect(Collectors.toList());
        } else throw new IllegalArgumentException("There is no enough stock for the order");
    }

    @Override
    public List<OrderResponse> findAll() {
        return orderEntityRepository.findAll().stream().map(OrderResponse::fromOrderEntity).collect(Collectors.toList());
    }
}