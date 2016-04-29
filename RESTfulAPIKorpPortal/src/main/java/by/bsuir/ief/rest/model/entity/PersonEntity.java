package by.bsuir.ief.rest.model.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Darya on 29.04.16.
 */
@Entity
@Table(name = "person", schema = "korporativ_portal")
public class PersonEntity {
    private int idPerson;
    private String firtsName;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    private String status;
    private String eMail;
    private String linkSelfSite;
    private int idCity;
    private double reiting;
    private int idDivision;
    private int idPost;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person", nullable = false)
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Basic
    @Column(name = "firts_name", nullable = false, length = 45)
    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
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
    @Column(name = "id_city", nullable = false)
    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    @Basic
    @Column(name = "reiting", nullable = false, precision = 0)
    public double getReiting() {
        return reiting;
    }

    public void setReiting(double reiting) {
        this.reiting = reiting;
    }

    @Basic
    @Column(name = "id_division", nullable = false)
    public int getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }

    @Basic
    @Column(name = "id_post", nullable = false)
    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        if (idPerson != that.idPerson) return false;
        if (idCity != that.idCity) return false;
        if (Double.compare(that.reiting, reiting) != 0) return false;
        if (idDivision != that.idDivision) return false;
        if (idPost != that.idPost) return false;
        if (firtsName != null ? !firtsName.equals(that.firtsName) : that.firtsName != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (eMail != null ? !eMail.equals(that.eMail) : that.eMail != null) return false;
        if (linkSelfSite != null ? !linkSelfSite.equals(that.linkSelfSite) : that.linkSelfSite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idPerson;
        result = 31 * result + (firtsName != null ? firtsName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (linkSelfSite != null ? linkSelfSite.hashCode() : 0);
        result = 31 * result + idCity;
        temp = Double.doubleToLongBits(reiting);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + idDivision;
        result = 31 * result + idPost;
        return result;
    }
}
