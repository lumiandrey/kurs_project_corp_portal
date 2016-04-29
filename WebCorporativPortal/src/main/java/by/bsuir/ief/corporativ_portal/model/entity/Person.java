package by.bsuir.ief.corporativ_portal.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
public class Person {
    private Integer idPerson;
    private String firstName;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    private String status;
    private String eMail;
    private String linkSelfSite;
    private Double rating;
    private City city;
    private Department department;
    private Post post;
    private Set<Task> tasks;

    @Id
    @Column(name = "id_person", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    @Basic
    @Column(name = "firts_name", nullable = false, length = 45)
    public String getFirtsName() {
        return firstName;
    }

    public void setFirtsName(String firtsName) {
        this.firstName = firtsName;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "date_of_birth", nullable = false)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "sex", nullable = false, length = 45)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "e-mail", nullable = false, length = 45)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "link_self_site", nullable = false, length = 45)
    public String getLinkSelfSite() {
        return linkSelfSite;
    }

    public void setLinkSelfSite(String linkSelfSite) {
        this.linkSelfSite = linkSelfSite;
    }

    @Basic
    @Column(name = "rating", nullable = false, precision = 0)
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (idPerson != null ? !idPerson.equals(person.idPerson) : person.idPerson != null) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(person.dateOfBirth) : person.dateOfBirth != null) return false;
        if (sex != null ? !sex.equals(person.sex) : person.sex != null) return false;
        if (status != null ? !status.equals(person.status) : person.status != null) return false;
        if (eMail != null ? !eMail.equals(person.eMail) : person.eMail != null) return false;
        if (linkSelfSite != null ? !linkSelfSite.equals(person.linkSelfSite) : person.linkSelfSite != null)
            return false;
        if (rating != null ? !rating.equals(person.rating) : person.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPerson != null ? idPerson.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (linkSelfSite != null ? linkSelfSite.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id_city", nullable = false)
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name = "id_division", referencedColumnName = "id_department", nullable = false)
    public Department getDepatment() {
        return department;
    }

    public void setDepatment(Department depatment) {
        this.department = depatment;
    }

    @ManyToOne
    @JoinColumn(name = "id_post", referencedColumnName = "id_post", nullable = false)
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @ManyToMany
    @JoinTable(name = "task_has_person", schema = "korporativ_portal",
            joinColumns = @JoinColumn(name = "id_person", referencedColumnName = "id_person",
                    nullable = false), inverseJoinColumns = @JoinColumn(name = "id_task",
            referencedColumnName = "id_task", nullable = false))
    public Set<Task> getTaskes() {
        return tasks;
    }

    public void setTaskes(Set<Task> taskes) {
        this.tasks = taskes;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex='" + sex + '\'' +
                ", status='" + status + '\'' +
                ", eMail='" + eMail + '\'' +
                ", linkSelfSite='" + linkSelfSite + '\'' +
                ", rating=" + rating +
                ", city=" + city +
                ", department=" + department +
                ", post=" + post +
                ", tasks=" + tasks +
                '}';
    }
}
