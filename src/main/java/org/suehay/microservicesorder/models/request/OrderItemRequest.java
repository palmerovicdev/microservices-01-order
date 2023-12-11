package org.suehay.microservicesorder.models.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@JsonSerialize
public class OrderItemRequest implements java.io.Serializable{
    private String sku;
    private Double price;
    private Integer quantity;
}