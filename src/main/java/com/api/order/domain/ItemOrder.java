package com.api.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Getter
@Setter
@EqualsAndHashCode
@Entity
public class ItemOrder {

    @JsonIgnore
    @EmbeddedId
    private ItemOrderPK itemOrderpkId;
    private Double discount;
    private Integer amount;
    private Double price;

    public ItemOrder() {
    }

    public ItemOrder(Order order, Product product, Double discount, Integer amount, Double price) {
        itemOrderpkId.setOrder(order);
        itemOrderpkId.setProduct(product);
        this.discount = discount;
        this.amount = amount;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return itemOrderpkId.getOrder();
    }

    public Product getProduct() {
        return itemOrderpkId.getProduct();
    }
}
