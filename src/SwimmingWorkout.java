public class SwimmingWorkout extends Workout{
    private SwimmingType type;
    SwimmingWorkout(Long id, int duration, int distance, Long personId, SwimmingType type){
        super(id, duration, distance, personId);
        this.type = type;
    }

    public SwimmingType getType() {
        return type;
    }
}
