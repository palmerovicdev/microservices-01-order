package org.suehay.microservicesorder.models.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@JsonSerialize
public class OrderItemResponse implements java.io.Serializable {
    private Long id;
    private String orderNumber;
    private String sku;
    private Double price;
    private Integer quantity;

    //map from OrderEntity
    public static OrderItemResponse fromOrderEntity(org.suehay.microservicesorder.models.entities.OrderItemEntity orderEntity) {
        return OrderItemResponse.builder()
                                .id(orderEntity.getId())
                                .orderNumber(orderEntity.getOrder().getOrderNumber())
                                .sku(orderEntity.getSku())
                                .price(orderEntity.getPrice())
                                .quantity(orderEntity.getQuantity())
                                .build();
    }

}