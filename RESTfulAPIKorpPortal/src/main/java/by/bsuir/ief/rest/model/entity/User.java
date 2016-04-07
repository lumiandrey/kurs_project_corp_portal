package by.bsuir.ief.rest.model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
public class User {
    private Integer idUser;
    private String login;
    private String password;
    private Byte statusSession;
    private Byte statusActive;
    private Integer idPerson;
    private TypeUser type_user;
    private List<Record> records;

    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Basic
    @Column(name = "id_person", nullable = false)
    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != null ? !idUser.equals(user.idUser) : user.idUser != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (statusSession != null ? !statusSession.equals(user.statusSession) : user.statusSession != null)
            return false;
        if (statusActive != null ? !statusActive.equals(user.statusActive) : user.statusActive != null) return false;
        if (idPerson != null ? !idPerson.equals(user.idPerson) : user.idPerson != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser != null ? idUser.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (statusSession != null ? statusSession.hashCode() : 0);
        result = 31 * result + (statusActive != null ? statusActive.hashCode() : 0);
        result = 31 * result + (idPerson != null ? idPerson.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_type_user", referencedColumnName = "id_type_user", nullable = false)
    public TypeUser getType_user() {
        return type_user;
    }

    public void setType_user(TypeUser type_user) {
        this.type_user = type_user;
    }

    @OneToMany
    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
