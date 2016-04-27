package internetstore.model.entity;

public class Card {
    private int idCard;
    private String numder;
    private int expirationYear;
    private int expirationMonth;
    private int secretNumber;
    private int userIdUser;

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getNumder() {
        return numder;
    }

    public void setNumder(String numder) {
        this.numder = numder;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
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

        Card card = (Card) o;

        if (idCard != card.idCard) return false;
        if (expirationYear != card.expirationYear) return false;
        if (expirationMonth != card.expirationMonth) return false;
        if (secretNumber != card.secretNumber) return false;
        if (userIdUser != card.userIdUser) return false;
        if (numder != null ? !numder.equals(card.numder) : card.numder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCard;
        result = 31 * result + (numder != null ? numder.hashCode() : 0);
        result = 31 * result + expirationYear;
        result = 31 * result + expirationMonth;
        result = 31 * result + secretNumber;
        result = 31 * result + userIdUser;
        return result;
    }
}
