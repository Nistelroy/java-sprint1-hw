public class Converter {

    int convertToKm(int steps) {  // по условию задачи надо использовать int

        steps = steps * 75 / 100_000;
        return steps;
    }

    int convertStepsToKilocalories(int steps) {

        steps = steps * 50 / 1000;
        return steps;
    }
}
