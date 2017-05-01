package ua.mk.nepomnyachshaya.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 *
 */
@NamedQueries(
        @NamedQuery(name = "Author.getAll", query = "SELECT a from Author a")
)
@Entity
@Table(name = "Author")

public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String middleName;
    @Column
    @Temporal(TemporalType.DATE)
    private Calendar birthDate;
    @Column
    private String vita;

    public Author() {
    }

    public Author(String firstName, String lastName, String middleName, Calendar birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setVita(String vita) {
        this.vita = vita;
    }

    public String getVita() {
        return vita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (getId() != author.getId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(author.getFirstName()) : author.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(author.getLastName()) : author.getLastName() != null)
            return false;
        if (getMiddleName() != null ? !getMiddleName().equals(author.getMiddleName()) : author.getMiddleName() != null)
            return false;
        if (getBirthDate() != null ? !getBirthDate().equals(author.getBirthDate()) : author.getBirthDate() != null)
            return false;
        return getVita() != null ? getVita().equals(author.getVita()) : author.getVita() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getMiddleName() != null ? getMiddleName().hashCode() : 0);
        result = 31 * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
        result = 31 * result + (getVita() != null ? getVita().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Автор: " +
                firstName +
                lastName +
                ", vita=" + vita;
    }
}
