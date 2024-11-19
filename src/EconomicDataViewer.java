import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class EconomicDataViewer extends AbstractTableViewer<EconomicData> implements Observer {

    private EconomicDataSubject subject;

    public EconomicDataViewer(List<EconomicData> data, EconomicDataSubject subject) {
        this.dataList = data;
        this.subject = subject;
        this.subject.registerObserver(this);  // Register this viewer as an observer
        initializeUI();
    }

    @Override
    protected String[] getColumnNames() {
        return new String[] {"State", "Description", "Personal Income", "Population", "Per Capita Income"};
    }

    @Override
    protected void updateTableData(DefaultTableModel model) {
        model.setRowCount(0);  // Clear the table
        for (EconomicData data : dataList) {
            model.addRow(new Object[] {
                    data.getState(),
                    data.getDescription(),
                    data.getPersonalIncome(),
                    data.getPopulation(),
                    data.getPerCapitaPersonalIncome()
            });
        }
    }

    @Override
    protected void onRowSelection() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            EconomicData data = dataList.get(selectedRow);
            showDetails(data);  // Show data details in the text area
        }
    }

    // Observer's update method
    @Override
    public void update(EconomicData data) {
        // Log the data update
        System.out.println("Observer updated with new data: " + data);

        // Handle the new data update
        if (data != null) {
            this.dataList.add(data);  // Add the new data to the list
            updateTableData((DefaultTableModel) table.getModel());  // Refresh table
        } else {
            System.out.println("Received null data, no update.");
        }
    }
}

