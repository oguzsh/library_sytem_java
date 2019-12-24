import javax.swing.*;

public class ViewUsers extends JFrame{
    private JPanel viewUsersPanel;
    private JTable viewUsersTable;

    ViewUsers(){
        super("View Users");
        this.setContentPane(this.viewUsersPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}
