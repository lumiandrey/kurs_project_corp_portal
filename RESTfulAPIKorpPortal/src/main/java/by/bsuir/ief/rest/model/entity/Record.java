package by.bsuir.ief.rest.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//import org.joda.time.DateTime;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "record")
public class Record implements Cloneable{
    private Integer idRecord;
    private String content;
    private Date date;
    private Integer user_id_user;
    private Set<Comment> comments;

    public Record() {
        this.idRecord = 0;
        this.content = "";
        this.date = new Date(123_123_123_123L);

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
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "user_id_user", nullable = false)
    public Integer getUser_id_user() {
        return user_id_user;
    }

    public void setUser_id_user(Integer user_id_user) {
        this.user_id_user = user_id_user;
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="record_id_record",referencedColumnName ="id_record" )
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Record{" +
                "idRecord=" + idRecord +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", user_id_user=" + user_id_user +
                ", comments=" + comments.size() +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
