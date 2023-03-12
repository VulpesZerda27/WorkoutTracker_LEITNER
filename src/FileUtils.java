import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    private Long idCounter = 1L;
    private final String PATH_TO_PERSON_IMPORT = "data/personData.csv";
    private final String PATH_TO_STATISTICS = "data/statistics.txt";

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
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(new File(PATH_TO_STATISTICS));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        int personCounter = 1;

        for (Person person:persons) {
            printWriter.printf("- - - Person %d - - -\n", personCounter);
            personCounter += 1;
            printWriter.printf("Name: %s %s\n", person.getFirstName(), person.getLastName());
            printWriter.printf("Number of biking exercises: %d\n", getNumberOfBikingWorkoutsByPerson(person.getId(), workouts));
            printWriter.printf("Number of swimming exercises: %d\n", getNumberOfSwimmingWorkoutsByPerson(person.getId(), workouts));
            printWriter.printf("Average Duration: %.0f minutes\n", getAverageDurationOfWorkoutByPerson(person.getId(), workouts));
            printWriter.println();
        }

        List<BikingWorkout> bikingWorkouts = new ArrayList<>();
        for (Workout workout:workouts) {
            if(workout instanceof BikingWorkout)
                bikingWorkouts.add((BikingWorkout) workout);
        }

        printWriter.printf("- - - Biking - - -\n");
        printWriter.printf("Average Distance: %.0fm\n", getAverageDistance(bikingWorkouts));
        printWriter.printf("Average Duration: %.0f minutes\n", getAverageDuration(bikingWorkouts));
        printWriter.printf("# mountain: %d\n", getNumberOfBikingWorkoutsByType(bikingWorkouts, BikingType.MOUNTAIN));
        printWriter.printf("# road: %d\n", getNumberOfBikingWorkoutsByType(bikingWorkouts, BikingType.ROAD));
        printWriter.println();

        List<SwimmingWorkout> swimmingWorkouts = new ArrayList<>();
        for (Workout workout:workouts) {
            if(workout instanceof SwimmingWorkout)
                swimmingWorkouts.add((SwimmingWorkout) workout);
        }

        printWriter.printf("- - - Swimming - - -\n");
        printWriter.printf("Average Distance: %.0f\n", getAverageDistance(swimmingWorkouts));
        printWriter.printf("Average Duration: %.0f\n", getAverageDuration(swimmingWorkouts));
        printWriter.printf("# backstroke: %d\n", getNumberOfSwimmingWorkoutsByType(swimmingWorkouts, SwimmingType.BACKSTROKE));
        printWriter.printf("# butterfly: %d\n", getNumberOfSwimmingWorkoutsByType(swimmingWorkouts, SwimmingType.BUTTERFLY));
        printWriter.println();

        printWriter.close();
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
    public double getAverageDistance (List<? extends Workout> workouts){
        double workoutCounter = 0.0;
        double sumOfDistances = 0.0;

        for (Workout workout:workouts) {
            workoutCounter += 1;
            sumOfDistances += workout.getDistance();
        }

        double averageDistance = sumOfDistances/workoutCounter;
        return averageDistance;
    }
    public double getAverageDuration(List<? extends Workout> workouts) {
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
            if (workout.getPersonId() == personId && workout instanceof BikingWorkout) {
                bikeWorkoutCounter += 1;
            }
        }
        return bikeWorkoutCounter;
    }
    public int getNumberOfSwimmingWorkoutsByPerson(Long personId, List<Workout> workoutList) {
        int swimmingWorkoutCounter = 0;
        for (Workout workout : workoutList) {
            if (workout.getPersonId() == personId && workout instanceof  SwimmingWorkout) {
                swimmingWorkoutCounter += 1;
            }
        }
        return swimmingWorkoutCounter;
    }
}
