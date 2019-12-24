import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{
    private JTextField identifyField;
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
                String identify_num = identifyField.getText();
                String password = passwordField.getText();

                if(identify_num.equals("")){ // If identify num is null
                    JOptionPane.showMessageDialog(null,"Please enter identify number");
                }
                else if(password.equals("")){ // If password is null
                    JOptionPane.showMessageDialog(null,"Please enter password");
                }
                else{
                    Database db = new Database();
                    try{
                        db.connect();
                        db.stat.executeUpdate("USE library_system"); // Use the database with the name "library_system"
                        String query = ("SELECT * FROM users WHERE identif_number="+identify_num+" AND password="+password+"");
                        db.rs = db.stat.executeQuery(query);
                        if(!db.rs.next()){
                            System.out.print("No user");
                        }
                        else{
                            db.rs.beforeFirst();  //Move the pointer above
                            while(db.rs.next())
                            {
                                String admin = db.rs.getString("role"); //user is admin
                                if(admin.equals("admin")) { //If boolean value 1
                                    goToAdminForm(e); //redirect to admin menu
                                }
                                else{
                                    goToUserForm(e); //redirect to user menu for that user ID
                                }
                            }
                        }
                    }catch(Exception error){
                        System.err.println(error);
                    }
                }
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

    private void goToAdminForm(ActionEvent evt) {
        AdminForm.getInstance().setVisible(true);
        this.dispose();
    }

    private void goToUserForm(ActionEvent evt) {
        UserForm.getInstance().setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> LoginForm.getInstance().setVisible(false));
    }
}
