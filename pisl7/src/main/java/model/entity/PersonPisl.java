package model.entity;

import model.entity.enumeration.Cities;
import model.entity.enumeration.Disability;
import model.entity.enumeration.MaritalStatus;
import model.entity.enumeration.Nationality;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PersonPisl {

    public PersonPisl() {
        this.idpersonPisl = 0;
        this.firstName = "unname";
        this.name = "unname";
        this.lastName = "unname";
        this.sex = "Мужской";
        this.pasportNumber = "";
        this.hphone = "+375";
        this.birthday = null;
        this.serialPasport = "";
        this.organizationGivePassport = "";
        this.dateGivePasport = null;
        this.identifyNumber = "";
        this.placeOfBirth = "";
        this.adressLiving = Cities.Warsawa;
        this.mphone = "";
        this.eMail = "";
        this.workingPlace = "";
        this.post = "";
        this.cityResidence = Cities.Warsawa;
        this.addressResidence = "";
        this.maritalStatus = MaritalStatus.Not;
        this.nationality = Nationality.Belarus;
        this.disability = Disability.Not;
        this.pensioner = false;
        this.monthlyIncome = 0.0;
        this.reservist = true;
    }

    private int idpersonPisl;

    public int getIdpersonPisl() {
        return idpersonPisl;
    }

    public void setIdpersonPisl(int idpersonPisl) {
        this.idpersonPisl = idpersonPisl;
    }

    @Size(min = 3, message = "Отчество должно быть больше 3 знаков")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Size(min = 3, message = "Имя должно быть больше 3 знаков")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 3, message = "Фамилия должна быть больше 3 знаков")
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Pattern(regexp = "\\d{7}", message = "Пример: 2438593")
    private String pasportNumber;

    public String getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(String pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    @Pattern(regexp = "\\d{7}", message = "Пример: 2438593")
    private String hphone;

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday( Date birthday) {
        this.birthday = birthday;
    }

    @Pattern(regexp = "[A-ZА-Я]{2}", message = "Пример: MP")
    private String serialPasport;

    public String getSerialPasport() {
        return serialPasport;
    }

    public void setSerialPasport(String serialPasport) {
        this.serialPasport = serialPasport;
    }

    @Size(min = 10, message = "Название организации должно включать в себя не менее 10 символов")
    private String organizationGivePassport;

    public String getOrganizationGivePassport() {
        return organizationGivePassport;
    }

    public void setOrganizationGivePassport(String organizationGivePassport) {
        this.organizationGivePassport = organizationGivePassport;
    }

    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date dateGivePasport;

    public Date getDateGivePasport() {
        return dateGivePasport;
    }

    public void setDateGivePasport( Date dateGivePasport) {
        this.dateGivePasport = dateGivePasport;
    }

    @Pattern(regexp = "\\w{11}", message = "Пример: uf281kfi123")
    private String identifyNumber;

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    @Size(min = 10, message = "Место рождения должно включать в себя не менее 10 символов")
    private String placeOfBirth;

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    private Cities adressLiving;

    public Cities getAdressLiving() {
        return adressLiving;
    }

    public void setAdressLiving(Cities adressLiving) {
        this.adressLiving = adressLiving;
    }

    @Pattern(regexp = "\\d{7}", message = "Пример: 2438593")
    private String mphone;

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    @Email(message = "Пример: vjdso@mail.ru")
    private String eMail;

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Size(min = 10, message = "Название организации должно включать в себя не менее 10 символов")
    private String workingPlace;

    public String getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
    }

    @Size(min = 5, message = "Должность должна включать в себя не менее 5 символов")
    private String post;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    private Cities cityResidence;

    public Cities getCityResidence() {
        return cityResidence;
    }

    public void setCityResidence(Cities cityResidence) {
        this.cityResidence = cityResidence;
    }

    @Size(min = 10, message = "Место проживания должно включать в себя не менее 10 символов")
    private String addressResidence;

    public String getAddressResidence() {
        return addressResidence;
    }

    public void setAddressResidence(String addressResidence) {
        this.addressResidence = addressResidence;
    }

    private MaritalStatus maritalStatus;

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    private Nationality nationality;

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    private Disability disability;

    public Disability getDisability() {
        return disability;
    }

    public void setDisability(Disability disability) {
        this.disability = disability;
    }

    private boolean pensioner;

    public boolean isPensioner() {
        return pensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    @Pattern(regexp = "\\d{4,7}", message = "Пример: 5890")
    private Double monthlyIncome;

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    private boolean reservist;

    public boolean isReservist() {
        return reservist;
    }

    public void setReservist(boolean reservist) {
        this.reservist = reservist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonPisl that = (PersonPisl) o;

        if (idpersonPisl != that.idpersonPisl) return false;
        if (pensioner != that.pensioner) return false;
        if (reservist != that.reservist) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (pasportNumber != null ? !pasportNumber.equals(that.pasportNumber) : that.pasportNumber != null)
            return false;
        if (hphone != null ? !hphone.equals(that.hphone) : that.hphone != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (serialPasport != null ? !serialPasport.equals(that.serialPasport) : that.serialPasport != null)
            return false;
        if (organizationGivePassport != null ? !organizationGivePassport.equals(that.organizationGivePassport) : that.organizationGivePassport != null)
            return false;
        if (dateGivePasport != null ? !dateGivePasport.equals(that.dateGivePasport) : that.dateGivePasport != null)
            return false;
        if (identifyNumber != null ? !identifyNumber.equals(that.identifyNumber) : that.identifyNumber != null)
            return false;
        if (placeOfBirth != null ? !placeOfBirth.equals(that.placeOfBirth) : that.placeOfBirth != null) return false;
        if (adressLiving != null ? !adressLiving.equals(that.adressLiving) : that.adressLiving != null) return false;
        if (mphone != null ? !mphone.equals(that.mphone) : that.mphone != null) return false;
        if (eMail != null ? !eMail.equals(that.eMail) : that.eMail != null) return false;
        if (workingPlace != null ? !workingPlace.equals(that.workingPlace) : that.workingPlace != null) return false;
        if (post != null ? !post.equals(that.post) : that.post != null) return false;
        if (cityResidence != null ? !cityResidence.equals(that.cityResidence) : that.cityResidence != null)
            return false;
        if (addressResidence != null ? !addressResidence.equals(that.addressResidence) : that.addressResidence != null)
            return false;
        if (maritalStatus != null ? !maritalStatus.equals(that.maritalStatus) : that.maritalStatus != null)
            return false;
        if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;
        if (disability != null ? !disability.equals(that.disability) : that.disability != null) return false;
        if (monthlyIncome != null ? !monthlyIncome.equals(that.monthlyIncome) : that.monthlyIncome != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpersonPisl;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (pasportNumber != null ? pasportNumber.hashCode() : 0);
        result = 31 * result + (hphone != null ? hphone.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (serialPasport != null ? serialPasport.hashCode() : 0);
        result = 31 * result + (organizationGivePassport != null ? organizationGivePassport.hashCode() : 0);
        result = 31 * result + (dateGivePasport != null ? dateGivePasport.hashCode() : 0);
        result = 31 * result + (identifyNumber != null ? identifyNumber.hashCode() : 0);
        result = 31 * result + (placeOfBirth != null ? placeOfBirth.hashCode() : 0);
        result = 31 * result + (adressLiving != null ? adressLiving.hashCode() : 0);
        result = 31 * result + (mphone != null ? mphone.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (workingPlace != null ? workingPlace.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (cityResidence != null ? cityResidence.hashCode() : 0);
        result = 31 * result + (addressResidence != null ? addressResidence.hashCode() : 0);
        result = 31 * result + (maritalStatus != null ? maritalStatus.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (disability != null ? disability.hashCode() : 0);
        result = 31 * result + (pensioner ? 1 : 0);
        result = 31 * result + (monthlyIncome != null ? monthlyIncome.hashCode() : 0);
        result = 31 * result + (reservist ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonPisl{" +
                "idpersonPisl=" + idpersonPisl +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", pasportNumber='" + pasportNumber + '\'' +
                ", hphone='" + hphone + '\'' +
                ", birthday=" + birthday.toLocaleString() +
                ", serialPasport='" + serialPasport + '\'' +
                ", organizationGivePassport='" + organizationGivePassport + '\'' +
                ", dateGivePasport=" + dateGivePasport.toLocaleString() +
                ", identifyNumber='" + identifyNumber + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", adressLiving=" + adressLiving +
                ", mphone='" + mphone + '\'' +
                ", eMail='" + eMail + '\'' +
                ", workingPlace='" + workingPlace + '\'' +
                ", post='" + post + '\'' +
                ", cityResidence=" + cityResidence +
                ", addressResidence='" + addressResidence + '\'' +
                ", maritalStatus=" + maritalStatus +
                ", nationality=" + nationality +
                ", disability=" + disability +
                ", pensioner=" + pensioner +
                ", monthlyIncome=" + monthlyIncome +
                ", reservist=" + reservist +
                '}';
    }
}
