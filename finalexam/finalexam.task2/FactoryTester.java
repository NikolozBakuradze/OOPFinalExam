package finalexam.task2;

public class FactoryTester {
    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();

        Person john = new Person("John", "Doe", "123456", 35, "Manager");
        Person jane = new Person("Jane", "Smith", "789012", 28, "Engineer");
        Person bob = new Person("Bob", "Johnson", "345678", 45, "Operator");

        factory.addPerson(john);
        factory.addPerson(jane);
        factory.addPerson(bob);

        factory.displayStaff();

        factory.producePaper(1000);
        factory.producePaper(500);

        System.out.println("Total paper produced: " + factory.getTotalPaperProduced());

        factory.deletePerson(jane);
        factory.displayStaff();

        Person oldTimer = new Person("Gerald", "Wilson", "111222", 68, "Senior Advisor");
        factory.addPerson(oldTimer);
        System.out.println("Is Gerald of retirement age? " + oldTimer.isRetirementAge());
    }
}
