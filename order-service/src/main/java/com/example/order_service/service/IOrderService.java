package com.example.order_service.service;

import com.example.order_service.dto.CreateOrderResponseDto;
import com.example.order_service.dto.OrderRequestDto;

public interface IOrderService {
    public CreateOrderResponseDto createOrder(OrderRequestDto order);
}
