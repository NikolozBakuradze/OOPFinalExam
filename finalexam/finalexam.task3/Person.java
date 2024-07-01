package finalexam.task3;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    String name, surname, personalNumber;
    int age;
    String position;

    public Person(String name, String surname, String personalNumber, int age, String position) {
        this.name = name;
        this.surname = surname;
        this.personalNumber = personalNumber;
        this.age = age;
        this.position = position;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + position + ")";
    }

    public boolean isRetirementAge() {
        return age >= 65;
    }
}
