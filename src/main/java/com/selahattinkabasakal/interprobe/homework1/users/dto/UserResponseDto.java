package com.selahattinkabasakal.interprobe.homework1.users.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Data
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private String phone;


}
