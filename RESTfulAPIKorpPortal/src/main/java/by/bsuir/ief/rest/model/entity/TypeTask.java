package by.bsuir.ief.rest.model.entity;

import javax.persistence.*;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "type_task")
public class TypeTask implements Cloneable{
    private Integer idTypeTask;
    private String nameTypeTask;
    private Double complication;

    @Id
    @Column(name = "id_type_task", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdTypeTask() {
        return idTypeTask;
    }

    public void setIdTypeTask(Integer idTypeTask) {
        this.idTypeTask = idTypeTask;
    }

    @Basic
    @Column(name = "name_type_task", nullable = false, length = 45)
    public String getNameTypeTask() {
        return nameTypeTask;
    }

    public void setNameTypeTask(String nameTypeTask) {
        this.nameTypeTask = nameTypeTask;
    }

    @Basic
    @Column(name = "complication", nullable = false, precision = 0)
    public Double getComplication() {
        return complication;
    }

    public void setComplication(Double complication) {
        this.complication = complication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeTask typeTask = (TypeTask) o;

        if (idTypeTask != null ? !idTypeTask.equals(typeTask.idTypeTask) : typeTask.idTypeTask != null) return false;
        if (nameTypeTask != null ? !nameTypeTask.equals(typeTask.nameTypeTask) : typeTask.nameTypeTask != null)
            return false;
        if (complication != null ? !complication.equals(typeTask.complication) : typeTask.complication != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTypeTask != null ? idTypeTask.hashCode() : 0;
        result = 31 * result + (nameTypeTask != null ? nameTypeTask.hashCode() : 0);
        result = 31 * result + (complication != null ? complication.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TypeTask{" +
                "idTypeTask=" + idTypeTask +
                ", nameTypeTask='" + nameTypeTask + '\'' +
                ", complication=" + complication +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
