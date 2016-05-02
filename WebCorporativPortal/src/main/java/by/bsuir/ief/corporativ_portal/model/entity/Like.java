package by.bsuir.ief.corporativ_portal.model.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "like")
@IdClass(LikePK.class)
public class Like implements Cloneable {
    private Integer recordIdRecord;
    private DateTime date;
    private Integer userIdUser;
    private Integer commentIdComment;

    @Id
    @Column(name = "record_id_record", nullable = false)
    public Integer getRecordIdRecord() {
        return recordIdRecord;
    }

    public void setRecordIdRecord(Integer recordIdRecord) {
        this.recordIdRecord = recordIdRecord;
    }

    @Basic
    @Column(name = "date", nullable = true)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    @Id
    @Column(name = "user_id_user", nullable = false)
    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Basic
    @Column(name = "comment_id_comment", nullable = false)
    public Integer getCommentIdComment() {
        return commentIdComment;
    }

    public void setCommentIdComment(Integer commentIdComment) {
        this.commentIdComment = commentIdComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Like like = (Like) o;

        if (recordIdRecord != null ? !recordIdRecord.equals(like.recordIdRecord) : like.recordIdRecord != null)
            return false;
        if (date != null ? !date.equals(like.date) : like.date != null) return false;
        if (userIdUser != null ? !userIdUser.equals(like.userIdUser) : like.userIdUser != null) return false;
        if (commentIdComment != null ? !commentIdComment.equals(like.commentIdComment) : like.commentIdComment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordIdRecord != null ? recordIdRecord.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (userIdUser != null ? userIdUser.hashCode() : 0);
        result = 31 * result + (commentIdComment != null ? commentIdComment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Like{" +
                "recordIdRecord=" + recordIdRecord +
                ", date=" + date +
                ", userIdUser=" + userIdUser +
                ", commentIdComment=" + commentIdComment +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
