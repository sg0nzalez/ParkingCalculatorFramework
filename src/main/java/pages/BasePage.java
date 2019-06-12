package pages;

import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

class BasePage {

    protected final WebDriver webDriver;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }


    public BigDecimal convertStringToBigDecimal(String price) {

        return new BigDecimal(price.replace("$","").trim());
    }
}
