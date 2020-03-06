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

}