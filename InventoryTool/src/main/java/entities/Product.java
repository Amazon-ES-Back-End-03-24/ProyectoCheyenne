package entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;


import java.util.List;

@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String name;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Inventory inventory;

    @ManyToMany(mappedBy = "wishlist")
    private List<Customer> customers;



    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }


    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }



    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                '}';
    }
}


