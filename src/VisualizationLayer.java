import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class VisualizationLayer {

    public static void main(String[] args) {
        try {
            String csvFile = "C:\\Users\\lukej\\IdeaProjects\\Lab3\\Economic Data 1980-2014.csv"; // Path for Economic Data
            List<EconomicData> data = CSVReader.readCSV(csvFile);

            EconomicDataSubject subject = new EconomicDataSubject();

            // Create EconomicDataViewer and register it as an observer
            SwingUtilities.invokeLater(() -> {
                new EconomicDataViewer(data, subject);
            });

            // Simulate setting new data (e.g., from CSV or other source)
            // This could be triggered by user actions or another event in your application
            EconomicData newData = new EconomicData("NewState", "2020", "50000", "1000000", "50000");
            subject.setEconomicData(newData); // This will notify the observer

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

