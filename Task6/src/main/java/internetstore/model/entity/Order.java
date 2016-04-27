package internetstore.model.entity;

import java.sql.Date;

public class Order {
    private int idOrder;
    private Date date;
    private int userIdUser;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

        Order order = (Order) o;

        if (idOrder != order.idOrder) return false;
        if (userIdUser != order.userIdUser) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrder;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + userIdUser;
        return result;
    }
}
