package ua.mk.nepomnyachshaya.datalayer.category;

import ua.mk.nepomnyachshaya.model.Category;

import java.util.List;

/**
 *
 */
public interface CategoryDAO {
     Category add (Category category);
     void delete(int Id);
     Category update(Category category);
     Category get(int Id);
     List<Category> getAll();
}
