package entities;


import jakarta.persistence.*;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventory;

    private int availableQuantity;

    @OneToOne
    @JoinColumn(name = "id_product")
    private Product product;



    public Inventory() {
    }

    public Inventory(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }



    public Long getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(Long idInventory) {
        this.idInventory = idInventory;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    @Override
    public String toString() {
        return "Inventory{" +
                "idInventory=" + idInventory +
                ", availableQuantity=" + availableQuantity +
                '}';
    }

    public void setName(String s) {
    }

    public String getName() {


        return null;
    }
}
