package com.selahattinkabasakal.interprobe.homework1.comments.entity;

import com.selahattinkabasakal.interprobe.homework1.generic.entity.BaseEntity;
import com.selahattinkabasakal.interprobe.homework1.products.entity.Products;
import com.selahattinkabasakal.interprobe.homework1.users.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Entity
@Table(name = "COMMENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comments extends BaseEntity {

    @Column(name = "COMMENT", length = 500)
    private String comment;

    @Column(name = "COMMENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date commentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", foreignKey = @ForeignKey(name = "FK_PRODUCTS_ID"))
    private Products product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERS_ID",  foreignKey = @ForeignKey(name = "FK_USERS_ID"))
    private Users user;

}