package com.inditex.backendDevTest.products.application.controller;

import com.inditex.backendDevTest.products.application.dto.ProductDetailOutputDTO;
import com.inditex.backendDevTest.products.application.exceptions.BadRequestException;
import com.inditex.backendDevTest.products.application.mapper.ProductMapper;
import com.inditex.backendDevTest.products.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;
    private final ProductMapper mapper;
    public ResponseEntity<List<ProductDetailOutputDTO>> getSimilarProducts(String idProduct) {

        final List<ProductDetailOutputDTO> products = productService.similarProducts(idProduct)
                .stream()
                .map(mapper::productDetailDtoToproductDetailOutputDto)
                .toList();

        return ResponseEntity.ok(products);
    }
}