package com.inditex.backendDevTest.products.application.controller;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/product")
public interface ProductController {
    @GetMapping("/{idProduct}/similarids")
    ResponseEntity<List<ProductDetailDTO>> getSimilarProducts(@PathVariable("idProduct") String productId) ;
}