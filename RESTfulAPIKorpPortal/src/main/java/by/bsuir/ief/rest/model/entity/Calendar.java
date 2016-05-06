package by.bsuir.ief.rest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

//import org.joda.time.DateTime;

/**
 * Created by andrey on 04.04.2016.
 */
@Entity
@Table(name = "calendar")
public class Calendar implements Cloneable {
    private Integer idCalendar;
    private Integer week;
    private Integer quartal;
    private Date date;

    @Id
    @Column(name = "id_calendar", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdCalendar() {
        return idCalendar;
    }

    public void setIdCalendar(Integer idCalendar) {
        this.idCalendar = idCalendar;
    }

    @Basic
    @Column(name = "week", nullable = false)
    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    @Basic
    @Column(name = "quartal", nullable = false)
    public Integer getQuartal() {
        return quartal;
    }

    public void setQuartal(Integer quartal) {
        this.quartal = quartal;
    }

    @Basic
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calendar calendar = (Calendar) o;

        if (idCalendar != null ? !idCalendar.equals(calendar.idCalendar) : calendar.idCalendar != null) return false;
        if (week != null ? !week.equals(calendar.week) : calendar.week != null) return false;
        if (quartal != null ? !quartal.equals(calendar.quartal) : calendar.quartal != null) return false;
        if (date != null ? !date.equals(calendar.date) : calendar.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCalendar != null ? idCalendar.hashCode() : 0;
        result = 31 * result + (week != null ? week.hashCode() : 0);
        result = 31 * result + (quartal != null ? quartal.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "idCalendar=" + idCalendar +
                ", week=" + week +
                ", quartal=" + quartal +
                ", date=" + date +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
