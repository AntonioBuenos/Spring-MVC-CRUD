package by.smirnov.springtest.util;

import by.smirnov.springtest.dao.PersonDAO;
import by.smirnov.springtest.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    //можем использовать этот валидатор только в отношении того класса, который указан в supports
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (personDAO.show(person.getEmail()).isPresent()) //Optional & isPresent лучше проверки на !=null
            errors.rejectValue("email", "", "This email is already taken");
    }
}
