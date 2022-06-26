package com.selahattinkabasakal.interprobe.homework1.products.dao;

import com.selahattinkabasakal.interprobe.homework1.products.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
public interface ProductsDao extends JpaRepository<Products, Long> {
}
