package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.math.BigDecimal;

public class ParkingCalculatorPage extends BasePage {

    private By lotDropdown = By.id("Lot");
    private By entryTimeTextfield = By.id("EntryTime");
    private By entryTimeAmRadioButton = By.xpath("//input[@name='EntryTimeAMPM' and @value='AM']");
    private By entryTimePmRadioButton = By.xpath("//input[@name='EntryTimeAMPM' and @value='PM']");
    private By entryDateTextfield = By.id("EntryDate");
    private By exitTimeTextfield = By.id("ExitTime");
    private By exitTimeAmRadioButton = By.xpath("//input[@name='ExitTimeAMPM' and @value='AM']");
    private By exitTimePmRadioButton = By.xpath("//input[@name='ExitTimeAMPM' and @value='PM']");
    private By exitDateTextfield = By.id("ExitDate");
    private By costAmount = By.xpath("//b[contains(text(),'$')]");
    private By calculateButton = By.name("Submit");


    public ParkingCalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void selectLotDropdownOptionByValue(String lotValue) {

        Select lotSelect = new Select(webDriver.findElement(lotDropdown));
        lotSelect.selectByValue(lotValue);
    }

    public void enterEntryTime(String entryTime) {

        webDriver.findElement(entryTimeTextfield).clear();
        webDriver.findElement(entryTimeTextfield).sendKeys(entryTime);
    }

    public void clickEntryTimeRadioButtonByValue(String value) {

        if (value.equals("AM")) {
            clickEntryTimeAmRadioButton();
        } else {
            clickEntryTimePmRadioButton();
        }
    }

    private void clickEntryTimeAmRadioButton() {

        webDriver.findElement(entryTimeAmRadioButton).click();
    }

    private void clickEntryTimePmRadioButton() {

        webDriver.findElement(entryTimePmRadioButton).click();
    }

    public void enterEntryDate(String entryDate) {

        webDriver.findElement(entryDateTextfield).clear();
        webDriver.findElement(entryDateTextfield).sendKeys(entryDate);
    }

    public void enterExitTime(String exitTime) {

        webDriver.findElement(exitTimeTextfield).clear();
        webDriver.findElement(exitTimeTextfield).sendKeys(exitTime);
    }

    public void clickExitTimeRadioButtonByValue(String value) {

        if (value.equals("AM")) {
            clickExitTimeAmRadioButton();
        } else {
            clickExitTimePmRadioButton();
        }
    }

    private void clickExitTimeAmRadioButton() {

        webDriver.findElement(exitTimeAmRadioButton).click();
    }

    private void clickExitTimePmRadioButton() {

        webDriver.findElement(exitTimePmRadioButton).click();
    }

    public void enterExitDate(String exitDate) {

        webDriver.findElement(exitDateTextfield).clear();
        webDriver.findElement(exitDateTextfield).sendKeys(exitDate);
    }

    public BigDecimal getCostAmount() {

        return convertStringToBigDecimal(webDriver.findElement(costAmount).getText());
    }

    public void clickCalculateButton() {

        webDriver.findElement(calculateButton).click();
    }
}
