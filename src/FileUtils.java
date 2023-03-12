import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileUtils {
    private Long idCounter = 1L;
    private final String PATH_TO_PERSON_IMPORT = "data/personData.csv";
    private final String PATH_TO_STATISTICS = "";

    public List<Person> readPersonsFromCsv() {
        List<Person> personList = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(PATH_TO_PERSON_IMPORT));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
                String[] personDetails = scanner.nextLine().split(",");
                personList.add(new Person(idCounter ,personDetails[0], personDetails[1], Integer.parseInt(personDetails[2])));
                idCounter +=1 ;
            }
            return personList;
        }

    public void writeStatisticsToFile(List<Person> persons, List<Workout> workouts){

    }
    public int getNumberOfSwimmingWorkoutsByType(List<SwimmingWorkout> workouts, SwimmingType type){
        int counter = 0;
        for (SwimmingWorkout workout:workouts) {
            if (workout.getType() == type){
                counter +=1;
            }
        }
        return counter;
    }
    public int getNumberOfBikingWorkoutsByType(List<BikingWorkout> workouts, BikingType type){
        int counter = 0;
        for (BikingWorkout workout:workouts) {
            if (workout.getType() == type){
                counter +=1;
            }
        }
        return counter;
    }
    public double getAverageDistance (List<Workout> workouts){
        double workoutCounter = 0.0;
        double sumOfDistances = 0.0;

        for (Workout workout:workouts) {
            workoutCounter += 1;
            sumOfDistances += workout.getDistance();
        }

        double averageDistance = sumOfDistances/workoutCounter;
        return averageDistance;
    }
    public double getAverageDuration(List<Workout> workouts) {
        double workoutCounter = 0.0;
        double sumOfDurations = 0.0;

        for (Workout workout : workouts) {
            workoutCounter += 1;
            sumOfDurations += workout.getDuration();
        }

        double averageDuration = sumOfDurations / workoutCounter;
        return averageDuration;
    }
    public double getAverageDurationOfWorkoutByPerson(Long personId, List<? extends Workout> workoutList) {
        double averageDurationOfWorkoutOfSpecificPerson = 0.0;
        for (Workout workout : workoutList) {
            if (workout.getPersonId() == personId) {
                averageDurationOfWorkoutOfSpecificPerson += workout.getDuration();
            }
        }
        return averageDurationOfWorkoutOfSpecificPerson;
    }
    public int getNumberOfBikingWorkoutsByPerson(Long personId, List<Workout> workoutList) {
        int bikeWorkoutCounter = 0;
        for (Workout workout : workoutList) {
            if (workout.getPersonId() == personId) {
                bikeWorkoutCounter += 1;
            }
        }
        return bikeWorkoutCounter;
    }
    public int getNumberOfSwimmingWorkoutsByPerson(Long personId, List<Workout> workoutList) {
        int swimmingWorkoutCounter = 0;
        for (Workout workout : workoutList) {
            if (workout.getPersonId() == personId) {
                swimmingWorkoutCounter += 1;
            }
        }
        return swimmingWorkoutCounter;
    }
}
