package org.suehay.microservicesorder.models.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@JsonSerialize
public class OrderRequest implements java.io.Serializable{
    private String orderNumber;
    private List<OrderItemRequest> items;
}