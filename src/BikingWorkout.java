public class BikingWorkout extends Workout{
    private BikingType type;
    BikingWorkout(Long id, int duration, int distance, Long personId, BikingType type){
        super(id, duration, distance, personId);
        this.type = type;
    }

    public BikingType getType() {
        return type;
    }
}
