package ua.mk.nepomnyachshaya.datalayer.periodicals;

import org.springframework.stereotype.Repository;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.Periodicals;

/**
 *
 */
@Repository
public class PeriodicalsManager extends AbstractDAO<Periodicals> implements PeriodicalsDAO {

    public PeriodicalsManager(){
        super(Periodicals.class);
    }
}
