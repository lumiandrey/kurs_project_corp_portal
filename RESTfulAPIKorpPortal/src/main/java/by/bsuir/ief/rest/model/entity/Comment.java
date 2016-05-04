package by.bsuir.ief.rest.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "comment")
public class Comment implements Cloneable {
    private Integer idComment;
    private String content;
    private Date date;

    @Id
    @Column(name = "id_comment", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 1000)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "date", nullable = true)
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (idComment != null ? !idComment.equals(comment.idComment) : comment.idComment != null) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        if (date != null ? !date.equals(comment.date) : comment.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idComment != null ? idComment.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "idComment=" + idComment +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
