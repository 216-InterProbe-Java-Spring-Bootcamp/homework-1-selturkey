package com.selahattinkabasakal.interprobe.homework1.comments.dto;


import com.selahattinkabasakal.interprobe.homework1.users.entity.Users;
import lombok.Data;


import java.util.Date;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Data
public class CommentResponseDto  {



    private String comment;
    private Date commentDate;



}
