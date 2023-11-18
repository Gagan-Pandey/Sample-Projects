package step_definitions;

import io.cucumber.java.*;

public class Hooks {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("\n\n\n############# Test Suite Started #############\n\n\n");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("\n\n\n############# Test Case Started #############\n\n\n");
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("\n\n\n############# Test Case Finished #############\n\n\n");
    }

    @AfterAll
    public static void afterAll()  {

    }
}
