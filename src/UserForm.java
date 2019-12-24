import javax.swing.*;

public class UserForm extends JFrame{
    private JButton viewBooksButton;
    private JButton myBooksButton;
    private JPanel userPanel;
    private static UserForm f = null;

    UserForm(){
        super("User Page");
        this.setContentPane(this.userPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
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
}
