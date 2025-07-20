package com.example.order_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductDto {

    private Long id ;
    private String title ;
    private String image ;
    private int price ;
    private String description ;
    private String brand ;
    private String model ;
    private String color ;
    private Long category_id ;
    private boolean popular ;
    private int discount ;

}
