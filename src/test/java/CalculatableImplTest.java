import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatableImplTest {

   private final Sex sex;
   private final int age;
   private final double weight;
   private final double height;
   private final double activity;
   private final BigDecimal resulat;

    public CalculatableImplTest(Sex sex, int age, double weight, double height, double activity,BigDecimal resulat) {
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.activity = activity;
        this.resulat = resulat;
    }


    @Test
    public void calculateCPM_withParameters() {
        //Given
        InputData inputData = new InputData(sex, age, weight, height, activity);
        Calculatable calculatable = new CalculatableImpl(inputData);
        //When
        BigDecimal calculate = calculatable.calculate();
        //Then
        Assert.assertEquals(resulat, calculate);
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Sex.FEMALE, 21,64,173,1.6,BigDecimal.valueOf(2382.38)},
                {Sex.FEMALE, 22,67,178,1.8,BigDecimal.valueOf(2740.05)},
                {Sex.FEMALE, 20,62,170,1.5,BigDecimal.valueOf(2203.48)},
                {Sex.FEMALE, 24,68,179,1.4,BigDecimal.valueOf(2134.03)},
                {Sex.FEMALE, 27,70,176,1.6,BigDecimal.valueOf(2438.17)},
                {Sex.FEMALE, 36,73,178,1.3,BigDecimal.valueOf(1968.41)},
                {Sex.MALE, 23,73,178,1.8,BigDecimal.valueOf(3248.93)},
                {Sex.MALE, 24,70,184,1.7,BigDecimal.valueOf(3037.82)},
                {Sex.MALE, 26,76,189,1.9,BigDecimal.valueOf(3573.74)},
                {Sex.MALE, 27,79,185,1.4,BigDecimal.valueOf(2653.53)},
                {Sex.MALE, 29,80,192,1.8,BigDecimal.valueOf(3475.08)},
                {Sex.MALE, 40,92,184,1.3,BigDecimal.valueOf(2575.37)}
        });
    }
}