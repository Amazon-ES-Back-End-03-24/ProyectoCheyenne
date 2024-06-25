package entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class InventoryManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManager;

    private String name;

    @OneToMany(mappedBy = "inventoryManager", cascade = CascadeType.ALL)
    private List<Product> products;


    public InventoryManager() {
    }

    public InventoryManager(String name) {
        this.name = name;
    }


    public Long getIdManager() {
        return idManager;
    }

    public void setIdManager(Long idManager) {
        this.idManager = idManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



    @Override
    public String toString() {
        return "InventoryManager{" +
                "idManager=" + idManager +
                ", name='" + name + '\'' +
                '}';
    }
}


