package people;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)

public class CommonEngineerTest {

    private Engineer en;
    private int expSkill;

    public CommonEngineerTest(Engineer en, int expSkill) {
        this.en = en;
        this.expSkill = expSkill;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(
                new Object[][] {
                        {new AtEngineer(), 3},
                        {new ManualEngineer(), 2}
                }
        );
    }

    @Test
    public void checkDefaultAge() {
        assertEquals("111", expSkill, en.getSkill());
    }
}