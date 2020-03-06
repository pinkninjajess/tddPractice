public class StringCalculator {

    // "" -> 0
    // "0" -> 0 (int)
    // "1" -> 1 (int)
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

        return -1;
    }
}
