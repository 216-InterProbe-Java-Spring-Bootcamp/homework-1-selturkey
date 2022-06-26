package com.selahattinkabasakal.interprobe.homework1.products.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Data
public class ProductSaveRequestDto {

    private String name;
    private BigDecimal price;
    private Date expirationDate;
}
