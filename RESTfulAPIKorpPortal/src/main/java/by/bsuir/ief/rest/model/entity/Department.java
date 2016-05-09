package by.bsuir.ief.rest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "department")
public class Department implements Cloneable {
    private Integer idDepartment;
    private String nameDepartment;
    private String wayWork;

    public Department() {
        this.idDepartment = 0;
        this.nameDepartment = "";
        this.wayWork = "";
    }

    @Id
    @Column(name = "id_department", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Basic
    @Column(name = "name_department", nullable = false, length = 60)
    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }


    @Basic
    @Column(name = "way_work", nullable = true, length = 45)
    public String getWayWork() {
        return wayWork;
    }

    public void setWayWork(String wayWork) {
        this.wayWork = wayWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (idDepartment != null ? !idDepartment.equals(that.idDepartment) : that.idDepartment != null) return false;
        if (nameDepartment != null ? !nameDepartment.equals(that.nameDepartment) : that.nameDepartment != null)
            return false;

        if (wayWork != null ? !wayWork.equals(that.wayWork) : that.wayWork != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDepartment != null ? idDepartment.hashCode() : 0;
        result = 31 * result + (nameDepartment != null ? nameDepartment.hashCode() : 0);
        result = 31 * result + (wayWork != null ? wayWork.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", nameDepartment='" + nameDepartment + '\'' +
                ", wayWork='" + wayWork + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
