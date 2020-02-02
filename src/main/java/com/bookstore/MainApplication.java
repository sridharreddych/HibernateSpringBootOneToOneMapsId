package com.bookstore;

import com.bookstore.entity.Book;
import com.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private BookstoreService bookstoreService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.newBookOfAuthor();

            Book book = bookstoreService.fetchBookByAuthorId();
            System.out.println(book);
        };
    }
}

/*
 * How To Use @MapsId For Sharing Identifier In @OneToOne Relationships

Description: Instead of regular unidirectional/bidirectional @OneToOne better rely on an unidirectional @OneToOne and @MapsId. This application is a proof of concept.

Key points:

use @MapsId on child side
use @JoinColumn to customize the name of the primary key column
mainly, for @OneToOne associations, @MapsId will share the primary key with the parent table (id property acts as both primary key and foreign key)
Note:

@MapsId can be used for @ManyToOne as well
 * 
 * 
 */
