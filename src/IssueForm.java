import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssueForm extends JFrame{
    private JPanel issueMainPanel;
    private JTextField issuedDateField;
    private JTextField periodField;
    private JTextField userIDNField;
    private JTextField bookISBNField;
    private JButton addIssueBookButton;
    private JTextField bookNameField;

    IssueForm() {
        super("Issued Books");
        this.setContentPane(issueMainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        Database db = new Database();

        addIssueBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = bookNameField.getText();
                String bookISBN = bookISBNField.getText();
                String userIDN = userIDNField.getText();
                String period = periodField.getText();
                String date = issuedDateField.getText();

                Issue issue = new Issue(bookName, bookISBN, userIDN, period, date);
                db.addIssue(issue);
                JOptionPane.showMessageDialog(issueMainPanel,"Issue created");
            }
        });
    }
}
