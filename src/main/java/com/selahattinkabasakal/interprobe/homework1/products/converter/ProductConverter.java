package com.selahattinkabasakal.interprobe.homework1.products.converter;

import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductResponseDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.entity.Products;
import org.springframework.stereotype.Component;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Component
public class ProductConverter {

    public ProductResponseDto convertToProductResponseDto(Products products){

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(products.getId());
        productResponseDto.setName(products.getName());
        productResponseDto.setPrice(products.getPrice());
        productResponseDto.setExpirationDate(products.getExpirationDate());

        return productResponseDto;
    }

    public Products convertToProduct(ProductUpdateRequestDto productUpdateRequestDto){

        Products product = new Products();
        product.setId(productUpdateRequestDto.getId());
        product.setName(productUpdateRequestDto.getName());
        product.setPrice(productUpdateRequestDto.getPrice());
        product.setExpirationDate(productUpdateRequestDto.getExpirationDate());

        return product;


    }

}
