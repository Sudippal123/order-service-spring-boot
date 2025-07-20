package com.example.order_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OrderItemDto {
    private long product_id;
    private int quantity;
}
