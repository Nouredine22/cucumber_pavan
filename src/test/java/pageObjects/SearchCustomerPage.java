package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerPage {
    public WebDriver ldriver;
    //WaitHelper waithelper;

    public SearchCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        //waithelper=new WaitHelper(ldriver);
    }

    // list of elements :
    @FindBy(xpath = "//input[@id='SearchEmail']")
    WebElement txtEmail;
    @FindBy(xpath = "//input[@id='SearchFirstName']")
    WebElement txtFirstName;
    @FindBy(xpath = "//input[@id='SearchLastName']")
    WebElement txtLastName;
    @FindBy(xpath = "//button[@id='search-customers']")
    WebElement btnSearch;
    @FindBy(xpath = "//table[@id='customers-grid']")
    WebElement table;
    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;
    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> tableColumns;


    // methods actions

    public void setEmail(String email) {
        txtEmail.click();
        txtEmail.sendKeys(email);
    }
    public void setFirstName(String FName) {
        txtFirstName.click();
        txtFirstName.sendKeys(FName);
    }
    public void setLastName(String LName) {
        txtLastName.click();
        txtLastName.sendKeys(LName);
    }
    public void clickSearch(){
        btnSearch.click();
    }
    public int getNumOfRows(){
        return tableRows.size();
    }
    public int getNumOfColumns(){
        return tableColumns.size();
    }
    public boolean searchCustomerByEmail(String email){
        boolean flag = false;
        for (int i=1;i<=getNumOfRows();i++){
            String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
            System.out.println(emailid);
            if(emailid.equals(email)){
                flag=true;
            }
        }
        return flag;
    }
}
