package com.selahattinkabasakal.interprobe.homework1.products.entity;

import com.selahattinkabasakal.interprobe.homework1.comments.entity.Comments;
import com.selahattinkabasakal.interprobe.homework1.generic.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
public class Products extends BaseEntity {

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "EXPIRATION_DATE", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Comments> comments;

}