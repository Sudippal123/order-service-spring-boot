package com.example.order_service.mapper;

import com.example.order_service.dto.CreateOrderResponseDto;
import com.example.order_service.dto.OrderItemDto;
import com.example.order_service.dto.OrderRequestDto;
import com.example.order_service.entity.Order;
import com.example.order_service.entity.OrderItems;
import com.example.order_service.enums.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public static Order toOrder(OrderRequestDto requestDto, OrderStatus status){
        return Order.builder()
                .user_id(requestDto.getUser_id())
                .status(status)
                .build();
    }
}
