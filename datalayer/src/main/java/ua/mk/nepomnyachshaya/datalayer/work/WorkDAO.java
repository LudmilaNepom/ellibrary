package ua.mk.nepomnyachshaya.datalayer.work;

import ua.mk.nepomnyachshaya.model.Work;

import java.util.List;

/**
 * Created by User on 06.03.2017.
 */
public interface WorkDAO {
    public Work add (Work work);
    public void delete(long Id);
    public Work update(Work work);
    public Work get(long Id);
    public List<Work> getAll();
}
