package com.prasad.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prasad.library.Beans.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
