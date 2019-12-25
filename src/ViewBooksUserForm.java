import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBooksUserForm extends JFrame{
    private JPanel viewBooksUserPanel;
    private JTable viewBooksUserTable;

    ViewBooksUserForm(){
        super("View Books");
        this.setContentPane(this.viewBooksUserPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        DefaultTableModel userBookDataModel = (DefaultTableModel) viewBooksUserTable.getModel();
        Database db = new Database();
        viewBooksUserTable.setModel(db.viewBooks(userBookDataModel));
    }
}
