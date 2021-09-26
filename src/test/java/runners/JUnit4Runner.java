package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.BookingCheckTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingCheckTest.class})

public class JUnit4Runner {
}

