package internetstore.model.entity;

import java.io.Serializable;

public class OrderitemPK implements Serializable {
    private int orderIdOrder;
    private int productIdProduct;

    public int getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(int orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    public int getProductIdProduct() {
        return productIdProduct;
    }

    public void setProductIdProduct(int productIdProduct) {
        this.productIdProduct = productIdProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderitemPK that = (OrderitemPK) o;

        if (orderIdOrder != that.orderIdOrder) return false;
        if (productIdProduct != that.productIdProduct) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderIdOrder;
        result = 31 * result + productIdProduct;
        return result;
    }
}
