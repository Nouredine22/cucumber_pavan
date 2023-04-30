package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    By lnkCustomers_menuItem = By.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");
    By btnAddNew = By.xpath("//a[@class='btn btn-primary']");

    By txtEmail = By.xpath("//input[@id='Email']");
    By txtPassword = By.xpath("//input[@id='Password']");

    By txtCustomerRoles = By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]");
    By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
    By lstitemRegistred = By.xpath("//li[contains(text(),'Registered')]");
    By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
    By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");

    By drpmgrOfVendor = By.xpath("//*[@name='VendorId']");
    By rdMaleGender = By.xpath("//input[@id='Gender_Male']");
    By rdFemaleGender = By.xpath("//input[@id='Gender_Female']");

    By txtFirstName = By.xpath("//input[@id='FirstName']");
    By txtLastName = By.xpath("//input[@id='LastName']");

    By txtDob = By.id("DateOfBirth");
    By txtCompanyName = By.xpath("//input[@id='Company']");
    By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
    By btnSave = By.xpath("//button[@name='save']");


    //Actions methods

    public String getPageTitle() {        // this method needed multiple times
        return ldriver.getTitle();
    }

    public void clickOnCustomersMenu() {
        ldriver.findElement(lnkCustomers_menu).click();
    }

    public void clickOnCustomersMenuItem() {
        ldriver.findElement(lnkCustomers_menuItem).click();
    }

    public void clickOnAddNew() {
        ldriver.findElement(btnAddNew).click();
    }

    public void setEmail(String email) {
        ldriver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        ldriver.findElement(txtPassword).sendKeys(password);
    }

    public void setCustomerRoles(String role) {                // I M NOT USING THIS METHOD

       if (!role.equals("Vendors")) {
            ldriver.findElement(By.xpath(""));   // I cant find this element path
            ldriver.findElement(txtCustomerRoles).click();
            WebElement listitem;

            if (role.equals("Administrators")) {
                listitem = ldriver.findElement(lstitemAdministrators);
            } else if (role.equals("Guests")) {
                listitem = ldriver.findElement(lstitemGuests);
            } else if (role.equals("Registered")) {
                listitem = ldriver.findElement(lstitemRegistred);
            } else if (role.equals("Vendors")) {
                listitem = ldriver.findElement(lstitemVendors);
            } else {
                listitem = ldriver.findElement(lstitemGuests);
            }
            listitem.click();
        }
    }

    public void setManagerOfVendor(String value) {

        Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
        drp.selectByVisibleText(value);
    }

    public void setGender(String gender) {
        if (gender.equals("Male")) {
            ldriver.findElement(rdMaleGender).click();
        } else if (gender.equals("Female")) {
            ldriver.findElement(rdFemaleGender).click();
        } else {
            ldriver.findElement(rdMaleGender).click(); // default
        }
    }

    public void setFirstName(String fname) {
        ldriver.findElement(txtFirstName).sendKeys(fname);
    }

    public void setLastName(String lname) {
        ldriver.findElement(txtLastName).sendKeys(lname);
    }

    public void setDob(String dob) {
        ldriver.findElement(txtDob).sendKeys(dob);
    }

    public void setCompanyName(String comName) {
        ldriver.findElement(txtCompanyName).sendKeys(comName);
    }

    public void setAdminContent(String content) {
        ldriver.findElement(txtAdminContent).sendKeys(content);
    }

    public void clickOnSave() {
        ldriver.findElement(btnSave).click();
    }


}
