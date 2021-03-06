package by.bsuir.ief.rest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "user")
public class User implements Cloneable {
    private Integer idUser;
    private String login;
    private String password;
    private Byte statusSession;
    private Byte statusActive;
    private Person person;
    private TypeUser type_user;

    public User() {
        this.idUser = 0;
        this.login = "";
        this.password = "";
        this.statusSession = 0;
        this.statusActive = 0;
        this.person = new Person();
        this.type_user = new TypeUser();
    }

    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name="password",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "status_session", nullable = true)
    public Byte getStatusSession() {
        return statusSession;
    }

    public void setStatusSession(Byte statusSession) {
        this.statusSession = statusSession;
    }

    @Basic
    @Column(name = "status_active", nullable = true)
    public Byte getStatusActive() {
        return statusActive;
    }

    public void setStatusActive(Byte statusActive) {
        this.statusActive = statusActive;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getIdUser().equals(user.getIdUser())) return false;
        if (!getLogin().equalsIgnoreCase(user.getLogin())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getStatusSession().equals(user.getStatusSession())) return false;
        if (!getStatusActive().equals(user.getStatusActive())) return false;
        if (!getPerson().equals(user.getPerson())) return false;
        if (!getType_user().equals(user.getType_user())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = getIdUser().hashCode();
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getStatusSession().hashCode();
        result = 31 * result + getStatusActive().hashCode();
        result = 31 * result + getPerson().hashCode();
        result = 31 * result + getType_user().hashCode();
        return result;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_user", referencedColumnName = "id_type_user", nullable = false)
    public TypeUser getType_user() {
        return type_user;
    }

    public void setType_user(TypeUser type_user) {
        this.type_user = type_user;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", statusSession=" + statusSession +
                ", statusActive=" + statusActive +
                ", person=" + person.toString() +
                ", type_user=" + type_user.toString() +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
