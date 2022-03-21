import java.math.BigDecimal;
import java.math.RoundingMode;

public class BmiCalculate{

    private final InputData inputData;

    public BmiCalculate(InputData inputData) {
        this.inputData = inputData;
    }


    public BigDecimal calculateBmi(){
        BigDecimal heightForMeter = BigDecimal.valueOf(inputData.getHeight()).movePointLeft(2);
        BigDecimal weightForBD = BigDecimal.valueOf(inputData.getWeight());

        BigDecimal heightToSquare = heightForMeter.pow(2);

        return weightForBD.divide(heightToSquare,2,RoundingMode.HALF_UP);
    }
}
