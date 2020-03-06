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
        assertEquals(0, stringCalculator.add("0"));
        assertEquals(10, stringCalculator.add("10"));
    }

}
