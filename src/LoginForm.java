import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{
    private JTextField usernameField;
    private JButton loginButton;
    private JButton registerButton;
    private JTextField passwordField;
    private JPanel loginPanel;

    private static LoginForm f = null;

    public LoginForm(){
        super("Login Form");
        this.setContentPane(this.loginPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToBtnActionPerformed(e);
            }
        });
    }

    public static synchronized LoginForm getInstance(){
        try {
            if (f == null) {
                f = (LoginForm) Class.forName("LoginForm").newInstance();
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println(e.toString());
        }
        return f;
    }

    private void goToBtnActionPerformed(java.awt.event.ActionEvent evt) {
        AdminForm.getInstance().setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> LoginForm.getInstance().setVisible(false));
    }
}
