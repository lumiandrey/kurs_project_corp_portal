package by.bsuir.ief.rest.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
public class Message {
    private Integer idMessage;
    private String content;
    private Integer idUserSender;
    private Timestamp date;

    @Id
    @Column(name = "id_message", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "id_user_sender", nullable = false)
    public Integer getIdUserSender() {
        return idUserSender;
    }

    public void setIdUserSender(Integer idUserSender) {
        this.idUserSender = idUserSender;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (idMessage != null ? !idMessage.equals(message.idMessage) : message.idMessage != null) return false;
        if (content != null ? !content.equals(message.content) : message.content != null) return false;
        if (idUserSender != null ? !idUserSender.equals(message.idUserSender) : message.idUserSender != null)
            return false;
        if (date != null ? !date.equals(message.date) : message.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMessage != null ? idMessage.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (idUserSender != null ? idUserSender.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
