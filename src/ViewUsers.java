import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewUsers extends JFrame{
    private JPanel viewUsersPanel;
    private JTable viewUsersTable;
    private JButton removeUserButton;

    ViewUsers(){
        super("View Users");
        this.setContentPane(this.viewUsersPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
        this.pack();

        DefaultTableModel userDataModel = (DefaultTableModel) viewUsersTable.getModel();
        Database db = new Database();
        viewUsersTable.setModel(db.viewUsers(userDataModel));
        removeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userIdentify= JOptionPane.showInputDialog("Please type identify number: ");
                db.removeUser(userIdentify);
                userDataModel.setRowCount(0);
                userDataModel.setColumnCount(0);
                viewUsersTable.setModel(db.viewUsers(userDataModel));
            }
        });
    }
}
