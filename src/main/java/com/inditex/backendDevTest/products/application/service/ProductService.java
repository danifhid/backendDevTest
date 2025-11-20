package com.inditex.backendDevTest.products.application.service;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductService {
    List<ProductDetailDTO> similarProducts (String idProduct) throws BadRequestException;

}
