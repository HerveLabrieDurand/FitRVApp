package app.fitrvapp.dto;

public class MainMuscleGroupDto {
    private long mainMuscleGroupId;
    private String name;
    private String description;

    public MainMuscleGroupDto(long mainMuscleGroupId, String name, String description) {
        this.mainMuscleGroupId = mainMuscleGroupId;
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "MainMuscleGroupDto{ mainMuscleGroupId=" + mainMuscleGroupId + ", name='" + name + ", description='" + description + '}';
    }
}
