package com.example.order_service.client;

import com.example.order_service.dto.ProductDto;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {
    private final RestTemplate restTemplate;

    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductDto getProductById(Long productId){
        String url = "http://ECOMMERCE/api/products/" + productId;
        ResponseEntity<ProductDto> response = restTemplate.getForEntity(url, ProductDto.class);
        return response.getBody();
    }
}
