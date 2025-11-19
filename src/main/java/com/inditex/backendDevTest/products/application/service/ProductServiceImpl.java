package com.inditex.backendDevTest.products.application.service;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import com.inditex.backendDevTest.products.application.exceptions.BadRequestException;
import com.inditex.backendDevTest.products.application.exceptions.ProductNotFoundException;
import com.inditex.backendDevTest.products.application.feign.ProductFeignClient;
import com.inditex.backendDevTest.products.application.mapper.ProductMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductFeignClient productFeignClient;

    private final ProductMapper productMapper;

    @Override
    public List<ProductDetailDTO> similarProducts(String idProduct) {

        if(!StringUtils.isNumeric(idProduct))throw new BadRequestException();
        try{
            return productFeignClient.getSimilarIds(idProduct)
                    .stream()
                    .map(productFeignClient::getProductDetail)
                    .map(productMapper::productDetailFeignDTOtoProductDetailDTO)
                    .toList();

        } catch (FeignException.NotFound e) {
            throw new ProductNotFoundException();
        }
    }
}
