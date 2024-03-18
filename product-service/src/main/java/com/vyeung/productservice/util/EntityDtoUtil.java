package com.vyeung.productservice.util;

import com.vyeung.productservice.dto.ProductDto;
import com.vyeung.productservice.entity.Product;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {
    public static ProductDto toDto(Product product) {
        var dto = new ProductDto();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }
}
