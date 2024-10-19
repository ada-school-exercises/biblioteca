package org.ada.biblioteca.service.book;

import org.ada.biblioteca.bo.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    List<Book> getBooks();
    Book findBookById(Long idBook);
    Book updateBook(Long idBook, Book book);
    void deleteBook(Long idBook);
}
