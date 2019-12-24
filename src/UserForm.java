import javax.swing.*;

public class UserForm extends JFrame{
    private JButton viewBooksButton;
    private JButton myBooksButton;
    private JPanel userPanel;

    UserForm(){
        super("User Page");
        this.setContentPane(this.userPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

    }
}
