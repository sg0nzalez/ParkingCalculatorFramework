package parkingCalculator;

import dataProviders.ParkingCalculatorDataProvider;
import org.testng.annotations.Test;
import utils.BaseTests;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingCalculatorTests extends BaseTests {

    @Test(dataProvider = "parkingCalculatorData", dataProviderClass = ParkingCalculatorDataProvider.class)
    public void verifyCalculatedCostIsCorrect(ParkingCalculatorDataProvider parkingCalculatorDataProvider) {

        parkingCalculatorPage.selectLotDropdownOptionByValue(parkingCalculatorDataProvider.getLot());
        parkingCalculatorPage.enterEntryTime(parkingCalculatorDataProvider.getEntryTime());
        parkingCalculatorPage.clickEntryTimeRadioButtonByValue(parkingCalculatorDataProvider.getEntryTimeAmPm());
        parkingCalculatorPage.enterEntryDate(parkingCalculatorDataProvider.getEntryDate());
        parkingCalculatorPage.enterExitTime(parkingCalculatorDataProvider.getExitTime());
        parkingCalculatorPage.clickExitTimeRadioButtonByValue(parkingCalculatorDataProvider.getExitTimeAmPm());
        parkingCalculatorPage.enterExitDate(parkingCalculatorDataProvider.getExitDate());
        parkingCalculatorPage.clickCalculateButton();

        assertThat(parkingCalculatorPage.getCostAmount()).as("Verify calculated cost is correct.")
                .isEqualTo(parkingCalculatorDataProvider.getCost());
    }
}