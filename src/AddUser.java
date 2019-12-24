import javax.swing.*;

public class AddUser extends JFrame{
    private JPanel addUserPanel;
    private JTextField identifNumField;
    private JRadioButton userRadioButton;
    private JRadioButton adminRadioButton;
    private JButton createUserButton;
    private JLabel firstNameField;
    private JLabel lastNameField;
    private JLabel passwdField;

    AddUser(){
        super("Add User");
        this.setContentPane(this.addUserPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}
