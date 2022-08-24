package by.smirnov.springtest.dao;

import by.smirnov.springtest.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Bruce", 64, "bruce@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Paul", 64, "paul@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Blaze", 59, "blaze@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Adrian", 65, "adrian@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Steve", 66, "steve@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}