import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mzacharuk on 2017-06-20
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        plugin = { "html:target/cucumber-html-report",
                "json:target/cucumber.json"},
        glue = "steps/",
        tags = {"@dev"}

)
public class ScenarioRunnerTest {


}
