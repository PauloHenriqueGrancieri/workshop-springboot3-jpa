package com.paulohenrique.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paulohenrique.course.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;

    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }
    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }
    public void setProduct(Product product){
        id.setProduct(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
