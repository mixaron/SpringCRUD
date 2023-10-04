package ru.mixaron.CRUDRealPractice.Dao;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.mixaron.CRUDRealPractice.Model.Person;

import java.util.List;

@Component
public class DaoRofls {

    private  final SessionFactory sessionFactory;
    private List<Person> PersonList;


    public DaoRofls(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Person>index() {
        Session session = sessionFactory.getCurrentSession();

        List<Person> people = session.createQuery("FROM Person", Person.class).getResultList();
        return people;
    }


    @Transactional
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Transactional
    public void update(int id, Person person) {
        Session session = sessionFactory.getCurrentSession();
        Person person1 = session.get(Person.class, id);
        person1.setName(person.getName());
        person1.setAge(person.getAge());
        person1.setEmail(person.getEmail());
        person1.setAdress(person.getAdress());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        session.remove(person);
    }
}
