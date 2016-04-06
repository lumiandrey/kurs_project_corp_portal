package by.bsuir.ief.rest.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by andrey on 04.04.2016.
 */
public class LikePK implements Serializable {
    private Integer recordIdRecord;
    private Integer userIdUser;

    @Column(name = "record_id_record", nullable = false)
    @Id
    public Integer getRecordIdRecord() {
        return recordIdRecord;
    }

    public void setRecordIdRecord(Integer recordIdRecord) {
        this.recordIdRecord = recordIdRecord;
    }

    @Column(name = "user_id_user", nullable = false)
    @Id
    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikePK likePK = (LikePK) o;

        if (recordIdRecord != null ? !recordIdRecord.equals(likePK.recordIdRecord) : likePK.recordIdRecord != null)
            return false;
        if (userIdUser != null ? !userIdUser.equals(likePK.userIdUser) : likePK.userIdUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordIdRecord != null ? recordIdRecord.hashCode() : 0;
        result = 31 * result + (userIdUser != null ? userIdUser.hashCode() : 0);
        return result;
    }
}
