package org.suehay.microservicesorder.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.suehay.microservicesorder.models.request.OrderRequest;
import org.suehay.microservicesorder.models.response.OrderResponse;
import org.suehay.microservicesorder.services.OrderServiceImpl;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceImpl orderService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new order", description = "Create a new order", tags = {"orders"}, operationId = "create", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Order created"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Order already exists")}
    )
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.orderService.create(order));
    }

}