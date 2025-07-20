package com.example.order_service.dto;

import com.example.order_service.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateOrderResponseDto {
    private long orderId;
    private OrderStatus status;
}
