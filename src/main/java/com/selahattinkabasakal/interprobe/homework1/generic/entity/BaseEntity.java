package com.selahattinkabasakal.interprobe.homework1.generic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@MappedSuperclass
@Getter
@Setter
public abstract  class BaseEntity implements BaseModel, Serializable, Cloneable  {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private BaseAdditionalFields additionalFields;


}
