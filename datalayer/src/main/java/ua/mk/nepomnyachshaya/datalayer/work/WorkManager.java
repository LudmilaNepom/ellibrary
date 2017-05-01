package ua.mk.nepomnyachshaya.datalayer.work;

import org.springframework.stereotype.Repository;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.Work;

/**
 *
 */
@Repository
public class WorkManager extends AbstractDAO<Work> implements WorkDAO {

    public WorkManager(){
        super(Work.class);
    }
}
