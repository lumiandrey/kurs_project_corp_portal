package by.bsuir.ief.corporativ_portal.model.entity;

import java.util.List;
import javax.validation.constraints.Size;


public class User {
    private Integer idUser;
    @Size(min = 6, message = "Логин должен быть больше 6 знаков")
    private String login;

    @Size(min = 5, max = 16, message = "Пароль должен быть от 5 до 16 знаков")
    private String password;

    private Byte statusSession;
    private Byte statusActive;
    private Integer idPerson;
    private TypeUser type_user;
    private List<Record> records;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getIdUser() != null ? !getIdUser().equals(user.getIdUser()) : user.getIdUser() != null) return false;
        if (getLogin() != null ? !getLogin().equals(user.getLogin()) : user.getLogin() != null) return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getStatusSession() != null ? !getStatusSession().equals(user.getStatusSession()) : user.getStatusSession() != null)
            return false;
        if (getStatusActive() != null ? !getStatusActive().equals(user.getStatusActive()) : user.getStatusActive() != null)
            return false;
        if (getIdPerson() != null ? !getIdPerson().equals(user.getIdPerson()) : user.getIdPerson() != null)
            return false;
        if (getType_user() != null ? !getType_user().equals(user.getType_user()) : user.getType_user() != null)
            return false;
        return getRecords() != null ? getRecords().equals(user.getRecords()) : user.getRecords() == null;

    }

    @Override
    public int hashCode() {
        int result = getIdUser() != null ? getIdUser().hashCode() : 0;
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getStatusSession() != null ? getStatusSession().hashCode() : 0);
        result = 31 * result + (getStatusActive() != null ? getStatusActive().hashCode() : 0);
        result = 31 * result + (getIdPerson() != null ? getIdPerson().hashCode() : 0);
        result = 31 * result + (getType_user() != null ? getType_user().hashCode() : 0);
        result = 31 * result + (getRecords() != null ? getRecords().hashCode() : 0);
        return result;
    }

    public TypeUser getType_user() {
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
    }
}
