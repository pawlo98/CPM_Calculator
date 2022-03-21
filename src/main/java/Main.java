import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        System.out.println("CPM CALCULATOR");

        pause();

        scaleActivity();

        pause();

        Sex sex=null;
        int age=1;
        double weight=1;
        double height=1;
        double activity=1.2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Give me your sex:MALE/FEMALE");
            sex = Sex.valueOf(reader.readLine().toUpperCase());
            System.out.println("Give me your age:");
            age = Integer.parseInt(reader.readLine());
            System.out.println("Give me your weight in kg:");
            weight= Double.parseDouble(reader.readLine());
            System.out.println("Give me your height in cm:");
            height= Double.parseDouble(reader.readLine());
            System.out.println("Give me your activity:");
            activity= Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        InputData inputData = new InputData(sex,age,weight,height,activity);
        CalculatableImpl calculatable = new CalculatableImpl(inputData);
        BigDecimal kcal = calculatable.calculate().setScale(2,RoundingMode.HALF_UP);
        System.out.println("Basic need: "+ kcal + " kcal");
        BigDecimal deficit = kcal.multiply(BigDecimal.valueOf(0.10).setScale(2,RoundingMode.HALF_UP));
        System.out.println("To lose weight eat: "+ (kcal.subtract(deficit))+ " kcal");

        printBmiCalculate(inputData);

    }

    private static void pause() {
        System.out.println("----------------------------");
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    private static void scaleActivity() {
        StringBuilder scaleActivity= new StringBuilder();
        scaleActivity.append("Scale Activity:");
        scaleActivity.append("\n1.20-1.39 person unactivity");
        scaleActivity.append("\n1.40-1.59 person low activity");
        scaleActivity.append("\n1.60-1.79 person moderately activity");
        scaleActivity.append("\n1.80-1.99 person physically active");
        scaleActivity.append("\n2.00-2.40 person very physically active");

        System.out.println(scaleActivity);
    }

    private static void printBmiCalculate(InputData inputData){
        BmiCalculate bmiCalculate = new BmiCalculate(inputData);
        BigDecimal bmi = bmiCalculate.calculateBmi();
        System.out.println("Your BMI is: " + bmi);

        if (bmi.doubleValue()<=18.5){
            System.out.println("Underweight");
        }
        if (bmi.doubleValue()>18.5 && bmi.doubleValue()<=24.99){
            System.out.println("Correct value");
        }
        if (bmi.doubleValue()>24.99 && bmi.doubleValue()<=29.99){
            System.out.println("Overweight");
        }
        if (bmi.doubleValue()>29.99 && bmi.doubleValue()<=34.99){
            System.out.println("1st degree obesity");
        }
        if (bmi.doubleValue()>34.99 && bmi.doubleValue()<=39.99){
            System.out.println("2nd degree obesity");
        }
        if (bmi.doubleValue()>=40){
            System.out.println("3rd degree obesity");
        }
    }
}
