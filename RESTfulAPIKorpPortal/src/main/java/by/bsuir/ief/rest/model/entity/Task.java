package by.bsuir.ief.rest.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "task")
public class Task implements Cloneable{
    private Integer id_task;
    private String name;
    private Boolean current;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd,HH:00", timezone="CET")
    private Date date_begin;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd,HH:00", timezone="CET")
    private Date date_end;
    private TypeTask type_pask;
    private Integer complited;
    private Boolean done;

    @Id
    @Column(name = "id_task", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public Integer getId_task() {
        return id_task;
    }

    public void setId_task(Integer id_task) {
        this.id_task = id_task;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 150)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "current", nullable = true)
    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (current != null ? !current.equals(task.current) : task.current != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (current != null ? current.hashCode() : 0);
        return result;
    }



    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_type_task", referencedColumnName = "id_type_task", nullable = false)
    @Transient
    public TypeTask getType_pask() {
        return type_pask;
    }

    public void setType_pask(TypeTask type_pask) {
        this.type_pask = type_pask;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    @Basic
    @Column(name = "complited", nullable = false)
    public Integer getComplited() {
        return complited;
    }

    public void setComplited(Integer complited) {
        this.complited = complited;
    }

    @Basic
    @Column(name = "done", nullable = false)
    public Boolean getDone() {
        return done;
    }


    public void setDone(Boolean done) {
        this.done = done;
    }


    @Basic
    @Column(name = "date_end", nullable = false)
    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }


    @Basic
    @Column(name = "date_begin", nullable = false)
    public Date getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(Date date_begin) {
        this.date_begin = date_begin;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id_task=" + id_task +
                ", name='" + name + '\'' +
                ", current=" + current +
                ", date_begin=" + date_begin +
                ", date_end=" + date_end +
                ", type_pask=" + type_pask +
                ", complited=" + complited +
                ", done=" + done +
                '}';
    }
}
