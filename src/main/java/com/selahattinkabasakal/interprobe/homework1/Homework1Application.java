package com.selahattinkabasakal.interprobe.homework1;

import com.github.javafaker.Faker;
import com.selahattinkabasakal.interprobe.homework1.comments.dao.CommentsDao;
import com.selahattinkabasakal.interprobe.homework1.comments.entity.Comments;
import com.selahattinkabasakal.interprobe.homework1.products.dao.ProductsDao;
import com.selahattinkabasakal.interprobe.homework1.products.entity.Products;
import com.selahattinkabasakal.interprobe.homework1.users.dao.UsersDao;
import com.selahattinkabasakal.interprobe.homework1.users.dto.UserSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.users.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for(int i = 1; i<=50; i++){


            Users user = Users.builder()
                    .name(faker.name().firstName())
                    .surname(faker.name().lastName())
                    .email(faker.bothify("????##@gmail.com"))
                    .phone(faker.phoneNumber().cellPhone())
                    .build();
            usersDao.save(user);

            Users user2 = Users.builder()
                    .name(faker.name().firstName())
                    .surname(faker.name().lastName())
                    .email(faker.bothify("????##@gmail.com"))
                    .phone(faker.phoneNumber().cellPhone())
                    .build();
            usersDao.save(user2);

            Products product = Products.builder()
                    .name(faker.commerce().productName())
                    .price(BigDecimal.valueOf(faker.number().numberBetween(1500,125000)))
                    .expirationDate(faker.date().past(100, TimeUnit.DAYS ))
                    .build();
            productsDao.save(product);

            if (i % 5 == 0) {

                Products product2 = Products.builder()
                        .name(faker.commerce().productName())
                        .price(BigDecimal.valueOf(faker.number().numberBetween(15000,87500)))
                        .expirationDate(null)
                        .build();
                productsDao.save(product2);

                Comments comment = Comments.builder()
                        .comment(faker.lorem().characters(50,150))
                        .commentDate(faker.date().past(100, TimeUnit.DAYS ))
                        .user(user)
                        .product(product2)
                        .build();
                commentsDao.save(comment);

            }

            Comments comment2 = Comments.builder()
                    .comment(faker.lorem().characters(50,150))
                    .commentDate(faker.date().past(100, TimeUnit.DAYS ))
                    .user(user2)
                    .product(product)
                    .build();
            commentsDao.save(comment2);

            Comments comment3 = Comments.builder()
                    .comment(faker.lorem().characters(50,150))
                    .commentDate(faker.date().past(100, TimeUnit.DAYS ))
                    .user(user2)
                    .product(product)
                    .build();
            commentsDao.save(comment3);

            Comments comment4 = Comments.builder()
                    .comment(faker.lorem().characters(50,150))
                    .commentDate(faker.date().past(100, TimeUnit.DAYS ))
                    .user(user2)
                    .product(product)
                    .build();
            commentsDao.save(comment4);

            Comments comment5 = Comments.builder()
                    .comment(faker.lorem().characters(50,150))
                    .commentDate(faker.date().past(100, TimeUnit.DAYS ))
                    .user(user2)
                    .product(product)
                    .build();
            commentsDao.save(comment5);





        }

    }

}
