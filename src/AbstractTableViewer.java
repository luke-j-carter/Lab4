import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

public abstract class AbstractTableViewer<T> {

    protected List<T> dataList;
    protected JTable table;
    protected JTextArea detailsArea;

    // Template Method defining the skeleton of the algorithm
    public final void initializeUI() {
        JFrame frame = new JFrame("Data Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Initialize table
        String[] columnNames = getColumnNames();
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        updateTableData(model);

        // Create a TableRowSorter and set it on the table
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Setup row selection listener (to show details of selected item)
        table.getSelectionModel().addListSelectionListener(e -> onRowSelection());

        JScrollPane tableScrollPane = new JScrollPane(table);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Setup details display area
        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        mainPanel.add(detailsArea, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Abstract method for subclasses to define column names
    protected abstract String[] getColumnNames();

    // Abstract method for subclasses to define how data should be added to the table
    protected abstract void updateTableData(DefaultTableModel model);

    // Abstract method to handle row selection (display item details)
    protected abstract void onRowSelection();

    // Utility method to update details area for a specific item
    protected void showDetails(T data) {
        detailsArea.setText(data.toString());
    }
}
