package by.bsuir.ief.corporativ_portal.model.entity;

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
    private Date date_begin;
    private Date date_end;
    private TypeTask type_pask;
    private Integer complited;
    private Boolean done;
    @Id
    @Column(name = "id_task", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
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



    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_type_task", referencedColumnName = "id_type_task", nullable = false)
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
    @Column(name = "date_begin", nullable = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public Date getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(Date date_begin) {
        this.date_begin = date_begin;
    }

    @Basic
    @Column(name = "date_end", nullable = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    @Basic
    @Column(name = "complited", nullable = true)
    public Integer getComplited() {
        return complited;
    }

    public void setComplited(Integer complited) {
        this.complited = complited;
    }

    @Basic
    @Column(name = "done", nullable = true)
    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (getId_task() != null ? !getId_task().equals(task.getId_task()) : task.getId_task() != null) return false;
        if (getName() != null ? !getName().equals(task.getName()) : task.getName() != null) return false;
        if (getCurrent() != null ? !getCurrent().equals(task.getCurrent()) : task.getCurrent() != null) return false;
        if (getDate_begin() != null ? !getDate_begin().equals(task.getDate_begin()) : task.getDate_begin() != null)
            return false;
        if (getDate_end() != null ? !getDate_end().equals(task.getDate_end()) : task.getDate_end() != null)
            return false;
        if (getType_pask() != null ? !getType_pask().equals(task.getType_pask()) : task.getType_pask() != null)
            return false;
        if (getComplited() != null ? !getComplited().equals(task.getComplited()) : task.getComplited() != null)
            return false;
        return getDone() != null ? getDone().equals(task.getDone()) : task.getDone() == null;

    }

    @Override
    public int hashCode() {
        int result = getId_task() != null ? getId_task().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCurrent() != null ? getCurrent().hashCode() : 0);
        result = 31 * result + (getDate_begin() != null ? getDate_begin().hashCode() : 0);
        result = 31 * result + (getDate_end() != null ? getDate_end().hashCode() : 0);
        result = 31 * result + (getType_pask() != null ? getType_pask().hashCode() : 0);
        result = 31 * result + (getComplited() != null ? getComplited().hashCode() : 0);
        result = 31 * result + (getDone() != null ? getDone().hashCode() : 0);
        return result;
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
