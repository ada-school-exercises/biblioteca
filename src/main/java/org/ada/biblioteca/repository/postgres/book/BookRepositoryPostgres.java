package org.ada.biblioteca.repository.postgres.book;

import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.Book;
import org.ada.biblioteca.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BookRepositoryPostgres implements BookRepository {

    private final BookRepositoryJpa bookRepositoryJpa;

    @Override
    public Book createBook(Book book) {
        return bookRepositoryJpa.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepositoryJpa.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long idBook) {
        return bookRepositoryJpa.findById(idBook);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepositoryJpa.save(book);
    }

    @Override
    public void deleteBook(Long idBook) {
        bookRepositoryJpa.deleteById(idBook);
    }
}
