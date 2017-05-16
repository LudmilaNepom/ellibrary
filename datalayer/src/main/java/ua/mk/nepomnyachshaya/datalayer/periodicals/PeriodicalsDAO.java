package ua.mk.nepomnyachshaya.datalayer.periodicals;

import ua.mk.nepomnyachshaya.model.Periodicals;

import java.util.List;

/**
 *
 */
public interface PeriodicalsDAO {
     Periodicals add (Periodicals periodicals);
     void delete(int Id);
     Periodicals update(Periodicals periodicals);
     Periodicals get(int Id);
     List<Periodicals> getAll();
}
