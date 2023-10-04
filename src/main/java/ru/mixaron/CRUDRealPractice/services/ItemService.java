package ru.mixaron.CRUDRealPractice.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mixaron.CRUDRealPractice.Model.Item;
import ru.mixaron.CRUDRealPractice.Model.Person;
import ru.mixaron.CRUDRealPractice.repositories.ItemsRepository;

import java.util.List;

@Service
public class ItemService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @Transactional
    public List<Item> findByItemName(String itemName) {
        return itemsRepository.findByItemNAme(itemName);
    }

    @Transactional
    public List<Item> findByOwner(Person person) {
        return itemsRepository.findByOwner(person);
    }

}
