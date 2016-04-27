package by.bsuir.ief.corporativ_portal.model.entity;

import java.sql.Timestamp;

public class Like {
    private Integer recordIdRecord;
    private Timestamp date;
    private Integer userIdUser;
    private Integer commentIdComment;

    public Integer getRecordIdRecord() {
        return recordIdRecord;
    }

    public void setRecordIdRecord(Integer recordIdRecord) {
        this.recordIdRecord = recordIdRecord;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
    }

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
