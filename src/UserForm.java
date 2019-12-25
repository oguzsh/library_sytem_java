import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserForm extends JFrame{
    private JButton viewBooksButton;
    private JButton logoutButton;
    private JPanel userPanel;
    private static UserForm f = null;

    UserForm(){
        super("User Page");
        this.setContentPane(this.userPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        viewBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBooksUserForm viewBooksUserForm = new ViewBooksUserForm();
                viewBooksUserForm.setVisible(true);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToLoginForm(e);
            }
        });
    }


    public static synchronized UserForm getInstance(){
        try {
            if (f == null) {
                f = (UserForm) Class.forName("UserForm").newInstance();
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
