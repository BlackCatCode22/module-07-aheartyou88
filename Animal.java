package aYouZookeepersChallenge;

import java.time.LocalDate;
import java.time.Period;

public class Animal {
    private String name;
    private String species;
    private String gender;
    private String color;
    private String id;
    private String birthPlace;
    private int weight;
    private LocalDate birthDate;
    private LocalDate arrivalDate;
    public static int numOfAnimals = 0;

    public Animal(String name, String species, String gender, String color, String id, String birthPlace, int weight, LocalDate birthDate, LocalDate arrivalDate) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.color = color;
        this.id = id;
        this.birthPlace = birthPlace;
        this.weight = weight;
        this.birthDate = birthDate;
        this.arrivalDate = arrivalDate;
        numOfAnimals++;
        System.out.println("\nA new Animal object was created:\n" + this);
    }

    public Animal() {
        numOfAnimals++;
        System.out.println("\nA new Animal object was created.\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public static int getNumOfAnimals() {
        return numOfAnimals;
    }

    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Species: " + species + "\n" +
                "Gender: " + gender + "\n" +
                "Color: " + color + "\n" +
                "ID: " + id + "\n" +
                "Birthplace: " + birthPlace + "\n" +
                "Weight: " + weight + " pounds\n" +
                "Birthdate: " + birthDate + "\n" +
                "Age: " + getAge() + " years\n" +
                "Arrival Date: " + arrivalDate + "\n";
    }
}
