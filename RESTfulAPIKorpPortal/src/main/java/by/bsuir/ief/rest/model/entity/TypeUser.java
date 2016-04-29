package by.bsuir.ief.rest.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "type_user", schema = "korporativ_portal")
public class TypeUser {
    private Integer idTypeUser;
    private String nameType;
    private Integer accessLevel;

    public TypeUser() {
        this.idTypeUser = 0;
        this.nameType = "";
        this.accessLevel = 0;
    }

    @Id
    @Column(name = "id_type_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(Integer idTypeUser) {
        this.idTypeUser = idTypeUser;
    }

    @Basic
    @Column(name = "name_type", nullable = false, length = 45)
    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Basic
    @Column(name = "access_level", nullable = false)
    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeUser typeUser = (TypeUser) o;

        if (idTypeUser != null ? !idTypeUser.equals(typeUser.idTypeUser) : typeUser.idTypeUser != null) return false;
        if (nameType != null ? !nameType.equals(typeUser.nameType) : typeUser.nameType != null) return false;
        if (accessLevel != null ? !accessLevel.equals(typeUser.accessLevel) : typeUser.accessLevel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTypeUser != null ? idTypeUser.hashCode() : 0;
        result = 31 * result + (nameType != null ? nameType.hashCode() : 0);
        result = 31 * result + (accessLevel != null ? accessLevel.hashCode() : 0);
        return result;
    }

}
