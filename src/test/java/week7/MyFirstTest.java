package week7;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyFirstTest {

    @Ignore("111")
    @Test
    public void myTest1() {
        assertEquals("1", 1, 1);
    }

    @Test
    public void myTest2() {
        assertEquals("1", 1, 1);
    }
}