package ua.mk.nepomnyachshaya.datalayer.book;

import ua.mk.nepomnyachshaya.model.Book;

import java.util.List;

/**
 *
 */
public interface BookDAO {
    public Book add (Book book);
    public void delete(long Id);
    public Book update(Book book);
    public Book get(long Id);
    public List<Book> getAll();
    public List<Book> getBooksByName(String nameOfBook);
    public List<Book> getBooksByAuthorSurname(String surnameOfAuthor);
    public List<Book> getBooksByCategoryName(String nameOfCategory);
}
