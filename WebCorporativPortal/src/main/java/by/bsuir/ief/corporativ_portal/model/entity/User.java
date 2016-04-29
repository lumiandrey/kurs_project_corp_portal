package by.bsuir.ief.corporativ_portal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
public class User {

    private static final int MIN_SIZE_LOGIN_AND_PASSWORD = 4;

    private Integer idUser;
    @Size(min = MIN_SIZE_LOGIN_AND_PASSWORD, message = "Длина логина должна быть больше "
            +MIN_SIZE_LOGIN_AND_PASSWORD+" символов")
    private String login;
    @Size(min = MIN_SIZE_LOGIN_AND_PASSWORD, message = "Длина пароля должна быть больше "
            +MIN_SIZE_LOGIN_AND_PASSWORD+" символов")
    private String password;
    private Byte statusSession;
    private Byte statusActive;
    private Person person;
    private TypeUser type_user;
    private List<Record> records;
    private Set<Message> messages;

    public User() {
        this.idUser = 0;
        this.login = "";
        this.password = "";
        this.statusSession = 0;
        this.statusActive = 0;
        this.person = null;
        this.type_user = new TypeUser();
        this.records = new ArrayList<>();
        this.messages = new HashSet<>();
    }

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

    @OneToOne
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
        if (!getLogin().equals(user.getLogin())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getStatusSession().equals(user.getStatusSession())) return false;
        if (!getStatusActive().equals(user.getStatusActive())) return false;
        if (!getPerson().equals(user.getPerson())) return false;
        if (!getType_user().equals(user.getType_user())) return false;
        if (!getRecords().equals(user.getRecords())) return false;
        return getMessages().equals(user.getMessages());

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
        result = 31 * result + getRecords().hashCode();
        result = 31 * result + getMessages().hashCode();
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

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user", cascade=CascadeType.ALL,
            orphanRemoval=true)
    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "message_receiver", schema = "korporativ_portal",
            joinColumns = @JoinColumn(name = "id_user_receiver", referencedColumnName = "id_user",
                    nullable = false), inverseJoinColumns = @JoinColumn(name = "id_message",
            referencedColumnName = "id_message", nullable = false))
    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
