import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String CUSTOM_VARIABLE_LENGTH_DELIMITERS = "//[";
    public static final String CUSTOM_FIXED_LENGTH_DELIMITER = "//";

    public int add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        return Arrays.stream(removeDelimitersFrom(numbers).split(getDelimitersOf(numbers)))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String removeDelimitersFrom(String numbers) {
        if (numbers.startsWith(CUSTOM_VARIABLE_LENGTH_DELIMITERS)) {
            return numbers.split("]")[1];
        }
        if (numbers.startsWith(CUSTOM_FIXED_LENGTH_DELIMITER)) {
            return numbers.substring(3);
        }
        return numbers;
    }

    private String getDelimitersOf(String numbers) {
        List<String> delimitersList = new ArrayList<>();
        delimitersList.add("\\n");
        delimitersList.add(",");
        delimitersList.add(getCustomDelimiter(numbers));
        String join = String.join("|", delimitersList);
        return String.join("|", delimitersList);
    }

    private String getCustomDelimiter(String numbers) {
        if (numbers.startsWith(CUSTOM_VARIABLE_LENGTH_DELIMITERS)) {
            String customDelimiter = numbers.split("\\[")[1].split("]")[0];
            return Pattern.quote(customDelimiter);
        } else if (numbers.startsWith(CUSTOM_FIXED_LENGTH_DELIMITER)) {
            String customDelimiter = numbers.substring(2, 3);
            return Pattern.quote(customDelimiter);
        }
        return null;
    }
}
