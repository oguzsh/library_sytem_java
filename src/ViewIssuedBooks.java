import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewIssuedBooks extends JFrame{
    private JPanel issuedBooksPanel;
    private JTable issuedBooksTable;

    ViewIssuedBooks(){
        super("Issued Books");
        this.setContentPane(this.issuedBooksPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        DefaultTableModel issuedBooksModel = (DefaultTableModel) issuedBooksTable.getModel();
        Database db = new Database();
        issuedBooksTable.setModel(db.viewIssued(issuedBooksModel));
    }
}
