package ua.mk.nepomnyachshaya.datalayer.author;

import ua.mk.nepomnyachshaya.model.Author;

import java.util.List;

/**
 *
 */
public interface AuthorDAO {
    public Author add (Author author);
    public void delete(long Id);
    public Author update(Author author);
    public Author get(long Id);
    public List<Author> getAll();
    public List<Author> getAuthorsByBookId(long id);
    public List<Author> getAuthorsByFirstLettersOfSurname(String str);
}
