package com.java.project.Book.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.project.Book.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);
   // List<Book> findByActiveTruBooks();
    List<Book> findByActiveIsTrue();
    Page<Book> findAll(Pageable pageable);


}
