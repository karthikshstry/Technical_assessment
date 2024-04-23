package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/assessment.feature",
        glue = "src/test/java/steps/AssessmentStepsDefinition.java"
)
public class TestRunner {
}
