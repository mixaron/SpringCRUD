package ru.mixaron.CRUDRealPractice.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mixaron.CRUDRealPractice.Model.Person;
import ru.mixaron.CRUDRealPractice.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional()
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public void save(Person person) {
        peopleRepository.save(person);
    }

    public void update(int id, Person updatePerson) {
        updatePerson.setId(id);
        peopleRepository.save(updatePerson);
    }

    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    public void test() {
        System.out.println("Testing here with debug");
    }
}
