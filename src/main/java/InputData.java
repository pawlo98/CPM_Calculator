public class InputData {

    private final Sex sex;
    private final int age;
    private final double weight;
    private final double height;
    private final double activity;

    public InputData(Sex sex, int age, double weight, double height, double activity) {
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.activity = activity;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getActivity() {
        return activity;
    }
}
