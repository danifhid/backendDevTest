package com.inditex.backendDevTest.products.application.controller;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import com.inditex.backendDevTest.products.application.service.ProductService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    public ResponseEntity<List<ProductDetailDTO>> getSimilarProducts(@PathVariable String idProduct) throws BadRequestException {

        if (StringUtils.isBlank(idProduct) ) {
            throw new BadRequestException("Product id must not be empty");
        }
        final List<ProductDetailDTO> products = productService.similarProducts(idProduct)
                .stream()
                .toList();

        return ResponseEntity.ok(products);
    }
}