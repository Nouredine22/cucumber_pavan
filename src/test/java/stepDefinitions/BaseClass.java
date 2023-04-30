package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.util.logging.Logger;

public class BaseClass {
    public WebDriver driver;

    public LoginPage lp;
    public AddCustomerPage addCust;
    public SearchCustomerPage SearchCust;
    public static Logger logger;

    //below methods to generate random string for unique email
    public static String randomestring(){
        return (RandomStringUtils.randomAlphabetic(5));
    }
}
