package com.inditex.backendDevTest.products.application.dto;

import lombok.Data;

@Data
public class ProductDetailDTO {

    String id;

    String name;

    Double price;

    Boolean availability;

}
