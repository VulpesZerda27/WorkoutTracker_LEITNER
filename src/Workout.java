public abstract class Workout {
    private Long id;
    private int duration;
    private int distance;
    private Long personId;
    Workout(Long id, int duration, int distance, Long personId){
        this.id = id;
        this.duration = duration;
        this.distance = distance;
        this.personId = personId;
    }

    public Long getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public int getDistance() {
        return distance;
    }

    public Long getPersonId() {
        return personId;
    }
}
