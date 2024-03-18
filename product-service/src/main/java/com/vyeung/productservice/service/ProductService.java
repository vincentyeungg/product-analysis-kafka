package com.vyeung.productservice.service;

import com.vyeung.productservice.dto.ProductDto;
import com.vyeung.productservice.event.ProductViewEvent;
import com.vyeung.productservice.repository.ProductRepository;
import com.vyeung.productservice.util.EntityDtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductViewEventProducer productViewEventProducer;

    public Mono<ProductDto> getProduct(int id) {
        return this.repository.findById(id)
                .doOnNext(e -> this.productViewEventProducer.emitEvent(new ProductViewEvent(e.getId())))
                .map(EntityDtoUtil::toDto);
    }
}
