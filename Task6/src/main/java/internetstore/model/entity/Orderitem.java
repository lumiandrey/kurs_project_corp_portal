package internetstore.model.entity;

public class Orderitem {
    private int orderIdOrder;
    private int productIdProduct;
    private int count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderitem orderitem = (Orderitem) o;

        if (orderIdOrder != orderitem.orderIdOrder) return false;
        if (productIdProduct != orderitem.productIdProduct) return false;
        if (count != orderitem.count) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderIdOrder;
        result = 31 * result + productIdProduct;
        result = 31 * result + count;
        return result;
    }
}
