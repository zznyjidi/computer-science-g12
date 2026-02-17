package combination;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import combination.Person.Job;

public class BestScore {

    public static Person[] selectPersons(Person[] persons, int budget) {
        List<Person> heads = new ArrayList<>();
        List<Person> employees = new ArrayList<>();

        for (Person person : persons) {
            if (person.pay < budget)
                switch (person.job) {
                    case Head -> heads.add(person);
                    case Employee -> employees.add(person);
                }
        }

        employees.sort(Comparator.comparingDouble(Person::getEffectiveness));

        List<Person> selections = new ArrayList<>();

        return (Person[]) selections.toArray();
    }

    private static List<List<Person>> findCombination(List<Person> persons, int budget) {
        List<List<Person>> combinations = new ArrayList<>();

        if (persons.size() == 1) {
            if (persons.get(0).pay < budget)
                combinations.add(persons);
            return combinations;
        }

        return combinations;
    }

    public static void main(String[] args) {
        Person[] persons = {
                new Person(1500, Job.Head, 70),
                new Person(2000, Job.Head, 75),
                new Person(4000, Job.Head, 100),
                new Person(500, Job.Employee, 50),
                new Person(400, Job.Employee, 40),
                new Person(600, Job.Employee, 60)
        };
    }
}
