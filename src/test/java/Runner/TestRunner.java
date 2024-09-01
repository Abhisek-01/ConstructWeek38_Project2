package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\Abhisek Baral\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\SeleniumProject2\\src\\test\\resources\\Features", glue = "StepDefinations")

public class TestRunner extends AbstractTestNGCucumberTests {

}