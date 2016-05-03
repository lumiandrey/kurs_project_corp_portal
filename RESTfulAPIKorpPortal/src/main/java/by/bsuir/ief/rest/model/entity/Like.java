package by.bsuir.ief.rest.model.entity;

import javax.persistence.*;

import org.hibernate.annotations.Type;
//import org.joda.time.DateTime;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "like")
@IdClass(LikePK.class)
public class Like {
    private Integer recordIdRecord;
    private java.util.Date date;
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
    @Temporal(TemporalType.DATE)
    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
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
}
