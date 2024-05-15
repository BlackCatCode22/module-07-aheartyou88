package aYouZookeepersChallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class ZookeepersChallenge {
    private static int idCounter = 0;
    private static List<String> hyenaNames = new ArrayList<>();
    private static List<String> lionNames = new ArrayList<>();
    private static List<String> bearNames = new ArrayList<>();
    private static List<String> tigerNames = new ArrayList<>();
    private static Map<String, Queue<String>> speciesNamesMap = new HashMap<>();

    public static void main(String[] args) {
        // Load names
        loadAnimalNames();

        // Initialize speciesNamesMap
        speciesNamesMap.put("hyena", new LinkedList<>(hyenaNames));
        speciesNamesMap.put("lion", new LinkedList<>(lionNames));
        speciesNamesMap.put("bear", new LinkedList<>(bearNames));
        speciesNamesMap.put("tiger", new LinkedList<>(tigerNames));

        List<Animal> animals = new ArrayList<>();

        // Read animals from the file and create Animal objects
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Amanda Panda\\Desktop\\FCC\\CIT 63\\aYouZookeepersChallenge\\src\\aYouZookeepersChallenge\\arrivingAnimals.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Animal animal = parseAnimal(line);
                if (animal != null) {
                    animals.add(animal);
                    System.out.println("A new Animal object was created:");
                    System.out.println(animal);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generate the report
        generateReport(animals);
    }

    private static void loadAnimalNames() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Amanda Panda\\Desktop\\FCC\\CIT 63\\aYouZookeepersChallenge\\src\\aYouZookeepersChallenge\\animalNames.txt"))) {
            String line;
            String currentSpecies = null;

            while ((line = br.readLine()) != null) {
                if (line.endsWith("Names:")) {
                    currentSpecies = line.replace(" Names:", "").toLowerCase();
                } else if (!line.isEmpty() && currentSpecies != null) {
                    String[] names = line.split(", ");
                    switch (currentSpecies) {
                        case "hyena":
                            hyenaNames.addAll(Arrays.asList(names));
                            break;
                        case "lion":
                            lionNames.addAll(Arrays.asList(names));
                            break;
                        case "bear":
                            bearNames.addAll(Arrays.asList(names));
                            break;
                        case "tiger":
                            tigerNames.addAll(Arrays.asList(names));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Animal parseAnimal(String line) {
        try {
            String[] details = line.split(", ");
            String ageGenderSpecies = details[0].trim();
            String birthSeason = details[1].replace("born in ", "").trim();
            String color = details[2].replace("color", "").trim();
            int weight = Integer.parseInt(details[3].replace("pounds", "").trim());
            String birthPlace = details[4].replace("from ", "").trim() + ", " + details[5].trim();

            String[] ageGenderSpeciesParts = ageGenderSpecies.split(" ");
            int age = Integer.parseInt(ageGenderSpeciesParts[0]);
            String gender = ageGenderSpeciesParts[3];
            String species = ageGenderSpeciesParts[4];

            LocalDate birthDate = calculateBirthDate(age, birthSeason);
            LocalDate arrivalDate = LocalDate.now();

            String id = generateUniqueId();
            String name = assignName(species);

            return new Animal(name, species, gender, color, id, birthPlace, weight, birthDate, arrivalDate);
        } catch (Exception e) {
            System.err.println("Error parsing line: " + line);
            e.printStackTrace();
            return null;
        }
    }

    private static LocalDate calculateBirthDate(int age, String birthSeason) {
        LocalDate currentDate = LocalDate.now();
        int birthYear = currentDate.getYear() - age;
        LocalDate birthDate = LocalDate.of(birthYear, 1, 1);

        switch (birthSeason.toLowerCase()) {
            case "spring":
                birthDate = LocalDate.of(birthYear, 3, 1);
                break;
            case "summer":
                birthDate = LocalDate.of(birthYear, 6, 1);
                break;
            case "fall":
                birthDate = LocalDate.of(birthYear, 9, 1);
                break;
            case "winter":
                birthDate = LocalDate.of(birthYear, 12, 1);
                break;
            default:
                birthDate = LocalDate.of(birthYear, 1, 1);
                break;
        }

        return birthDate;
    }

    private static String generateUniqueId() {
        return "ID" + (++idCounter);
    }

    private static String assignName(String species) {
        Queue<String> namesQueue = speciesNamesMap.get(species);
        if (namesQueue != null && !namesQueue.isEmpty()) {
            return namesQueue.poll();
        }
        return "Unnamed";
    }

    private static void generateReport(List<Animal> animals) {
        try (FileWriter writer = new FileWriter("zooPopulation.txt")) {
            writer.write("Zoo Population and Habitat Report\n\n");

            Map<String, List<Animal>> habitatMap = new HashMap<>();
            habitatMap.put("Savannah Habitat", new ArrayList<>());
            habitatMap.put("Forest Habitat", new ArrayList<>());
            habitatMap.put("Jungle Habitat", new ArrayList<>());

            for (Animal animal : animals) {
                switch (animal.getSpecies().toLowerCase()) {
                    case "lion":
                    case "hyena":
                        habitatMap.get("Savannah Habitat").add(animal);
                        break;
                    case "bear":
                        habitatMap.get("Forest Habitat").add(animal);
                        break;
                    case "tiger":
                        habitatMap.get("Jungle Habitat").add(animal);
                        break;
                }
            }

            for (Map.Entry<String, List<Animal>> entry : habitatMap.entrySet()) {
                writer.write(entry.getKey() + "\n");
                writer.write("===================\n");
                for (Animal animal : entry.getValue()) {
                    writer.write("Name: " + animal.getName() + "\n");
                    writer.write("Species: " + animal.getSpecies() + "\n");
                    writer.write("Gender: " + animal.getGender() + "\n");
                    writer.write("Color: " + animal.getColor() + "\n");
                    writer.write("ID: " + animal.getId() + "\n");
                    writer.write("Birthplace: " + animal.getBirthPlace() + "\n");
                    writer.write("Weight: " + animal.getWeight() + " pounds\n");
                    writer.write("Birthdate: " + animal.getBirthDate() + "\n");
                    writer.write("Age: " + animal.getAge() + " years\n");
                    writer.write("Arrival Date: " + animal.getArrivalDate() + "\n");
                    writer.write("\n");
                }
                writer.write("\n");
            }

            System.out.println("Zoo population report generated successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
