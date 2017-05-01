package ua.mk.nepomnyachshaya.datalayer.series;

import org.springframework.stereotype.Repository;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.Series;

/**
 *
 */
@Repository
public class SeriesManager extends AbstractDAO<Series> implements SeriesDAO {

    public SeriesManager(){
        super(Series.class);
    }
}
