package com.selahattinkabasakal.interprobe.homework1.users.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Data
public class UserUpdateRequestDto {

    private Long id;

    @NotEmpty
    @NotNull
    @Size(max=50)
    private String name;

    @NotEmpty
    @NotNull
    @Size(max=50)
    private String surname;

    @Email
    @Size(max=50)
    private String email;

    @NotEmpty
    @NotNull
    @Size(max=50)
    private String phone;
}
