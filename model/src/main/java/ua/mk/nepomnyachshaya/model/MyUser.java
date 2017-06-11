package ua.mk.nepomnyachshaya.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="MyUser")
@NamedQueries ({@NamedQuery(name = "MyUser.getAll", query = "SELECT mu from MyUser mu"),
@NamedQuery(name = "MyUser.getByName", query = "SELECT mu from MyUser mu where mu.name=:name")
        })
public class MyUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name="name", unique=true, nullable=false)
    private String name;

    @NotEmpty
    @Column(name="password", nullable=false)
    private String password;

    @Column(name="role", nullable=false)
    private String userRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyUser user = (MyUser) o;

        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (!getName().equals(user.getName())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        return getUserRole() .equals(user.getUserRole());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getUserRole() != null ? getUserRole().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MyUser{" +

                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
