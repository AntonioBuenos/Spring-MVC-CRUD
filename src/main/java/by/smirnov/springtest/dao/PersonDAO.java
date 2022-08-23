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
        people.add(new Person(++PEOPLE_COUNT, "Bruce"));
        people.add(new Person(++PEOPLE_COUNT, "Paul"));
        people.add(new Person(++PEOPLE_COUNT, "Blaze"));
        people.add(new Person(++PEOPLE_COUNT, "Adrian"));
        people.add(new Person(++PEOPLE_COUNT, "Steve"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return (Person) people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
