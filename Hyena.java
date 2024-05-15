package aYouZookeepersChallenge;


import java.time.LocalDate;


public class Hyena extends Animal {


//    private String laughSound;
    private static int numOfHyenas = 0;
    public Hyena(String name, String species, String gender, String color, String id, String birthPlace, int weight,
                 LocalDate birthDate, LocalDate arrivalDate, String laughSound) {
        super(name, species, gender, color, id, birthPlace, weight, birthDate, arrivalDate);
//        this.laughSound = laughSound;
        numOfHyenas++;
        System.out.println("A new Hyena has been added to the zoo.");
    }


    // Default constructor
    public Hyena() {
        super();
//        this.laughSound = "Haha";
        numOfHyenas++;
        System.out.println("A new Hyena has been added to the zoo.");
    }


    // Getter for the laughSound
//    public String getLaughSound() {
//        return laughSound;
//    }
//
//
//    // Setter for the laughSound
//    public void setLaughSound(String laughSound) {
//        this.laughSound = laughSound;
//    }
//
//
//    // Method to simulate the Hyena's laugh
//    public void laugh() {
//        System.out.println(getName() + " says " + laughSound + "!");
//    }


    // Public static getter for numOfHyenas
    public static int getNumOfHyenas() {
        return numOfHyenas;
    }
}
