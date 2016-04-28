package by.bsuir.ief.corporativ_portal.model.entity;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;


public class Person {
    private Integer idPerson;

    @Size(min = 3, message = "Длина имени должна быть не менее 3х символов")
    private String firtsName;

    @Size(min = 3, message = "Длина имени должна быть не менее 3х символов")
    private String name;

    @Size(min = 3, message = "Длина имени должна быть не менее 3х символов")
    private String lastName;

    //@Pattern(regexp = "\\d{2}.\\d{2}.\\d{4}")
    private DateTime dateOfBirth;

    private String sex;
    private String status;
    private String eMail;
    private String linkSelfSite;
    private Double reiting;
    private City city;
    private Department depatment;
    private Post post;
    private Set<Task> taskes;

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getLinkSelfSite() {
        return linkSelfSite;
    }

    public void setLinkSelfSite(String linkSelfSite) {
        this.linkSelfSite = linkSelfSite;
    }

    public Double getReiting() {
        return reiting;
    }

    public void setReiting(Double reiting) {
        this.reiting = reiting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (idPerson != null ? !idPerson.equals(person.idPerson) : person.idPerson != null) return false;
        if (firtsName != null ? !firtsName.equals(person.firtsName) : person.firtsName != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(person.dateOfBirth) : person.dateOfBirth != null) return false;
        if (sex != null ? !sex.equals(person.sex) : person.sex != null) return false;
        if (status != null ? !status.equals(person.status) : person.status != null) return false;
        if (eMail != null ? !eMail.equals(person.eMail) : person.eMail != null) return false;
        if (linkSelfSite != null ? !linkSelfSite.equals(person.linkSelfSite) : person.linkSelfSite != null)
            return false;
        if (reiting != null ? !reiting.equals(person.reiting) : person.reiting != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPerson != null ? idPerson.hashCode() : 0;
        result = 31 * result + (firtsName != null ? firtsName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (linkSelfSite != null ? linkSelfSite.hashCode() : 0);
        result = 31 * result + (reiting != null ? reiting.hashCode() : 0);
        return result;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Department getDepatment() {
        return depatment;
    }

    public void setDepatment(Department depatment) {
        this.depatment = depatment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Set<Task> getTaskes() {
        return taskes;
    }

    public void setTaskes(Set<Task> taskes) {
        this.taskes = taskes;
    }
}
