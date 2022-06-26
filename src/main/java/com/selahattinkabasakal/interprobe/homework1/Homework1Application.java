package com.selahattinkabasakal.interprobe.homework1;

import com.github.javafaker.Faker;
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
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Homework1Application implements CommandLineRunner {
    @Autowired
    UsersDao usersDao;

    @Autowired
    ProductsDao productsDao;

    @Autowired
    CommentsDao commentsDao;


    Faker faker = new Faker();


    public static void main(String[] args) {
        SpringApplication.run(Homework1Application.class, args);
    }

    public void run(String... strings) throws Exception {
        DateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

        for(int i = 1; i<=50; i++){


            Users user = new Users(faker.name().firstName(),faker.name().lastName(),faker.bothify("????##@gmail.com"),faker.phoneNumber().cellPhone());
            usersDao.save(user);

            Products product =
                    new Products(faker.commerce().productName(), BigDecimal.valueOf(faker.number().numberBetween(1500,125000)),
                            faker.date().past(100, TimeUnit.DAYS ));
            productsDao.save(product);
            Products product2 =
                    new Products(faker.commerce().productName(), BigDecimal.valueOf(faker.number().numberBetween(1500,125000)),
                           null);
            productsDao.save(product2);

            Comments comment = new Comments(faker.lorem().characters(50,150),
                    faker.date().past(100, TimeUnit.DAYS ),product,user);
            commentsDao.save(comment);
            Comments comment2 = new Comments(faker.lorem().characters(50,150),
                    faker.date().past(100, TimeUnit.DAYS ),product2,user);
            commentsDao.save(comment2);
            Comments comment3 = new Comments(faker.lorem().characters(50,150),
                    faker.date().past(100, TimeUnit.DAYS ),product2,user);
            commentsDao.save(comment3);
            Comments comment4 = new Comments(faker.lorem().characters(50,150),
                    faker.date().past(100, TimeUnit.DAYS ),product2,user);
            commentsDao.save(comment4);

            Comments comment5 = new Comments(faker.lorem().characters(50,150),
                    faker.date().past(100, TimeUnit.DAYS ),product,user);
            commentsDao.save(comment5);

            Comments comment6 = new Comments(faker.lorem().characters(50,150),
                    faker.date().past(100, TimeUnit.DAYS ),product,user);
            commentsDao.save(comment6);


        }

    }

}
