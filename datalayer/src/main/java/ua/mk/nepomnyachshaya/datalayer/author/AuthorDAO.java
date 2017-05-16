package ua.mk.nepomnyachshaya.datalayer.author;

import ua.mk.nepomnyachshaya.model.Author;

import java.util.List;

/**
 *
 */
public interface AuthorDAO {
     Author add (Author author);
     void delete(int Id);
     Author update(Author author);
     Author get(int Id);
     List<Author> getAll();
     List<Author> getAuthorsByBookId(int id);
     List<Author> getAuthorsByFirstLettersOfSurname(String str);
}
