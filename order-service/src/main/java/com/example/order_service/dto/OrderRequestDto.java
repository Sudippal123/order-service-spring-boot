package com.example.order_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class OrderRequestDto {
    private long user_id;
    private List<OrderItemDto> items;
}
