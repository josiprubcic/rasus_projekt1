import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CsvReader {
    private static final Logger logger = Logger.getLogger(CsvReader.class.getName());


    public static List<double[]> readReadings(String filepath) throws IOException, CsvValidationException {
        List<double[]> readings = new ArrayList<>();
        int lineNumber = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] line;

            // Preskoči header ako postoji
            reader.readNext();

            while ((line = reader.readNext()) != null) {
                lineNumber++;


                if (line.length < 6) {
                    logger.warning("Linija " + lineNumber + " nema dovoljno polja! Ima samo " + line.length);
                    continue;
                }

                try {
                    double[] reading = new double[6];
                    reading[0] = line[0].isEmpty() ? 0.0 : Double.parseDouble(line[0]); // temp
                    reading[1] = line[1].isEmpty() ? 0.0 : Double.parseDouble(line[1]); // pressure
                    reading[2] = line[2].isEmpty() ? 0.0 : Double.parseDouble(line[2]); // humidity
                    reading[3] = line[3].isEmpty() ? 0.0 : Double.parseDouble(line[3]); // co
                    reading[4] = line[4].isEmpty() ? 0.0 : Double.parseDouble(line[4]); // no2
                    reading[5] = line[5].isEmpty() ? 0.0 : Double.parseDouble(line[5]); // so2

                    readings.add(reading);
                    logger.info("Učitano mjerenje " + lineNumber + ": Temp=" + reading[0]);

                } catch (NumberFormatException e) {
                    logger.warning("Greška pri parsiranju linije " + lineNumber + ": " + e.getMessage());
                }
            }

        } catch (CsvValidationException e) {
            logger.severe("CSV validacijska greška: " + e.getMessage());
            throw e;
        }

        logger.info("Ukupno učitano " + readings.size() + " mjerenja iz " + lineNumber + " redaka");
        return readings;
    }
}
