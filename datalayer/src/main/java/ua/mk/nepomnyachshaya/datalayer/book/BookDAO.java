package ua.mk.nepomnyachshaya.datalayer.book;

import ua.mk.nepomnyachshaya.model.Book;

import java.util.List;

/**
 *
 */
public interface BookDAO {
     Book add (Book book);
     void delete(int Id);
     Book update(Book book);
     Book get(int Id);
     List<Book> getAll();
     List<Book> getBooksByName(String nameOfBook);
     List<Book> getBooksByAuthorSurname(String surnameOfAuthor);
     List<Book> getBooksByCategoryName(String nameOfCategory);
     Double getRating (Book book);
}
