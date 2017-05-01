package ua.mk.nepomnyachshaya.datalayer.periodicals;

import ua.mk.nepomnyachshaya.model.Periodicals;

import java.util.List;

/**
 *
 */
public interface PeriodicalsDAO {
    public Periodicals add (Periodicals periodicals);
    public void delete(long Id);
    public Periodicals update(Periodicals periodicals);
    public Periodicals get(long Id);
    public List<Periodicals> getAll();
}
