import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminForm extends JFrame{
    private JPanel adminPanel;
    private JButton viewBooksButton;
    private JButton viewUsersButton;
    private JButton addBookButton;
    private JButton viewIssuedBooksButton;
    private JButton addUserButton;
    private JButton createResetDBButton;
    private JButton issueBookButton;

    private static AdminForm f = null;

    AdminForm(){
        super("Admin Functions");
        this.setContentPane(this.adminPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

    }

    public static synchronized AdminForm getInstance(){
        try {
            if (f == null) {
                f = (AdminForm) Class.forName("AdminForm").newInstance();
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println(e.toString());
        }
        return f;
    }

}
