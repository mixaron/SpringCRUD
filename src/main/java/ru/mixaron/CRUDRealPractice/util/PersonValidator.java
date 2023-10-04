//package ru.mixaron.CRUDRealPractice.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//import ru.mixaron.CRUDRealPractice.Dao.DaoRofls;
//import ru.mixaron.CRUDRealPractice.Person.Person;
//
//@Component
//public class PersonValidator implements Validator {
//
//    private final DaoRofls daoRofls;
//
//    @Autowired
//    public PersonValidator(DaoRofls daoRofls) {
//        this.daoRofls = daoRofls;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Person.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Person person = (Person) target;
//        if (daoRofls.show(person.getEmail()).isPresent()) {
//            errors.rejectValue("email", "", "This email is already taken");
//        }
//    }
//}
