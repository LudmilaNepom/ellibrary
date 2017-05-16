package ua.mk.nepomnyachshaya.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReviewableForDB {
    @Column
    String aClass;
    @Column
    String name;
    @Column
    Integer idOf;


    public ReviewableForDB() {
    }

    public ReviewableForDB(Reviewable reviewable){
        this.aClass=reviewable.getClass().getSimpleName();
        if (aClass.equalsIgnoreCase("Book")){
            name=((Book)reviewable).getName();
            idOf=((Book)reviewable).getId();

        } else if (aClass.equalsIgnoreCase("Work")){
            name=((Work)reviewable).getNameOfWork();
            idOf=((Work)reviewable).getId();
        } else if (aClass.equalsIgnoreCase("Series")){
            name=((Series)reviewable).getNameOfSeries();
            idOf=((Series)reviewable).getId();
        } else {
            name="неизвестный объект";
            idOf=0;

        }
    }

    public Integer getIdOf() {
        return idOf;
    }

    public void setIdOf(Integer idOf) {
        this.idOf = idOf;
    }

    public String getaClass() {
        return aClass;
    }

    public void setaClass(String aClass) {
        this.aClass = aClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewableForDB)) return false;

        ReviewableForDB that = (ReviewableForDB) o;

        if (!getaClass().equals(that.getaClass())) return false;
        if (!getName().equals(that.getName())) return false;
        return idOf != null ? idOf.equals(that.idOf) : that.idOf == null;

    }

    @Override
    public int hashCode() {
        int result = getaClass().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (idOf != null ? idOf.hashCode() : 0);
        return result;
    }
}
