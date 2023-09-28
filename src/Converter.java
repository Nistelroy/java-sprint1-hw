public class Converter {

    public final double STRIDE_LENGTH_IN_KILOMETERS = 0.00075;
    public final double KILOCALORIES_PER_STEP = 0.05;

    int convertToKm(int steps) {


        steps = (int) (steps * STRIDE_LENGTH_IN_KILOMETERS);
        return steps;
    }

    int convertStepsToKilocalories(int steps) {

        steps = (int) (steps * KILOCALORIES_PER_STEP);
        return steps;
    }
}
