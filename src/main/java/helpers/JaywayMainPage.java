package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: fjodorekstrom
 * Date: 3/20/13
 * Time: 9:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class JaywayMainPage {
    protected WebDriver driver;
    String mainUrl = "http://www.jayway.com/";

    By s = By.id("s");
    By searchsubmit = By.cssSelector(".search_button");

    WebElement searchField = null;
    WebElement searchButton = null;

    public JaywayMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(mainUrl);
    }

    public void close() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void setElementVariables() {
        this.searchButton = getElement(searchsubmit);
        this.searchField = getElement(s);
    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchButton.click();
    }

    public void typeSearchTerm(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public void clickOnSearch() {
        searchButton.click();
    }

    public void waitForElementPresent(final By locator, int timeout) {
        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {

                return driver.findElements(locator).size() > 0;
            }
        };

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(e);

    }

    public WebElement getElement(By locator) {
        waitForElementPresent(locator, 15);
        return driver.findElement(locator);
    }
}