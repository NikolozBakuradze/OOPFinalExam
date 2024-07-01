package finalexam.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Fishery implements LegalEntity {
    private String address;
    private String vatNumber;
    private List<Fish> fishes = new ArrayList<>();

    public Fishery(String address, String vatNumber) {
        this.address = address;
        this.vatNumber = vatNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getVatNumber() {
        return vatNumber;
    }

    public void addFish(Fish f) {
        if (!fishes.contains(f)) {
            fishes.add(f);
            System.out.println("Added " + f.getSpecies() + " to the fishery.");
        } else {
            System.out.println("This fish is already in the fishery.");
        }
    }

    public boolean removeFish(Fish f) {
        if (fishes.remove(f)) {
            System.out.println("Removed " + f.getSpecies() + " from the fishery.");
            return true;
        }
        System.out.println("Fish not found in the fishery.");
        return false;
    }

    public void displayFishes() {
        System.out.println("Fishes in the fishery:");
        for (Fish f : fishes) {
            System.out.println("- " + f);
        }
    }

    public void saveFishesToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(fishes);
            System.out.println("Fish list saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving fish list: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFishesFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            fishes = (List<Fish>) ois.readObject();
            System.out.println("Fish list loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading fish list: " + e.getMessage());
        }
    }
}