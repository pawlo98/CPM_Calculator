import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatableImpl implements Calculatable{

    private final InputData inputData;

    public CalculatableImpl(InputData inputData) {
        this.inputData = inputData;
    }


    @Override
    public BigDecimal calculate() {
        double ppm = inputData.getSex().getValve1() +
                (inputData.getSex().getValue2() * inputData.getWeight()) +
                (inputData.getSex().getValue3() * inputData.getHeight()) -
                (inputData.getSex().getValue4() * inputData.getAge());

        BigDecimal ppmBigDecimal = BigDecimal.valueOf(ppm);
        BigDecimal activity = BigDecimal.valueOf(inputData.getActivity());
        return ppmBigDecimal.multiply(activity).setScale(2,RoundingMode.HALF_UP);
    }
}
