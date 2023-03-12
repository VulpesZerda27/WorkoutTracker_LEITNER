import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        List<Person> personList = fileUtils.readPersonsFromCsv();
        List<Workout> workoutList = new ArrayList<>();

        workoutList.add(new BikingWorkout(1L, 20, 5690, 1L, BikingType.ROAD));
        workoutList.add(new SwimmingWorkout(2L, 50, 303, 1L, SwimmingType.BACKSTROKE));
        workoutList.add(new BikingWorkout(3L, 30, 3900, 1L, BikingType.MOUNTAIN));
        workoutList.add(new SwimmingWorkout(4L, 15, 200, 1L, SwimmingType.BACKSTROKE));
        workoutList.add(new BikingWorkout(5L, 20, 8290, 1L, BikingType.MOUNTAIN));
        workoutList.add(new SwimmingWorkout(6L, 45, 150, 2L, SwimmingType.BACKSTROKE));
        workoutList.add(new BikingWorkout(7L, 72, 3250, 2L, BikingType.MOUNTAIN));
        workoutList.add(new SwimmingWorkout(8L, 45, 400, 2L, SwimmingType.BUTTERFLY));
        workoutList.add(new BikingWorkout(9L, 34, 2209, 2L, BikingType.ROAD));
        workoutList.add(new SwimmingWorkout(10L, 13, 604, 2L, SwimmingType.BACKSTROKE));
        workoutList.add(new BikingWorkout(11L, 22, 4980, 3L, BikingType.MOUNTAIN));
        workoutList.add(new SwimmingWorkout(12L, 18, 450, 3L, SwimmingType.BACKSTROKE));
        workoutList.add(new BikingWorkout(13L, 57, 8906, 3L, BikingType.MOUNTAIN));
        workoutList.add(new SwimmingWorkout(14L, 48, 680, 3L, SwimmingType.BUTTERFLY));
        workoutList.add(new BikingWorkout(15L, 9, 2005, 3L, BikingType.ROAD));

        fileUtils.writeStatisticsToFile(personList, workoutList);
    }
}