package dataProviders;

import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import static utils.Urls.TEST_DATA_CSV_PATH;


public class ParkingCalculatorDataProvider {

    private String lot;
    private String entryTime;
    private String entryTimeAmPm;
    private String entryDate;
    private String exitTime;
    private String exitTimeAmPm;
    private String exitDate;
    private BigDecimal cost;

    public ParkingCalculatorDataProvider() {

    }

    public ParkingCalculatorDataProvider(String lot, String entryTime, String entryTimeAmPm, String entryDate, String exitTime,
                                         String exitTimeAmPm, String exitDate, BigDecimal cost) {
        this.lot = lot;
        this.entryTime = entryTime;
        this.entryTimeAmPm = entryTimeAmPm;
        this.entryDate = entryDate;
        this.exitTime = exitTime;
        this.exitTimeAmPm = exitTimeAmPm;
        this.exitDate = exitDate;
        this.cost = cost;
    }


    public String getLot() {
        return lot;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public String getEntryTimeAmPm() {
        return entryTimeAmPm;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public String getExitTime() {
        return exitTime;
    }

    public String getExitTimeAmPm() {
        return exitTimeAmPm;
    }

    public String getExitDate() {
        return exitDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public void setEntryTimeAmPm(String entryTimeAmPm) {
        this.entryTimeAmPm = entryTimeAmPm;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public void setExitTimeAmPm(String exitTimeAmPm) {
        this.exitTimeAmPm = exitTimeAmPm;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @DataProvider(name = "parkingCalculatorData")
    public static Object[] getDataFromCsvFile() {
        ICsvBeanReader beanReader = null;

        Object[] csvData = null;

        CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), // lot
                new NotNull(), // entryTime
                new NotNull(), // entryTimeAmPm
                new NotNull(), // entryDate
                new NotNull(), // exitTime
                new NotNull(), // exitTimeAmPm
                new NotNull(), // exitDate
                new ParseBigDecimal(), // cost
        };


        try {
            beanReader = new CsvBeanReader(new FileReader(TEST_DATA_CSV_PATH),
                    CsvPreference.STANDARD_PREFERENCE);

            String[] header = beanReader.getHeader(true);
            ParkingCalculatorDataProvider parkingCalculatorDataProvider;

            csvData = new Object[beanReader.getRowNumber()+1];

            int i = 0;

            while ((parkingCalculatorDataProvider = beanReader.read(ParkingCalculatorDataProvider.class, header, processors)) != null) {

                csvData[i] = parkingCalculatorDataProvider;

                i++;
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Could not find the CSV file: " + ex);
        } catch (IOException ex) {
            System.err.println("Error reading the CSV file: " + ex);
        } finally {
            if (beanReader != null) {
                try {
                    beanReader.close();
                } catch (IOException ex) {
                    System.err.println("Error closing the reader: " + ex);
                }
            }
        }
        return csvData;
    }
}
