package com.inditex.backendDevTest.products.application.service;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import com.inditex.backendDevTest.products.application.exceptions.ProductNotFoundException;
import com.inditex.backendDevTest.products.application.feign.ProductFeignClient;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductFeignClient productFeignClient;

    private final String SIMILAR_PRODUCTS_CIRCUIT_BRAKER = "similar-products-circuit-braker";

    @Override
    @CircuitBreaker(name = SIMILAR_PRODUCTS_CIRCUIT_BRAKER)
    public List<ProductDetailDTO> similarProducts(String idProduct) throws BadRequestException {

        if(!StringUtils.isNumeric(idProduct))throw new BadRequestException("Product Id must be numeric");
        try{
            return productFeignClient.getSimilarIds(idProduct)
                    .parallelStream()
                    .map(productFeignClient::getProductDetail)
                    .toList();

        } catch (FeignException.NotFound e) {
            throw new ProductNotFoundException();
        }catch (FeignException e) {
            log.error("Error calling Product API", e);
            throw new RuntimeException("External service error");
        }
    }
}
