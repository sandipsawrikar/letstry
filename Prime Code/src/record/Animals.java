package record;

public class Animals {
    private String name;
    private String animalType;
    private long runningSpeed;

    public Animals(String name, String animalType, long runningSpeed) {
        this.name = name;
        this.animalType = animalType;
        this.runningSpeed = runningSpeed;
    }

   /* @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", animalType='" + animalType + '\'' +
                ", runningSpeed=" + runningSpeed +
                '}';
    }*/
}
