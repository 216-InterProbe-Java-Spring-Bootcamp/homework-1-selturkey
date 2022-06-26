package com.selahattinkabasakal.interprobe.homework1.products.controller.rest;

import com.selahattinkabasakal.interprobe.homework1.generic.response.RestResponse;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductResponseDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductsRestController {

    private final ProductsService productsService;

    @GetMapping
    public ResponseEntity findAll(){
        List<ProductResponseDto> productResponseDtoList = productsService.findAll();
        return ResponseEntity.ok(RestResponse.of(productResponseDtoList));
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        ProductResponseDto productResponseDto = productsService.findById(id);
        return ResponseEntity.ok(RestResponse.of(productResponseDto));
    }
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody ProductSaveRequestDto productSaveRequestDto){
        ProductResponseDto productResponseDto = productsService.save(productSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(productResponseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productsService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        ProductResponseDto productResponseDto= productsService.update(productUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.of(productResponseDto));
    }
}
