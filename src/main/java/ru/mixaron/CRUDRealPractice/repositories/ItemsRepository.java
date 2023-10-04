package ru.mixaron.CRUDRealPractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mixaron.CRUDRealPractice.Model.Item;
import ru.mixaron.CRUDRealPractice.Model.Person;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {


    List<Item> findByItemNAme(String itemName);

    // person.getItems()
    List<Item> findByOwner(Person owner);
}
