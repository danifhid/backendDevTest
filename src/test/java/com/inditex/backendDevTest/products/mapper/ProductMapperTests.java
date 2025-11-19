package com.inditex.backendDevTest.products.mapper;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import com.inditex.backendDevTest.products.application.dto.ProductDetailOutputDTO;
import com.inditex.backendDevTest.products.application.dto.ProductDetailFeignDTO;
import com.inditex.backendDevTest.products.application.mapper.ProductMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProductMapperTests {

    @InjectMocks
    private ProductMapperImpl productMapper;


    @Test
    void productDetailFeignDTOtoProductDetailDTO_OK(){
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        ProductDetailFeignDTO productDetailFeignDTO = new ProductDetailFeignDTO();

        productDetailDTO.setId("1");
        productDetailDTO.setName("bag");
        productDetailDTO.setPrice(12.00);
        productDetailDTO.setAvailability(true);

        productDetailFeignDTO.setId("1");
        productDetailFeignDTO.setName("bag");
        productDetailFeignDTO.setPrice(12.00);
        productDetailFeignDTO.setAvailability(true);

        ProductDetailDTO productDetailDTOMapped = productMapper.productDetailFeignDTOtoProductDetailDTO(productDetailFeignDTO);

        assertEquals(productDetailDTO,productDetailDTOMapped);

    }


    @Test
    void productDetailDtoToproductDetailOutputDto_OK(){
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        ProductDetailOutputDTO productDetailOutputDTO = new ProductDetailOutputDTO();

        productDetailDTO.setId("2");
        productDetailDTO.setName("shirt");
        productDetailDTO.setPrice(24.00);
        productDetailDTO.setAvailability(false);

        productDetailOutputDTO.setId("2");
        productDetailOutputDTO.setName("shirt");
        productDetailOutputDTO.setPrice(24.00);
        productDetailOutputDTO.setAvailability(false);

        ProductDetailOutputDTO ToproductDetailOutputDtoMapped  = productMapper.productDetailDtoToproductDetailOutputDto(productDetailDTO);

        assertEquals(productDetailOutputDTO,ToproductDetailOutputDtoMapped);

    }
}
