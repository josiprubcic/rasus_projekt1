import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        List<double[]> readings = null;
        try {
            String projectRoot = System.getProperty("user.dir");
            String filePath = projectRoot + "/src/main/resources/readings.csv";
            readings = CsvReader.readReadings(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        for (double[] reading : readings) {
            System.out.printf("Temp: %.2f, Pressure: %.2f, Humidity: %.2f, CO: %.2f, NO2: %.2f, SO2: %.2f%n",
                    reading[0], reading[1], reading[2], reading[3], reading[4], reading[5]);
        }



    }
}