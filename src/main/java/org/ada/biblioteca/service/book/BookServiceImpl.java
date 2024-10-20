package org.ada.biblioteca.service.book;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.Book;
import org.ada.biblioteca.repository.BookRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private static final String BOOK_NOT_FOUND = "Book not found with ID: ";

    @Override
    public Book createBook(Book book) {
        return bookRepository.createBook(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public Book findBookById(String idBook) {
        return bookRepository.findBookById(idBook)
                .orElseThrow(() -> new EntityNotFoundException(BOOK_NOT_FOUND + idBook));
    }

    @Override
    public Book updateBook(String idBook, Book book) {
        Book bookFound = bookRepository.findBookById(idBook)
                .orElseThrow(() -> new EntityNotFoundException(BOOK_NOT_FOUND + idBook));
        bookFound.setTitle(book.getTitle());
        bookFound.setAuthor(book.getAuthor());
        bookFound.setIsbn(book.getIsbn());
        return bookRepository.updateBook(bookFound);
    }

    @Override
    public void deleteBook(String idBook) {
        if(bookRepository.findBookById(idBook).isEmpty()) {
            throw new EntityNotFoundException(BOOK_NOT_FOUND + idBook);
        }
        bookRepository.deleteBook(idBook);
    }
}
