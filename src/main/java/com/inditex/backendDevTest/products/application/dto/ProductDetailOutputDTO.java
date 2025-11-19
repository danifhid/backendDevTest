package com.inditex.backendDevTest.products.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ProductDetailOutputDTO {

    String id;

    String name;

    Double price;

    Boolean availability;

}
