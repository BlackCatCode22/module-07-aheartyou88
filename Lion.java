package aYouZookeepersChallenge;


import java.time.LocalDate;


public class Lion extends Animal {
//    private String roarSound;
    private static int numOfLions = 0;
    public Lion(String name, String species, String gender, String color, String id, String birthPlace, int weight,
                LocalDate birthDate, LocalDate arrivalDate, String roarSound) {
        super(name, species, gender, color, id, birthPlace, weight, birthDate, arrivalDate);
//        this.roarSound = roarSound;
        numOfLions++;
        System.out.println("A new Lion has been added to the zoo.");
    }


    public Lion() {
        super();
//        this.roarSound = "Roar";
        numOfLions++;
        System.out.println("A new Lion has been added to the zoo.");
    }

//    public String getRoarSound() {
//        return roarSound;
//    }
//
//
//    public void setRoarSound(String roarSound) {
//        this.roarSound = roarSound;
//    }
//
//
//    public void roar() {
//        System.out.println(getName() + " says " + roarSound + "!");
//    }


    public static int getNumOfLions() {
        return numOfLions;
    }
}
