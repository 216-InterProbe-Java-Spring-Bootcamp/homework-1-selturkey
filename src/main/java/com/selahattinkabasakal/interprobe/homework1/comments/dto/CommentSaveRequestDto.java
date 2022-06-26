package com.selahattinkabasakal.interprobe.homework1.comments.dto;


import com.selahattinkabasakal.interprobe.homework1.products.entity.Products;
import com.selahattinkabasakal.interprobe.homework1.users.entity.Users;
import lombok.Data;


import java.util.Date;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Data
public class CommentSaveRequestDto {


    private String comment;
    private Date commentDate;
    private Users user;
    private Products product;

}
