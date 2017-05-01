package ua.mk.nepomnyachshaya.datalayer.category;

import ua.mk.nepomnyachshaya.model.Category;

import java.util.List;

/**
 *
 */
public interface CategoryDAO {
    public Category add (Category category);
    public void delete(long Id);
    public Category update(Category category);
    public Category get(long Id);
    public List<Category> getAll();
}
