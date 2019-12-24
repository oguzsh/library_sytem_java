import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewBooks extends JFrame {
    private JPanel viewBooksPanel;
    private JTable booksTable;

    ViewBooks(){
        super("View Books");
        this.setContentPane(this.viewBooksPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        DefaultTableModel bookDataModel = (DefaultTableModel) booksTable.getModel();
        Database db = new Database();
        booksTable.setModel(db.viewBooks(bookDataModel));
    }
}
