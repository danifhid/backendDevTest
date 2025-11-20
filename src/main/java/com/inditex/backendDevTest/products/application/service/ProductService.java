package com.inditex.backendDevTest.products.application.service;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;

import java.util.List;

public interface ProductService {
    List<ProductDetailDTO> similarProducts (String idProduct);

}
