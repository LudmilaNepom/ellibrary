package ua.mk.nepomnyachshaya.datalayer.work;

import ua.mk.nepomnyachshaya.model.Work;

import java.util.List;

public interface WorkDAO {
     Work add (Work work);
     void delete(int Id);
     Work update(Work work);
     Work get(int Id);
     List<Work> getAll();
}
