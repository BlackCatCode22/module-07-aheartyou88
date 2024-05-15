package aYouZookeepersChallenge;


import java.time.LocalDate;


public class Bear extends Animal {


//    private String growlSound;
    private static int numOfBears = 0;
    public Bear(String name, String species, String gender, String color, String id, String birthPlace, int weight,
                LocalDate birthDate, LocalDate arrivalDate, String growlSound) {
        super(name, species, gender, color, id, birthPlace, weight, birthDate, arrivalDate);
//        this.growlSound = growlSound;
        numOfBears++;
        System.out.println("A new Bear has been added to the zoo.");
    }


    public Bear() {
        super();
//        this.growlSound = "Grrr";
        numOfBears++;
        System.out.println("A new Bear has been added to the zoo.");
    }


//    public String getGrowlSound() {
//        return growlSound;
//    }
//
//
//    public void setGrowlSound(String growlSound) {
//        this.growlSound = growlSound;
//    }
//
//
//
//    public void growl() {
//        System.out.println(getName() + " says " + growlSound + "!");
//    }


    public static int getNumOfBears() {
        return numOfBears;
    }
}
