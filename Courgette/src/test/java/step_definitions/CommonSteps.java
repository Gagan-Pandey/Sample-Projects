package step_definitions;

import platforms.DRMPlatform;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.File;
import java.io.IOException;

public class CommonSteps {

    DRMPlatform drmPlatform = new DRMPlatform();

    @Given("^DRM is launched$")
    public void launchKui() throws IOException {
        drmPlatform.setUp();
    }

    @Then("User verifies DRM login page$")
    public void verifyDRMLoginPage() throws Exception {
        drmPlatform.verifyDRMLoginPage();
    }
    @Then("user verifies google chrome page$")
    public void verifyGoogleChromePagePage() throws Exception {
        drmPlatform.verifyGoogleChromePagePage();
    }

    @And("User ends the session$")
    public void endSession() {
        drmPlatform.tearDown();
    }

}
