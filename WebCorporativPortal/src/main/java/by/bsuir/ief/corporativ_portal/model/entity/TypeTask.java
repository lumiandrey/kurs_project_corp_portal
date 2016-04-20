package by.bsuir.ief.corporativ_portal.model.entity;

import java.util.List;

public class TypeTask {
    private Integer idTypeTask;
    private String nameTypeTask;
    private Double complication;
    private List<Task> task;

    public Integer getIdTypeTask() {
        return idTypeTask;
    }

    public void setIdTypeTask(Integer idTypeTask) {
        this.idTypeTask = idTypeTask;
    }

    public String getNameTypeTask() {
        return nameTypeTask;
    }

    public void setNameTypeTask(String nameTypeTask) {
        this.nameTypeTask = nameTypeTask;
    }

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

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }
}
