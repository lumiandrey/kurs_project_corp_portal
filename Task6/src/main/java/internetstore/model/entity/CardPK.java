package internetstore.model.entity;

import java.io.Serializable;

public class CardPK implements Serializable {
    private int idCard;
    private int userIdUser;

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardPK cardPK = (CardPK) o;

        if (idCard != cardPK.idCard) return false;
        if (userIdUser != cardPK.userIdUser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCard;
        result = 31 * result + userIdUser;
        return result;
    }
}
