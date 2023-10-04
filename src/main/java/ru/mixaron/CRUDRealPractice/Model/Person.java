package ru.mixaron.CRUDRealPractice.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Item> items;

    // Страна, Город, Индекс(6 цифр)

    @Column(name = "adress")
    @Pattern(regexp = "[A-Z]\\w+,[A-Z]\\w+,\\d{6}", message = "Your adress should be in this format: Country, City, index(6)")
    private String adress;

    @Column(name = "age")
    @Min(value = 0, message = "Age cant be min 0!")
    private int age;

    @NotEmpty(message = "email should not be empty")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;


    public Person(int id, String name, int age, String email, String adress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
