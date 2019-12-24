import javax.swing.*;

public class ViewBooks extends JFrame {
    private JPanel viewBooksPanel;
    private JTable booksTable;

    ViewBooks(){
        super("View Books");
        this.setContentPane(this.viewBooksPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}
