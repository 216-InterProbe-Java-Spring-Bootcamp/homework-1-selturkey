package com.selahattinkabasakal.interprobe.homework1.generic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException implements Serializable {

    private static final Long serialVersionUID = 1L;

    public RecordNotFoundException(String message){

        super(message);

    }
}