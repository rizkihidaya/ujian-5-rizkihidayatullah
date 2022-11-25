package com.juaracoding.rizkihidayatullah.ujianmingguan5;

import com.juaracoding.rizkihidayatullah.ujianmingguan5.pages.Login;
import com.juaracoding.rizkihidayatullah.ujianmingguan5.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogin {

    private static WebDriver driver;
    private static ExtentTest extentTest;
    private Login login = new Login();

    public TestLogin() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("User go to web Shop Demoqa")
    public void user_go_to_web_shop_demoqa() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "User go to web Shop Demoqa");

    }

    @And("User enter username or email password invalid")
    public void user_enter_username_or_email_password_invalid() {
        login.loginPage();
        login.loginForm("rizkiii", "@Kikiki");
        extentTest.log(LogStatus.PASS, "User enter username or email password invalid");
    }

    @And("User click button login")
    public void user_click_button_login() {
        login.clickBtnLogin();
        extentTest.log(LogStatus.PASS, "User click button login");
    }

    @Then("User invalid credentials")
    public void user_invalid_credentials() {
        Assert.assertTrue(login.getTxtMessageError().contains("ERROR"));
        extentTest.log(LogStatus.PASS, "User invalid credentials");
    }

    @When("User enter username or email password valid")
    public void user_enter_username_or_email_password_valid() {
        login.loginForm("rizki_h1", "@Rizki03081996");
        extentTest.log(LogStatus.PASS, "User enter username or email password valid");
    }

    @And("User click button login valid")
    public void user_click_button_login_valid() {
        login.clickBtnLogin();
        extentTest.log(LogStatus.PASS, "User click button login valid");
    }

    @Then("User valid credentials")
    public void user_valid_credentials() {
        Assert.assertEquals(login.getTxtMyAccount(), "rizki_h1");
        extentTest.log(LogStatus.PASS, "User valid credentials");
    }

}
