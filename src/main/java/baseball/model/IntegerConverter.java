package baseball.model;

public class IntegerConverter {

    private IntegerConverter() {
    }

    public static int convert(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
