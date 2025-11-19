package com.inditex.backendDevTest.products.service;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import com.inditex.backendDevTest.products.application.dto.ProductDetailFeignDTO;
import com.inditex.backendDevTest.products.application.dto.ProductDetailOutputDTO;
import com.inditex.backendDevTest.products.application.feign.ProductFeignClient;
import com.inditex.backendDevTest.products.application.mapper.ProductMapper;
import com.inditex.backendDevTest.products.application.service.ProductServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductFeignClient productFeignClient;

    @Mock
    private ProductMapper productMapper;

    private ProductDetailFeignDTO productDetailFeignDTO1 = new ProductDetailFeignDTO();
    private ProductDetailFeignDTO productDetailFeignDTO2 = new ProductDetailFeignDTO();
    private ProductDetailFeignDTO productDetailFeignDTO3 = new ProductDetailFeignDTO();


    private ProductDetailDTO productDetailDTO1 = new ProductDetailDTO();
    private ProductDetailDTO productDetailDTO2 = new ProductDetailDTO();
    private ProductDetailDTO productDetailDTO3 = new ProductDetailDTO();


    @Before
    public void init(){


        productDetailFeignDTO1.setId("2");
        productDetailFeignDTO1.setName("bag");
        productDetailFeignDTO1.setPrice(12.00);
        productDetailFeignDTO1.setAvailability(true);

        productDetailFeignDTO2.setId("3");
        productDetailFeignDTO2.setName("shirt");
        productDetailFeignDTO2.setPrice(25.01);
        productDetailFeignDTO2.setAvailability(false);

        productDetailFeignDTO3.setId("4");
        productDetailFeignDTO3.setName("skirt");
        productDetailFeignDTO3.setPrice(30.00);
        productDetailFeignDTO3.setAvailability(true);

        productDetailDTO1.setId("2");
        productDetailDTO1.setName("bag");
        productDetailDTO1.setPrice(12.00);
        productDetailDTO1.setAvailability(true);


        productDetailDTO2.setId("3");
        productDetailDTO2.setName("shirt");
        productDetailDTO2.setPrice(25.01);
        productDetailDTO2.setAvailability(false);

        productDetailDTO3.setId("4");
        productDetailDTO3.setName("skirt");
        productDetailDTO3.setPrice(30.00);
        productDetailDTO3.setAvailability(true);
    }
    @Test
    void similarProducts_Ok(){

        when(productFeignClient.getSimilarIds("1")).thenReturn(List.of("2","3","4"));
        when(productFeignClient.getProductDetail("2")).thenReturn(productDetailFeignDTO1);
        when(productFeignClient.getProductDetail("3")).thenReturn(productDetailFeignDTO2);
        when(productFeignClient.getProductDetail("4")).thenReturn(productDetailFeignDTO3);
        when(productMapper.productDetailFeignDTOtoProductDetailDTO(productDetailFeignDTO1)).thenReturn(productDetailDTO1);
        when(productMapper.productDetailFeignDTOtoProductDetailDTO(productDetailFeignDTO2)).thenReturn(productDetailDTO2);
        when(productMapper.productDetailFeignDTOtoProductDetailDTO(productDetailFeignDTO3)).thenReturn(productDetailDTO3);

        List<ProductDetailDTO> similarProductsResult = productService.similarProducts("1");

        assertEquals(similarProductsResult.get(0),productDetailDTO1);
        assertEquals(similarProductsResult.get(1),productDetailDTO2);
        assertEquals(similarProductsResult.get(2),productDetailDTO3);






    }

}
