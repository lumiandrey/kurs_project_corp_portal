package by.bsuir.ief.rest.model.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
public class Task {
    private Integer id_task;
    private String name;
    private Byte current;
    private Set<Person> persons;
    private Calendar begin_data;
    private Calendar end_data;
    private TypeTask type_pask;
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
    public Byte getCurrent() {
        return current;
    }

    public void setCurrent(Byte current) {
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

    @ManyToMany(mappedBy = "taskes")
    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @OneToOne
    @JoinColumn(name = "id_data_begin", referencedColumnName = "id_calendar", nullable = false)
    public Calendar getBegin_data() {
        return begin_data;
    }

    public void setBegin_data(Calendar begin_data) {
        this.begin_data = begin_data;
    }

    @OneToOne
    @JoinColumn(name = "id_data_end", referencedColumnName = "id_calendar", nullable = false)
    public Calendar getEnd_data() {
        return end_data;
    }

    public void setEnd_data(Calendar end_data) {
        this.end_data = end_data;
    }

    @ManyToOne
    @JoinColumn(name = "id_type_task", referencedColumnName = "id_type_task", nullable = false)
    public TypeTask getType_pask() {
        return type_pask;
    }

    public void setType_pask(TypeTask type_pask) {
        this.type_pask = type_pask;
    }
}
