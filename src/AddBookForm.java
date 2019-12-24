import javax.swing.*;

public class AddBookForm extends JFrame {
    private JPanel addBookPanel;
    private JButton addBookButton;
    private JTextField bookNameField;
    private JTextField authorField;
    private JTextField releaseDateField;
    private JTextField isbnField;
    private JTextField publisherField;

    AddBookForm(){
        super("Add Book");
        this.setContentPane(this.addBookPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}
