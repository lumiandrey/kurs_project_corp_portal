package by.bsuir.ief.rest.model.entity.views;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by andrey on 05.05.2016.
 */
public class ShowUnreadedMessage {
    private String login;
    private String content;
    private Date date;
    private Integer userRec;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserRec() {
        return userRec;
    }

    public void setUserRec(Integer userRec) {
        this.userRec = userRec;
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
