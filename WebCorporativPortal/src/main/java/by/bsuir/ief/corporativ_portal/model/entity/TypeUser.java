package by.bsuir.ief.corporativ_portal.model.entity;

import java.util.Set;

public class TypeUser {
    private Integer idTypeUser;
    private String nameType;
    private Integer accessLevel;
    private Set<User> users;

    public Integer getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(Integer idTypeUser) {
        this.idTypeUser = idTypeUser;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
