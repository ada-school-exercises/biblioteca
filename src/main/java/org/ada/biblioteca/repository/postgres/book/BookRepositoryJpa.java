package org.ada.biblioteca.repository.postgres.book;

import org.ada.biblioteca.bo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositoryJpa extends JpaRepository<Book, Long> {
}
