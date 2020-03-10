import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void add_EmptyString_ReturnsZero() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void add_singleNumber_ReturnsSame() {
        assertEquals(10, stringCalculator.add("10"));
    }

    @Test
    public void add_commaSeparatedValues_ReturnsSum() {
        assertEquals(26, stringCalculator.add("1,20,5"));
    }

    @Test
    public void add_numbersWithNewLine_ReturnsSum() {
        assertEquals(20, stringCalculator.add("15\n5"));
    }

    @Test
    public void add_numbersWithCommaAndNewLine_ReturnSum() {
        assertEquals(10, stringCalculator.add("2\n7,1"));
    }

    // "//;1,2;3\n4" -> 10
    @Test
    public void add_numbersWithCustomDelimiter_ReturnsSum() {
        assertEquals(10, stringCalculator.add("//;1,2;3\n4"));
        assertEquals(20, stringCalculator.add("//.1,2.3\n14"));
    }

    @Test
    public void add_numbersWithCustomDelimiterAnyLength_ReturnsSum() {
        assertEquals(20, stringCalculator.add("//[;;;]1,2;;;3\n14"));
    }


}
