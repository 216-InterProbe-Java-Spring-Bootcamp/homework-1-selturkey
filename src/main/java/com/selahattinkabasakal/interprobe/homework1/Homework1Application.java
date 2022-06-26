package com.selahattinkabasakal.interprobe.homework1;

import com.selahattinkabasakal.interprobe.homework1.comments.dao.CommentsDao;
import com.selahattinkabasakal.interprobe.homework1.comments.entity.Comments;
import com.selahattinkabasakal.interprobe.homework1.products.dao.ProductsDao;
import com.selahattinkabasakal.interprobe.homework1.products.entity.Products;
import com.selahattinkabasakal.interprobe.homework1.users.dao.UsersDao;
import com.selahattinkabasakal.interprobe.homework1.users.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Homework1Application implements CommandLineRunner {
    @Autowired
    UsersDao usersDao;

    @Autowired
    ProductsDao productsDao;

    @Autowired
    CommentsDao commentsDao;


    public static void main(String[] args) {
        SpringApplication.run(Homework1Application.class, args);
    }

    public void run(String... strings) throws Exception {
        DateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

        Users user1 = new Users("Sel","Turkey","selturkey@gmail.com","5415910504");
        usersDao.save(user1);

        Users user2 = new Users("Sel2","Turkey2","selturkey2@gmail.com","54159105042");
        usersDao.save(user2);
        Users user3 = new Users("Sel3","Turkey3","selturkey3@gmail.com","541591050423");
        usersDao.save(user3);

        Products product1 = new Products("Milk", BigDecimal.valueOf(300),simpleDateFormat.parse("2022-06-26"));
        productsDao.save(product1);
        Products product2 = new Products("Bread",BigDecimal.valueOf(300),simpleDateFormat.parse("2022-06-22"));
        productsDao.save(product2);
        Products product3 = new Products("water",BigDecimal.valueOf(303),simpleDateFormat.parse("2022-06-29"));
        productsDao.save(product3);
        Products product4 = new Products("water nulldate",BigDecimal.valueOf(33),null);
        productsDao.save(product4);




        Comments comment1 = new Comments("Yorum 1",simpleDateFormat.parse("2022-06-26"),product1,user1);
        commentsDao.save(comment1);

        Comments comment2 = new Comments("Yorum 2 ",simpleDateFormat.parse("2022-06-20"),product2,user2);
        commentsDao.save(comment2);

        Comments comment3 = new Comments("Yorum 3 ",simpleDateFormat.parse("2022-06-21"),product2,user3);
        commentsDao.save(comment3);
        Comments comment4 = new Comments("Yorum 4 ",simpleDateFormat.parse("2022-06-18"),product1,user3);
        commentsDao.save(comment4);

        Comments comment5 = new Comments("Yorum 5 ",simpleDateFormat.parse("2022-05-01"),product1,user3);
        commentsDao.save(comment5);


    }

}
