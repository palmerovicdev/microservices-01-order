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
public class OrderResponse implements java.io.Serializable {
    private Long id;
    private String orderNumber;
    private String sku;
    private Double price;
    private Integer quantity;
}