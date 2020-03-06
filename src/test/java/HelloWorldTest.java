import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void helloWorldTest(){
        HelloWorld helloWorld = new HelloWorld();
        assertEquals("Hello, World!", helloWorld.helloWorld());
    }
}
