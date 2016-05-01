package by.bsuir.ief.rest.model.entity;

import javax.persistence.*;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "country")
public class Country {
    private Integer idCountryt;
    private String countryName;
    private String shortCountryName;
    private String keyPhone;
    //private List<City> cities;

    @Id
    @Column(name = "id_country", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdCountryt() {
        return idCountryt;
    }

    public void setIdCountryt(Integer idCountryt) {
        this.idCountryt = idCountryt;
    }

    @Basic
    @Column(name = "country_name", nullable = false, length = 60)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Basic
    @Column(name = "short_country_name", nullable = true, length = 45)
    public String getShortCountryName() {
        return shortCountryName;
    }

    public void setShortCountryName(String shortCountryName) {
        this.shortCountryName = shortCountryName;
    }

    @Basic
    @Column(name = "key_phone", nullable = true, length = 45)
    public String getKeyPhone() {
        return keyPhone;
    }

    public void setKeyPhone(String keyPhone) {
        this.keyPhone = keyPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (countryName != null ? !countryName.equals(country.countryName) : country.countryName != null) return false;
        if (shortCountryName != null ? !shortCountryName.equals(country.shortCountryName) : country.shortCountryName != null)
            return false;
        if (keyPhone != null ? !keyPhone.equals(country.keyPhone) : country.keyPhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryName != null ? countryName.hashCode() : 0;
        result = 31 * result + (shortCountryName != null ? shortCountryName.hashCode() : 0);
        result = 31 * result + (keyPhone != null ? keyPhone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "idCountryt=" + idCountryt +
                ", countryName='" + countryName + '\'' +
                ", shortCountryName='" + shortCountryName + '\'' +
                ", keyPhone='" + keyPhone + '\'' +
                '}';
    }
}
