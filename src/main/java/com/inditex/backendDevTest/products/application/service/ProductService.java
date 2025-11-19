package com.inditex.backendDevTest.products.application.service;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductService {
    List<ProductDetailDTO> similarProducts (String idProduct);

}
