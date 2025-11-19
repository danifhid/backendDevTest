package com.inditex.backendDevTest.products.application.mapper;

import com.inditex.backendDevTest.products.application.dto.ProductDetailDTO;
import com.inditex.backendDevTest.products.application.dto.ProductDetailOutputDTO;
import com.inditex.backendDevTest.products.application.dto.ProductDetailFeignDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDetailDTO productDetailFeignDTOtoProductDetailDTO(ProductDetailFeignDTO productDetail);

    ProductDetailOutputDTO productDetailDtoToproductDetailOutputDto (ProductDetailDTO productDetailDTO);



}
