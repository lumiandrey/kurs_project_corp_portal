package by.bsuir.ief.rest.model.entity.views;

import by.bsuir.ief.rest.util.CustomDateDeserializer;
import by.bsuir.ief.rest.util.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by andrey on 05.05.2016.
 */
public class ShowUnreadedMessage {
    private String login;
    private String content;
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern="yyyy-MM-dd HH:MM:SS")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private DateTime date;
    private Integer userRec;
    private Integer userSender;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public DateTime getDate() {
        return date;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setDate(DateTime date) {
        this.date = date;
    }

    public Integer getUserRec() {
        return userRec;
    }

    public void setUserRec(Integer userRec) {
        this.userRec = userRec;
    }

    public Integer getUserSender() {
        return userSender;
    }

    public void setUserSender(Integer userSender) {
        this.userSender = userSender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShowUnreadedMessage that = (ShowUnreadedMessage) o;

        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (userRec != null ? !userRec.equals(that.userRec) : that.userRec != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (userRec != null ? userRec.hashCode() : 0);
        return result;
    }
}
