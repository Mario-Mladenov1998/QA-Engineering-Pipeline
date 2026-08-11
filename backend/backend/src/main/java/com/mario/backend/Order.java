package com.mario.backend;
import jakarta.validation.constraints.Min;

public class Order {
    
    private Long id;
    private String product;

    @Min(1)
    private int quantity;

    private String status;

    public Order() {
    }

    public Order(Long id, String product, int quantity, String status){
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
    return product;
}

public void setProduct(String product) {
    this.product = product;
}

public int getQuantity() {
    return quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

}

