import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TextEditor extends JFrame {
    private JTextArea textArea;
    public TextEditor() {
        setTitle("Simple Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);
        JMenuItem boldItem = new JMenuItem("Bold");
        boldItem.addActionListener(new BoldAction());
        editMenu.add(boldItem);

        JMenuItem italicItem = new JMenuItem("Italic");
        italicItem.addActionListener(new ItalicAction());
        editMenu.add(italicItem);

        setJMenuBar(menuBar);
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    private class BoldAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Font currentFont = textArea.getFont();
            Font newFont = new Font(currentFont.getFontName(), Font.BOLD, currentFont.getSize());
            textArea.setFont(newFont);
        }
    }
    private class ItalicAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Font currentFont = textArea.getFont();
            Font newFont = new Font(currentFont.getFontName(), Font.ITALIC, currentFont.getSize());
            textArea.setFont(newFont);
        }
    }
}
