package com.example.order_service.controller;

import com.example.order_service.dto.CreateOrderResponseDto;
import com.example.order_service.dto.OrderRequestDto;
import com.example.order_service.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public ResponseEntity<CreateOrderResponseDto> createOrder(@RequestBody OrderRequestDto order){
        CreateOrderResponseDto responseDto = orderService.createOrder(order);
        return ResponseEntity.ok(responseDto);
    }
}
