package by.bsuir.ief.corporativ_portal.model.entity;

import java.util.List;

public class Country {
    private Integer idCountryt;
    private String countryName;
    private String shortCountryName;
    private String keyPhone;
    private List<City> cities;

    public Integer getIdCountryt() {
        return idCountryt;
    }

    public void setIdCountryt(Integer idCountryt) {
        this.idCountryt = idCountryt;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getShortCountryName() {
        return shortCountryName;
    }

    public void setShortCountryName(String shortCountryName) {
        this.shortCountryName = shortCountryName;
    }

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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
