import javax.swing.*;
import java.awt.*;
public class OpenDialogue {
    public static void showDialog(JFrame parent) {
        JDialog dialog = new JDialog(parent, "Open As", true);
        dialog.setSize(400, 200);
        dialog.setLocationRelativeTo(parent);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 10, 10));
        JButton docxButton = new JButton("Docx");
        docxButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JButton pdfButton = new JButton("PDF");
        pdfButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JButton pptButton = new JButton("PPT");
        pptButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(docxButton);
        panel.add(pdfButton);
        panel.add(pptButton);
        dialog.add(panel);
        dialog.setVisible(true);
        docxButton.addActionListener(e -> parent.add(new TextEditor(), BorderLayout.CENTER));
        pdfButton.addActionListener(e -> parent.add(new TextEditor(), BorderLayout.CENTER));
        pptButton.addActionListener(e -> parent.add(new TextEditor(), BorderLayout.CENTER));
    }
}
