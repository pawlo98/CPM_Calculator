public enum Sex {
    MALE( 66.5,13.75,5.003,6.775),
    FEMALE( 655.1,9.563,1.85,4.676);


    private final double valve1;
    private final double value2;
    private final double value3;
    private final double value4;

    Sex(double valve1, double value2, double value3, double value4) {
        this.valve1 = valve1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
    }

    public double getValve1() {
        return valve1;
    }

    public double getValue2() {
        return value2;
    }

    public double getValue3() {
        return value3;
    }

    public double getValue4() {
        return value4;
    }
}
