package finalexam.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaperFactory {
    private List<Person> staff = new ArrayList<>();
    private int paperProduced = 0;

    public void addPerson(Person p) {
        if (!staff.contains(p)) {
            staff.add(p);
            System.out.println("Welcome aboard, " + p.name + "!");
        } else {
            System.out.println(p.name + " is already part of our team.");
        }
    }

    public boolean deletePerson(Person p) {
        if (staff.remove(p)) {
            System.out.println("Goodbye, " + p.name + ". Thanks for your service!");
            return true;
        }
        System.out.println(p.name + " is not found in our records.");
        return false;
    }

    public void producePaper(int amount) {
        paperProduced += amount;
        System.out.println("The factory produced " + amount + " sheets of paper.");
    }

    public void displayStaff() {
        System.out.println("Current staff:");
        for (Person p : staff) {
            System.out.println("- " + p);
        }
    }

    public int getTotalPaperProduced() {
        return paperProduced;
    }

    public void saveStaffToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(staff);
            System.out.println("Staff list saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving staff list: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadStaffFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            staff = (List<Person>) ois.readObject();
            System.out.println("Staff list loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading staff list: " + e.getMessage());
        }
    }
}
