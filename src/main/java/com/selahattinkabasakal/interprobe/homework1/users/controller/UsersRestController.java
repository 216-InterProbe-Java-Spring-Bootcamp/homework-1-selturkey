package com.selahattinkabasakal.interprobe.homework1.users.controller;

import com.selahattinkabasakal.interprobe.homework1.generic.response.RestResponse;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductResponseDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.dto.ProductUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.products.service.ProductsService;
import com.selahattinkabasakal.interprobe.homework1.users.dto.UserResponseDto;
import com.selahattinkabasakal.interprobe.homework1.users.dto.UserSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.users.dto.UserUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.users.service.UsersService;
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
@RequestMapping("/api/v1/users")
public class UsersRestController {

    private final UsersService usersService;

    @GetMapping
    public ResponseEntity findAll(){
        List<UserResponseDto> userResponseDtoList = usersService.findAll();
        return ResponseEntity.ok(RestResponse.of(userResponseDtoList));
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        UserResponseDto userResponseDto = usersService.findById(id);
        return ResponseEntity.ok(RestResponse.of(userResponseDto));
    }
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody UserSaveRequestDto userSaveRequestDto){
        UserResponseDto userResponseDto = usersService.save(userSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(userResponseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        usersService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody UserUpdateRequestDto userUpdateRequestDto){
        UserResponseDto userResponseDto = usersService.update(userUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.of(userResponseDto));
    }
}