package by.bsuir.ief.rest.model.entity;

import javax.persistence.*;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "city")
public class City implements Cloneable {
    private Integer idCity;
    private String cityName;
    private Country country;

    public City() {
        this.idCity = 0;
        this.cityName = "";
        this.country = new Country();
    }

    @Id
    @Column(name = "id_city", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    @Basic
    @Column(name = "city_name", nullable = true, length = 45)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (idCity != null ? !idCity.equals(city.idCity) : city.idCity != null) return false;
        if (cityName != null ? !cityName.equals(city.cityName) : city.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCity != null ? idCity.hashCode() : 0;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_country", referencedColumnName = "id_country", nullable = false)
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", cityName='" + cityName + '\'' +
                ", country=" + country.toString() +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
