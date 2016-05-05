package by.bsuir.ief.rest.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "person")
public class Person implements Cloneable{
    private Integer idPerson;
    private String lastName;
    private String name;
    private String patronymic;
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


    public Person() {
        this.idPerson = 0;
        this.lastName = "";
        this.name = "";
        this.patronymic = "";
        this.dateOfBirth = null;
        this.sex = "";
        this.status = "";
        this.eMail = "";
        this.linkSelfSite = "";
        this.rating = 0.0;
        this.city = new City();
        this.department = new Department();
        this.post = new Post();
        this.tasks = new HashSet<>();
    }

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
    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String firstName) {
        this.lastName = firstName;
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
    @Column(name = "patronymic", nullable = false, length = 45)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String lastName) {
        this.patronymic = lastName;
    }

    @Basic
    @Temporal(TemporalType.DATE)
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
    @Column(name = "e_mail", nullable = false, length = 45)
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
    @Column(name = "reiting", nullable = false, precision = 0)
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
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (patronymic != null ? !patronymic.equals(person.patronymic) : person.patronymic != null) return false;
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
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (linkSelfSite != null ? linkSelfSite.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch=FetchType. EAGER)
    @JoinColumn(name = "id_city", referencedColumnName = "id_city", nullable = false)
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne(fetch=FetchType. EAGER)
    @JoinColumn(name = "id_division", referencedColumnName = "id_department", nullable = false)
    public Department getDepatment() {
        return department;
    }

    public void setDepatment(Department depatment) {
        this.department = depatment;
    }

    @ManyToOne(fetch=FetchType. EAGER)
    @JoinColumn(name = "id_post", referencedColumnName = "id_post", nullable = false)
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    @ManyToMany(fetch = FetchType.EAGER)
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
                ", firstName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex='" + sex + '\'' +
                ", status='" + status + '\'' +
                ", eMail='" + eMail + '\'' +
                ", linkSelfSite='" + linkSelfSite + '\'' +
                ", rating=" + rating +
                ", city=" + city +
                ", department=" + department.toString() +
                ", post=" + post.toString() +
                ", tasks=" + tasks.size() +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
