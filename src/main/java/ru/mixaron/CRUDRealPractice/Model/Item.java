package ru.mixaron.CRUDRealPractice.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "item_name")
    private String itemNAme;

    public Item() {}

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Item(String itemNAme) {
        this.itemNAme = itemNAme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemNAme() {
        return itemNAme;
    }

    public void setItemNAme(String itemNAme) {
        this.itemNAme = itemNAme;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemNAme='" + itemNAme + '\'' +
                '}';
    }
}
