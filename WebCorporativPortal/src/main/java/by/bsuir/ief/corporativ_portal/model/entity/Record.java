package by.bsuir.ief.corporativ_portal.model.entity;

import java.sql.Timestamp;
import java.util.Set;

public class Record {
    private Integer idRecord;
    private String content;
    private Timestamp date;
    private Set<Comment> comments;

    public Integer getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(Integer idRecord) {
        this.idRecord = idRecord;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

        Record record = (Record) o;

        if (idRecord != null ? !idRecord.equals(record.idRecord) : record.idRecord != null) return false;
        if (content != null ? !content.equals(record.content) : record.content != null) return false;
        if (date != null ? !date.equals(record.date) : record.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRecord != null ? idRecord.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
