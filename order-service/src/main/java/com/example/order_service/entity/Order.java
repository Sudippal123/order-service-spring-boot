package com.example.order_service.entity;

import com.example.order_service.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "orders")
public class Order extends BaseEntity{

    private Long user_id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItems> items;
}
