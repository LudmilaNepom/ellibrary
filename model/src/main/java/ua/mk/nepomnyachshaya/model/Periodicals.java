package ua.mk.nepomnyachshaya.model;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "Periodicals")
@NamedQuery(name = "Periodicals.getAll", query = "SELECT p from Periodicals p")
public class Periodicals extends Edition {
    @Column
    private String issueNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "periodicals_type")
    private Type type;
    @Column
    private int periodicityOfYear;


    enum Type {NEWSPAPER, JOURNAL, BULLETIN}

    public Periodicals() {
    }

    public Periodicals(String name, int year, String isbnOrIssn, String issueNumber, Type type) {
        super(name, year, isbnOrIssn);
        this.issueNumber = issueNumber;
        this.type = type;
        this.setIsbnOrIssn("ISSN: " + this.getIsbnOrIssn());
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setPeriodicityOfYear(int periodicityOfYear) {
        this.periodicityOfYear = periodicityOfYear;
    }

    public int getPeriodicityOfYear() {
        return periodicityOfYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Periodicals)) return false;
        if (!super.equals(o)) return false;

        Periodicals that = (Periodicals) o;

        if (getIssueNumber() != null ? !getIssueNumber().equals(that.getIssueNumber()) : that.getIssueNumber() != null)
            return false;
        return getType() == that.getType();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getIssueNumber() != null ? getIssueNumber().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "Periodicals{" +
                "issueNumber='" + issueNumber + '\'' +
                ", type=" + type +
                '}';
    }
}
