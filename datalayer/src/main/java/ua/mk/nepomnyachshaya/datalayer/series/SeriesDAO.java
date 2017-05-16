package ua.mk.nepomnyachshaya.datalayer.series;

import ua.mk.nepomnyachshaya.model.Series;

import java.util.List;

/**
 *
 */
public interface SeriesDAO {
     Series add (Series series);
     void delete(int Id);
     Series update(Series series);
     Series get(int Id);
     List<Series> getAll();
}
