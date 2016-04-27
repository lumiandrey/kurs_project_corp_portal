package by.bsuir.ief.corporativ_portal.model.entity;

import java.util.List;
import javax.validation.constraints.Size;


public class User {
    private Integer idUser;
    @Size(min = 6, message = "Имя должно быть больше 6 знаков")
    private String login;

    @Size(min = 5, max = 10, message = "Пароль должен быть от 5 до 10 знаков")
    private String password;

    private Byte statusSession;
    private Byte statusActive;
    private Integer idPerson;
    //private TypeUser type_user;
    //private List<Record> records;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getStatusSession() {
        return statusSession;
    }

    public void setStatusSession(Byte statusSession) {
        this.statusSession = statusSession;
    }

    public Byte getStatusActive() {
        return statusActive;
    }

    public void setStatusActive(Byte statusActive) {
        this.statusActive = statusActive;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    /*public TypeUser getType_user() {
        return type_user;
    }

    public void setType_user(TypeUser type_user) {
        this.type_user = type_user;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }*/

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
}
