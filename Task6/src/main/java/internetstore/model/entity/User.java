package internetstore.model.entity;

public class User {
    private int idUser;
    private String login;
    private String password;
    private String email;
    private String name;
    private String surname;
    private String patronymic;
    private String mobile;
    private Integer discount;
    private byte statusActivity;
    private String photo;
    private int roleIdRole;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public byte getStatusActivity() {
        return statusActivity;
    }

    public void setStatusActivity(byte statusActivity) {
        this.statusActivity = statusActivity;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getRoleIdRole() {
        return roleIdRole;
    }

    public void setRoleIdRole(int roleIdRole) {
        this.roleIdRole = roleIdRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != user.idUser) return false;
        if (statusActivity != user.statusActivity) return false;
        if (roleIdRole != user.roleIdRole) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(user.patronymic) : user.patronymic != null) return false;
        if (mobile != null ? !mobile.equals(user.mobile) : user.mobile != null) return false;
        if (discount != null ? !discount.equals(user.discount) : user.discount != null) return false;
        if (photo != null ? !photo.equals(user.photo) : user.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (int) statusActivity;
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + roleIdRole;
        return result;
    }
}
