package com.selahattinkabasakal.interprobe.homework1.products.converter;

import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductResponseDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;



import java.util.List;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductResponseDto convertToProductResponseDto(Products product);
    Products convertToProduct(ProductUpdateRequestDto productUpdateRequestDto);
    Products convertToProduct(ProductSaveRequestDto productSaveRequestDto);

    List<ProductResponseDto> convertToProductDtoList(List<Products> productsList);


}
