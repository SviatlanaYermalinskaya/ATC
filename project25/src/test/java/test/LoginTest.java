package test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(tags = "~@login")
//@CucumberOptions(tags = "~@mail")
//@CucumberOptions(tags = "~@mail", feature="src/test/java/test")

@CucumberOptions(
        features= "src/test/java/test", 
            glue=""
)
public class LoginTest {

}
