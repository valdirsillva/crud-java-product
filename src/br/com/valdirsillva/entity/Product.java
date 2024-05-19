package br.com.valdirsillva.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private LocalDateTime createdAt;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public Product(String name, double price, int quantity, String description, LocalDateTime createdAt) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return String.format(
                "%-23s R$ %-12.2f %-10d %-40s %-15s |%n",
                name, price, quantity, description, createdAt);
    }

}
