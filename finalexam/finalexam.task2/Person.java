package finalexam.task2;

public class Person {
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
