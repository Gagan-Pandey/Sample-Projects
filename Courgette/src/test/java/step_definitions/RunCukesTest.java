package step_definitions;

import courgette.api.*;
import courgette.api.junit.Courgette;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 1,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        rerunAttempts = 1,
        testOutput = CourgetteTestOutput.CONSOLE,
        reportTargetDir = "output",
        environmentInfo = "browser=chrome; git_branch=develop",
        classPath = {"target/lib/*", "target/test-classes/"},
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "step_definitions",
                plugin = {
                        "pretty",
                        "json:output/cucumber.json",
                        "junit:output/TEST-report.xml"},
                monochrome = true,
                tags = {"@automated"}
        ))
public class RunCukesTest {
        @CourgetteBeforeAll
        public static void setUp() throws VirtualMachineError, IOException {
                System.setProperty("courgette.reportTitle", "Test Automation");
                System.out.println("\n\n\n*************** This is Before All ***************\n\n\n");
        }

        @CourgetteAfterAll
        public static void teardown() throws Exception {
                System.out.println("\n\n\n*************** This is After All ***************\n\n\n");
        }

        @Before
        public void beforeScenario(Scenario scenario) throws Exception {
                System.out.println("\n\n\n############# Test Case Started #############");
                System.out.println(scenario.getName());
                System.out.print("\n\n\n");
        }
}
