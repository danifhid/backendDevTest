package com.inditex.backendDevTest.products.controller;

import com.inditex.backendDevTest.products.application.controller.ProductControllerImpl;
import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import com.inditex.backendDevTest.products.application.dto.ProductDetailOutputDTO;
import com.inditex.backendDevTest.products.application.dto.ProductDetailFeignDTO;
import com.inditex.backendDevTest.products.application.mapper.ProductMapper;
import com.inditex.backendDevTest.products.application.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTests {

    @InjectMocks
    private ProductControllerImpl productController;

    @Mock
    ProductMapper productMapper;

    @Mock
    ProductService productService;

    @Test
    void getSimilarProducts_OK(){
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        ProductDetailFeignDTO productDetailFeignDTO = new ProductDetailFeignDTO();
        ProductDetailOutputDTO productDetailOutputDTO = new ProductDetailOutputDTO();

        productDetailDTO.setId("2");
        productDetailDTO.setName("bag");
        productDetailDTO.setPrice(12.00);
        productDetailDTO.setAvailability(true);

        productDetailFeignDTO.setId("2");
        productDetailFeignDTO.setName("bag");
        productDetailFeignDTO.setPrice(12.00);
        productDetailFeignDTO.setAvailability(true);

        productDetailOutputDTO.setId("2");
        productDetailOutputDTO.setName("bag");
        productDetailOutputDTO.setPrice(12.00);
        productDetailOutputDTO.setAvailability(true);

        when(productService.similarProducts("2")).thenReturn(List.of(productDetailDTO));
        when(productMapper.productDetailDtoToproductDetailOutputDto(productDetailDTO)).thenReturn(productDetailOutputDTO);

        ResponseEntity<List<ProductDetailOutputDTO>> result = productController.getSimilarProducts("2");

        assertEquals(productDetailOutputDTO.getId(),result.getBody().get(0).getId());
        assertEquals(productDetailOutputDTO.getPrice(),result.getBody().get(0).getPrice());
        assertEquals(productDetailOutputDTO.getName(),result.getBody().get(0).getName());
        assertEquals(productDetailOutputDTO.getAvailability(),result.getBody().get(0).getAvailability());

    }
}
