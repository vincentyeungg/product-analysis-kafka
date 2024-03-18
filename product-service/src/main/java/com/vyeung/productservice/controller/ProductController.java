package com.vyeung.productservice.controller;

import com.vyeung.productservice.dto.ProductDto;
import com.vyeung.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("{productId}")
    public Mono<ProductDto> view(@PathVariable Integer productId) {
        return this.productService.getProduct(productId);
    }
}
