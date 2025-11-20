package com.inditex.backendDevTest.products.service;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import com.inditex.backendDevTest.products.application.feign.ProductFeignClient;
import com.inditex.backendDevTest.products.application.service.ProductServiceImpl;
import org.apache.coyote.BadRequestException;
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

    private ProductDetailDTO productDetailDTO1 = new ProductDetailDTO();
    private ProductDetailDTO productDetailDTO2 = new ProductDetailDTO();
    private ProductDetailDTO productDetailDTO3 = new ProductDetailDTO();


    @Before
    public void init(){

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
    void similarProducts_Ok() throws BadRequestException {

        when(productFeignClient.getSimilarIds("1")).thenReturn(List.of("2","3","4"));
        when(productFeignClient.getProductDetail("2")).thenReturn(productDetailDTO1);
        when(productFeignClient.getProductDetail("3")).thenReturn(productDetailDTO2);
        when(productFeignClient.getProductDetail("4")).thenReturn(productDetailDTO3);

        List<ProductDetailDTO> similarProductsResult = productService.similarProducts("1");

        assertEquals(similarProductsResult.get(0),productDetailDTO1);
        assertEquals(similarProductsResult.get(1),productDetailDTO2);
        assertEquals(similarProductsResult.get(2),productDetailDTO3);






    }

}
