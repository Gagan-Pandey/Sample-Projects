package step_definitions;

import io.cucumber.java.*;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.TestCaseFinished;

public class Hooks implements ConcurrentEventListener {

    @BeforeAll
    public static void beforeAll() throws Exception {
        System.out.println("\n\n\n############# Test Suite Started #############\n\n\n");
    }

    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        System.out.println("\n\n\n############# Test Case Started #############");
        System.out.println("---------------");
        System.out.println(scenario.getName());
        System.out.println("---------------");
        System.out.print("\n\n\n");
    }

    @After
    public void afterScenario(Scenario scenario) throws Exception {
        System.out.println("\n\n\n############# Test Case Finished #############\n\n\n");
    }

    @AfterAll
    public static void afterAll() throws Exception {
        System.out.println("\n\n\n############# Test Suite Finished #############\n\n\n");
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        Result result = event.getResult();
        if (result.getError() != null) {
            System.out.println(result.getError().toString()+"\n"+result.getError().getCause().toString());
        }
    }

}
