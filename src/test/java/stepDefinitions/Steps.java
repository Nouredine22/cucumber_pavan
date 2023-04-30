package stepDefinitions;

import io.cucumber.java.en.*;
import org.bouncycastle.jcajce.provider.digest.Haraka;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
//import org.apache.log4j.PropertyConfigurator;
import java.util.logging.Logger;

public class Steps extends BaseClass{




    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
        logger= Logger.getLogger("cucumber_pavan");

        //PropertyConfigurator.configure("log4j.properties");

        driver = new ChromeDriver();
        logger.info("******Launching browser*****");

        lp = new LoginPage(driver);

    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        logger.info("******opening url *****");
        driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        lp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        } else{
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("User Click on Log out link")
    public void user_click_on_log_out_link() {
        lp.clickLogout();
    }

    @Then("close browser")
    public void close_browser() {
        driver.close();
    }

    // add new customer steps definition ----------------------------------

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        addCust = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());

    }

    @When("User click on customers menu")
    public void user_click_on_customers_menu() {
        addCust.clickOnCustomersMenu();
    }

    @When("Click on customers menu Item")
    public void click_on_customers_menu_item() {
        addCust.clickOnCustomersMenuItem();
    }

    @When("Click on Add new button")
    public void click_on_add_new_button() {
        addCust.clickOnAddNew();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
    }

    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        String email= randomestring()+"@gmail.com";
        addCust.setEmail(email);
        Thread.sleep(2000);
        addCust.setPassword("test123");
                 // Notes: customer can not be in both "Guest" and " Registered" customer roles
                 //Registred - default
                 //Add the customer to guests or "Registered" customer role
        //addCust.setCustomerRoles("Guest"); // method skipped, need to fix problem in page object.

        addCust.setManagerOfVendor("Vendor 2");
        addCust.setGender("Male");
        addCust.setFirstName("nouredine");
        addCust.setLastName("fed");
        addCust.setDob("7/05/1985");
        addCust.setCompanyName("busyQA");
        addCust.setAdminContent("this is for testing ...");
    }

    @When("Click on Save Button")
    public void click_on_save_button() {
        addCust.clickOnSave();
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains("The new customer has been added successfully"));
    }

    //--------- steps to search customer by Email id --------------------------

    @When("Enter customer Email")
    public void enter_customer_email() {
        logger.info("******Searching Customer By Email*****");
        SearchCust = new SearchCustomerPage(driver);
        SearchCust.setEmail("victoria_victoria@nopCommerce.com");
    }
    @When("Click on search button")
    public void click_on_search_button() {
        SearchCust.clickSearch();
    }
    @Then("User should found Email in the search Table")
    public void user_should_found_email_in_the_search_table() {
        Boolean status = SearchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        Assert.assertEquals(true,status);
    }
}
