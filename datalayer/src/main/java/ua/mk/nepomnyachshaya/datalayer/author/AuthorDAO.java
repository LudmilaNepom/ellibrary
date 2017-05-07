package ua.mk.nepomnyachshaya.datalayer.author;

import ua.mk.nepomnyachshaya.model.Author;

import java.util.List;

/**
 *
 */
public interface AuthorDAO {
     Author add (Author author);
     void delete(long Id);
     Author update(Author author);
     Author get(long Id);
     List<Author> getAll();
     List<Author> getAuthorsByBookId(long id);
     List<Author> getAuthorsByFirstLettersOfSurname(String str);
}
