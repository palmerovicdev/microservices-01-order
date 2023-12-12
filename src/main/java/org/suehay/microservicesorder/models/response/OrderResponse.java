package org.suehay.microservicesorder.models.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonSerialize
public class OrderResponse implements java.io.Serializable{
    private String orderNumber;
    private List<OrderItemResponse> items;
    //map from OrderEntity
    public static OrderResponse fromOrderEntity(org.suehay.microservicesorder.models.entities.OrderEntity orderEntity) {
        return OrderResponse.builder()
                            .orderNumber(orderEntity.getOrderNumber())
                            .items(orderEntity.getItems().stream().map(OrderItemResponse::fromOrderEntity).collect(java.util.stream.Collectors.toList()))
                            .build();
    }
}