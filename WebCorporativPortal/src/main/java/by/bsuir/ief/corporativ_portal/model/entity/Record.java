package by.bsuir.ief.corporativ_portal.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
public class Record {
    private Integer idRecord;
    private String content;
    private Timestamp date;
    private User user;
    private Set<Comment> comments;

    public Record() {
        this.idRecord = 0;
        this.content = "";
        this.date = new Timestamp(123_123_123_123L);
        this.user = new User();
        this.comments = new HashSet<>();
    }

    @Id
    @Column(name = "id_record", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(Integer idRecord) {
        this.idRecord = idRecord;
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
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "user_id_user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @OneToMany
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
