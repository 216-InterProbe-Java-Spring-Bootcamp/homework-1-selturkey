package com.selahattinkabasakal.interprobe.homework1.users.entity;

import com.selahattinkabasakal.interprobe.homework1.comments.entity.Comments;
import com.selahattinkabasakal.interprobe.homework1.generic.entity.BaseEntity;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Email;

import java.util.List;
import java.util.Set;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users extends BaseEntity {

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "SURNAME", nullable = false, length = 50)
    private String surname;

    @Email
    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;


    @Column(name = "PHONE", nullable = false, length = 15)
    private String phone;



}
