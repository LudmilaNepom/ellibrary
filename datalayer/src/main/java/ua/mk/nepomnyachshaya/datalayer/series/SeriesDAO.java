package ua.mk.nepomnyachshaya.datalayer.series;

import ua.mk.nepomnyachshaya.model.Series;

import java.util.List;

/**
 *
 */
public interface SeriesDAO {
    public Series add (Series series);
    public void delete(long Id);
    public Series update(Series series);
    public Series get(long Id);
    public List<Series> getAll();
}
