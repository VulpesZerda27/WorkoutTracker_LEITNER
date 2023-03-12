import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(1L, "maria", "maurer", 25);
        Person person2 = new Person(2L, "markus", "maurer", 32);

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);

        ArrayList<Workout> workoutList = new ArrayList<>();
        workoutList.add(new BikingWorkout(1L, 20, 50, 1L, BikingType.ROAD));
        workoutList.add(new BikingWorkout(2L, 40, 20, 1L, BikingType.ROAD));

        FileUtils fileUtils = new FileUtils();

        System.out.println(fileUtils.getAverageDistance(workoutList));
        System.out.println(fileUtils.getAverageDuration(workoutList));
        System.out.println(fileUtils.getNumberOfBikingWorkoutsByPerson(1L, workoutList));
        //fileUtils.getNumberOfBikingWorkoutsByType(workoutList, BikingType.ROAD);
    }
}