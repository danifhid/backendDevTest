package com.inditex.backendDevTest.products.application.dto;

import lombok.Data;

@Data
public class ProductDetailFeignDTO {


        String id;

        String name;

        Double price;

        Boolean availability;
}