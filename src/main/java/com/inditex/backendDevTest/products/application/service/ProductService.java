package com.inditex.backendDevTest.products.application.service;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ProductService {
    List<ProductDetailDTO> similarProducts (String idProduct) throws BadRequestException;

}
