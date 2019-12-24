import javax.swing.*;
import javax.swing.text.View;
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

        viewBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBooks viewBooksForm = new ViewBooks();
                viewBooksForm.setVisible(true);
            }
        });
        viewUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewUsers viewUsersForm = new ViewUsers();
                viewUsersForm.setVisible(true);
            }
        });
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUser addUserForm = new AddUser();
                addUserForm.setVisible(true);
            }
        });
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
