package com.inditex.backendDevTest.products.controller;

import com.inditex.backendDevTest.products.application.controller.ProductControllerImpl;
import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import com.inditex.backendDevTest.products.application.service.ProductService;
import org.apache.coyote.BadRequestException;
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
    ProductService productService;

    @Test
    void getSimilarProducts_OK() throws BadRequestException {
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();

        productDetailDTO.setId("2");
        productDetailDTO.setName("bag");
        productDetailDTO.setPrice(12.00);
        productDetailDTO.setAvailability(true);

        when(productService.similarProducts("2")).thenReturn(List.of(productDetailDTO));

        ResponseEntity<List<ProductDetailDTO>> result = productController.getSimilarProducts("2");

        assertEquals(productDetailDTO.getId(),result.getBody().get(0).getId());
        assertEquals(productDetailDTO.getPrice(),result.getBody().get(0).getPrice());
        assertEquals(productDetailDTO.getName(),result.getBody().get(0).getName());
        assertEquals(productDetailDTO.getAvailability(),result.getBody().get(0).getAvailability());

    }

}
