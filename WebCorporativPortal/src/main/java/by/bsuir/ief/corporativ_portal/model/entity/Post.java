package by.bsuir.ief.corporativ_portal.model.entity;

import java.util.Set;

public class Post {
    private Integer idPost;
    private String namePost;
    private String rang;
    private Integer income;
    private String workingSchedule;
    private Set<Person> persons;

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public String getNamePost() {
        return namePost;
    }

    public void setNamePost(String namePost) {
        this.namePost = namePost;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

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

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
