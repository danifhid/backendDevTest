package com.inditex.backendDevTest.products.application.feign;

import com.inditex.backendDevTest.products.application.dto.ProductDetailFeignDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name= "API",url = "${spring.application.feign.uri}")
public interface ProductFeignClient {
    @GetMapping("/product/{idProduct}")
    ProductDetailFeignDTO getProductDetail(@PathVariable("idProduct") String productId);

    @GetMapping("/product/{idProduct}/similarids")
    List<String> getSimilarIds(@PathVariable("idProduct") String productId);
}
