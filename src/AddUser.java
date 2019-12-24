import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUser extends JFrame{
    private JPanel addUserPanel;
    private JTextField identifNumField;
    private JRadioButton userRadioButton;
    private JRadioButton adminRadioButton;
    private JButton createUserButton;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField passwordField;

    AddUser(){
        super("Add User");
        this.setContentPane(this.addUserPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        Database db = new Database();
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = firstNameField.getText();
                String userLastName = lastNameField.getText();
                String identifyNumber = identifNumField.getText();
                String password = passwordField.getText();
                String role = "";
                // Radio buttons
                if(userRadioButton.isSelected()){
                    role = "user";
                }
                else if(adminRadioButton.isSelected()){
                    role = "admin";
                }
                else if(userName.equals("") || userLastName.equals("") || identifyNumber.equals("") || password.equals("")){
                    JOptionPane.showMessageDialog(addUserPanel,"Please fill in the blank fields.");
                }
                else{
                    JOptionPane.showMessageDialog(addUserPanel,"Please select role.");
                }
                // Add user
                User newUser = new User(userName, userLastName, password, identifyNumber, role);
                db.addUser(newUser);
                JOptionPane.showMessageDialog(addUserPanel,"User created");

            }
        });
    }
}
