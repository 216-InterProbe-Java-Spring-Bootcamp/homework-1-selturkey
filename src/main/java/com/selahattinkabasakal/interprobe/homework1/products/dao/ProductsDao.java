package com.selahattinkabasakal.interprobe.homework1.products.dao;

import com.selahattinkabasakal.interprobe.homework1.comments.entity.Comments;
import com.selahattinkabasakal.interprobe.homework1.products.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
public interface ProductsDao extends JpaRepository<Products, Long> {
    List<Products> findProductsByExpirationDateBefore(Date date);


    List<Products> findProductsByExpirationDateAfterOrExpirationDateNull(Date expirationDate);
}
