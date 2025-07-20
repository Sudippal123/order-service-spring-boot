package com.example.order_service.service;

import com.example.order_service.client.ProductServiceClient;
import com.example.order_service.dto.CreateOrderResponseDto;
import com.example.order_service.dto.OrderItemDto;
import com.example.order_service.dto.OrderRequestDto;
import com.example.order_service.dto.ProductDto;
import com.example.order_service.entity.Order;
import com.example.order_service.entity.OrderItems;
import com.example.order_service.enums.OrderStatus;
import com.example.order_service.mapper.OrderMapper;
import com.example.order_service.repository.OrderItemRepository;
import com.example.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService{
    private final OrderRepository repository;
    private final OrderItemRepository orderItemRepository;
    private final ProductServiceClient productServiceClient;
    public OrderService(OrderRepository repository, OrderItemRepository orderItemRepository, ProductServiceClient productServiceClient) {
        this.repository = repository;
        this.orderItemRepository = orderItemRepository;
        this.productServiceClient = productServiceClient;
    }

    @Override
    public CreateOrderResponseDto createOrder(OrderRequestDto orderDto) {
        Order order = OrderMapper.toOrder(orderDto, OrderStatus.PENDING);

        List<OrderItems> items = orderDto.getItems().stream().map(item -> {
            ProductDto product = productServiceClient.getProductById(item.getProduct_id());
            double pricePerUnit = product.getPrice();
            double totalPrice = item.getQuantity() * pricePerUnit;

            return OrderItems.builder()
                    .productId(product.getId())
                    .quantity(item.getQuantity())
                    .pricePerUnit(pricePerUnit)
                    .totalPrice(totalPrice)
                    .order(order)
                    .build();
        }).toList();

        order.setItems(items);
        repository.save(order);

        return CreateOrderResponseDto.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .build();
    }
}
