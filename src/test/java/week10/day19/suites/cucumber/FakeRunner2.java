package week10.day19.suites.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"week10.day19.fake"},
        features = {"src/test/resources/feature/FakeTwo.feature"}
)

public class FakeRunner2 {
}