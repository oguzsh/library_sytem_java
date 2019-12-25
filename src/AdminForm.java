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
    private JButton logoutButton;
    private JButton issueBookButton;

    private static AdminForm f = null;

    AdminForm(){
        super("Admin Functions");
        this.setContentPane(this.adminPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                goToLoginForm(actionEvent);
            }
        });
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddBookForm addBookForm = new AddBookForm();
                addBookForm.setVisible(true);
            }
        });
        viewIssuedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewIssuedBooks viewIssuedBooks = new ViewIssuedBooks();
                viewIssuedBooks.setVisible(true);
            }
        });
        issueBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IssueForm issueForm = new IssueForm();
                issueForm.setVisible(true);
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

    private void goToLoginForm(ActionEvent evt) {
        LoginForm.getInstance().setVisible(true);
        this.dispose();
    }

}
