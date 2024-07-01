package finalexam.task4;

import java.io.Serializable;

public class Fish implements Serializable {
    private static final long serialVersionUID = 1L;

    private String species;
    private double weight;

    public Fish(String species, double weight) {
        this.species = species;
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return species + " (weight: " + weight + "kg)";
    }
}