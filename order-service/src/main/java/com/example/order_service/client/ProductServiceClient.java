package com.example.order_service.client;

import com.example.order_service.dto.ProductDto;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {
    private final Environment environment;
    private final RestTemplate restTemplate;

    public ProductServiceClient(Environment environment, RestTemplate restTemplate) {
        this.environment = environment;
        this.restTemplate = restTemplate;
    }

    public ProductDto getProductById(Long id){
        String url = environment.getProperty("PRODUCT_SERVICE_URL")+"/"+id;
        ResponseEntity<ProductDto> response = restTemplate.getForEntity("http://localhost:8081/api/products/"+id, ProductDto.class);
        return response.getBody();
    }
}
