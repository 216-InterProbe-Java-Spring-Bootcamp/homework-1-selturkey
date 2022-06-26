package com.selahattinkabasakal.interprobe.homework1.products.service.entityservice;

import com.selahattinkabasakal.interprobe.homework1.generic.service.BaseEntityService;
import com.selahattinkabasakal.interprobe.homework1.products.dao.ProductsDao;
import com.selahattinkabasakal.interprobe.homework1.products.entity.Products;
import org.springframework.stereotype.Service;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Service
public class ProductEntityService extends BaseEntityService<Products, ProductsDao> {
    public ProductEntityService(ProductsDao dao) {
        super(dao);
    }

}
