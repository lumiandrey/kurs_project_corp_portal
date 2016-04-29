package by.bsuir.ief.corporativ_portal.model.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
public class Post {
    private Integer idPost;
    private String namePost;
    private String rang;
    private Integer income;
    private String workingSchedule;
    private Set<Person> persons;

    @Id
    @Column(name = "id_post", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    @Basic
    @Column(name = "name_post", nullable = false, length = 60)
    public String getNamePost() {
        return namePost;
    }

    public void setNamePost(String namePost) {
        this.namePost = namePost;
    }

    @Basic
    @Column(name = "rang", nullable = false, length = 45)
    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    @Basic
    @Column(name = "income", nullable = false)
    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    @Basic
    @Column(name = "working_schedule", nullable = false, length = 45)
    public String getWorkingSchedule() {
        return workingSchedule;
    }

    public void setWorkingSchedule(String workingSchedule) {
        this.workingSchedule = workingSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (idPost != null ? !idPost.equals(post.idPost) : post.idPost != null) return false;
        if (namePost != null ? !namePost.equals(post.namePost) : post.namePost != null) return false;
        if (rang != null ? !rang.equals(post.rang) : post.rang != null) return false;
        if (income != null ? !income.equals(post.income) : post.income != null) return false;
        if (workingSchedule != null ? !workingSchedule.equals(post.workingSchedule) : post.workingSchedule != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPost != null ? idPost.hashCode() : 0;
        result = 31 * result + (namePost != null ? namePost.hashCode() : 0);
        result = 31 * result + (rang != null ? rang.hashCode() : 0);
        result = 31 * result + (income != null ? income.hashCode() : 0);
        result = 31 * result + (workingSchedule != null ? workingSchedule.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "post")
    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
