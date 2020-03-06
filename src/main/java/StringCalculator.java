import static java.lang.Integer.parseInt;

public class StringCalculator {
    // "1,2" -> 3 (int)
    // "1,2,3" -> 6 (int)
    // "1\n2" -> 3 (int)
    // "1\n2\n3" -> 6 (int)
    // "1,2\n3" -> 6
    // "42,32"
    public int add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        int sum = 0;
        String[] numbersArray = numbers.split(",");
        for (String s : numbersArray) {
            sum += parseInt(s);
        }
        return sum;
    }
}
