import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        int sum = 0;
        String[] numbersArray = numbers.split("[,\n]");
        for (String s : numbersArray) {
            sum += parseInt(s);
        }
        return sum;
    }
}
