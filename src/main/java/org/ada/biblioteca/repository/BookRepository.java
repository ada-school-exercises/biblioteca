package org.ada.biblioteca.repository;

import org.ada.biblioteca.bo.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book createBook(Book book);
    List<Book> getBooks();
    Optional<Book> findBookById(Long idBook);
    Book updateBook(Book book);
    void deleteBook(Long idBook);
}
