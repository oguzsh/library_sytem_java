import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewUsers extends JFrame{
    private JPanel viewUsersPanel;
    private JTable viewUsersTable;

    ViewUsers(){
        super("View Users");
        this.setContentPane(this.viewUsersPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
        this.pack();

        DefaultTableModel userDataModel = (DefaultTableModel) viewUsersTable.getModel();
        Database db = new Database();
        viewUsersTable.setModel(db.viewUsers(userDataModel));
    }
}
