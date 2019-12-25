import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        Database db = new Database();

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String bookName = bookNameField.getText();
                String author = authorField.getText();
                String releaseDate = releaseDateField.getText();
                String ISBN = isbnField.getText();
                String publisher = publisherField.getText();

                Book book = new Book(bookName, author, releaseDate, publisher, ISBN);
                db.addBook(book);
                JOptionPane.showMessageDialog(addBookPanel, "Book created");
            }
        });
    }
}
