package by.bsuir.ief.rest.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
public class Department {
    private Integer idDepartment;
    private String nameDepartment;
    private Integer countEmployees;
    private String wayWork;
    private Set<Person> persons;

    @Id
    @Column(name = "id_department", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "count_employees", nullable = false)
    public Integer getCountEmployees() {
        return countEmployees;
    }

    public void setCountEmployees(Integer countEmployees) {
        this.countEmployees = countEmployees;
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
        if (countEmployees != null ? !countEmployees.equals(that.countEmployees) : that.countEmployees != null)
            return false;
        if (wayWork != null ? !wayWork.equals(that.wayWork) : that.wayWork != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDepartment != null ? idDepartment.hashCode() : 0;
        result = 31 * result + (nameDepartment != null ? nameDepartment.hashCode() : 0);
        result = 31 * result + (countEmployees != null ? countEmployees.hashCode() : 0);
        result = 31 * result + (wayWork != null ? wayWork.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "depatment")
    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
