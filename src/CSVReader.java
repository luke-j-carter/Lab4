import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<EconomicData> readCSV(String csvFile) throws IOException {
        List<EconomicData> dataList = new ArrayList<>();
        BufferedReader reader = null;
        String line;

        try {
            reader = new BufferedReader(new FileReader(csvFile));
            String headerLine = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                // Ensure row has the expected number of columns
                if (row.length < 5) continue; // Skip if not enough columns

                String state = row[0].trim();
                String Description = row[1].trim(); // Keep as String
                String personalIncome = row[2].trim();
                String population = row[3].trim();
                String perCapitaPersonalIncome = row[4].trim();

                dataList.add(new EconomicData(state, Description, personalIncome, population, perCapitaPersonalIncome));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return dataList;
    }
}
