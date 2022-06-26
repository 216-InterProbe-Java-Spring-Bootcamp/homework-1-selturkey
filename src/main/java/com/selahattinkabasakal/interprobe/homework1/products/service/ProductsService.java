package com.selahattinkabasakal.interprobe.homework1.products.service;


import com.fasterxml.jackson.databind.DatabindException;
import com.selahattinkabasakal.interprobe.homework1.generic.exceptions.RecordNotFoundException;
import com.selahattinkabasakal.interprobe.homework1.products.converter.ProductMapper;
import com.selahattinkabasakal.interprobe.homework1.products.dao.ProductsDao;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductResponseDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.entity.Products;
import com.selahattinkabasakal.interprobe.homework1.products.service.entityservice.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductEntityService productEntityService;
    private final ProductsDao productsDao;


    public List<ProductResponseDto> findAll(){

        List<Products> productsList = productEntityService.findAll();

        return ProductMapper.INSTANCE.convertToProductDtoList(productsList);
    }

    public ProductResponseDto findById(Long id){

        Products product = productEntityService.findById(id).orElseThrow(()-> new RecordNotFoundException("Product Not find Id: "+ id));

        return ProductMapper.INSTANCE.convertToProductResponseDto(product);
    }

    public ProductResponseDto save(ProductSaveRequestDto productSaveRequestDto){


        Products product = ProductMapper.INSTANCE.convertToProduct(productSaveRequestDto);
        product = productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductResponseDto(product);
    }

    public void delete(Long id){
        productEntityService.delete(id);
    }

    public void delete(Products product){
        productEntityService.delete(product);
    }

    public boolean isExist(Long id){
        return productEntityService.isExist(id);
    }



    public ProductResponseDto update(ProductUpdateRequestDto productUpdateRequestDto) {

        boolean isExist = productEntityService.isExist(productUpdateRequestDto.getId());

        if (!isExist){ throw new RecordNotFoundException("No Record Find to Update Id: "+ productUpdateRequestDto.getId());}

        Products product = ProductMapper.INSTANCE.convertToProduct(productUpdateRequestDto);

        product = productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductResponseDto(product);
    }


    public List<ProductResponseDto> findExpired(Date expirationDate) {
        List<Products> productsList = productsDao.findProductsByExpirationDateBefore(expirationDate);

        return ProductMapper.INSTANCE.convertToProductDtoList(productsList);
    }

    public List<ProductResponseDto> findNotExpired(Date expirationDate) {

        List<Products> productsList = productsDao.findProductsByExpirationDateAfterOrExpirationDateNull(expirationDate);

        return ProductMapper.INSTANCE.convertToProductDtoList(productsList);
    }
}
