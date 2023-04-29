package app.fitrvapp.dto;

public class MuscleGroupDto {
    private long muscleGroupId;
    private long mainMuscleGroupId;
    private String name;
    private String description;

    public MuscleGroupDto(long muscleGroupId, long mainMuscleGroupId, String name, String description) {
        this.muscleGroupId = muscleGroupId;
        this.mainMuscleGroupId = mainMuscleGroupId;
        this.name = name;
        this.description = description;
    }

    public long getMuscleGroupId() {
        return muscleGroupId;
    }

    public void setMuscleGroupId(long muscleGroupId) {
        this.muscleGroupId = muscleGroupId;
    }

    public long getMainMuscleGroupId() {
        return mainMuscleGroupId;
    }

    public void setMainMuscleGroupId(long mainMuscleGroupId) {
        this.mainMuscleGroupId = mainMuscleGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
