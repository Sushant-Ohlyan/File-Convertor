import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CustomInterface extends JFrame {
    private JPanel recentPanel;
    private TextEditor textEditorPanel;
    public CustomInterface() {
        setTitle("File Converter");
        setSize(1000, 800);
        setLocationRelativeTo(null);  // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icon.jpg")).getImage());
        setLayout(new BorderLayout());
        JPanel topPanel = createTopPanel();
        recentPanel = new JPanel();
        recentPanel.setLayout(new BorderLayout());
        recentPanel.setBorder(BorderFactory.createTitledBorder("Recent from the latest to oldest"));
        JTextArea recentTextArea = new JTextArea();
        recentTextArea.setEditable(false);
        recentPanel.add(new JScrollPane(recentTextArea), BorderLayout.CENTER);
        textEditorPanel = new TextEditor();
        add(topPanel, BorderLayout.NORTH);
        add(recentPanel, BorderLayout.CENTER);
    }
    private JPanel createTopPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 10, 20));
        JButton newButton = new JButton( resizeImage("/newfile.png", 150, 200));
        newButton.setPreferredSize(new Dimension(155, 230));
        JButton openButton = new JButton( resizeImage("/open.png", 150, 200));
        openButton.setPreferredSize(new Dimension(150, 230));
        JButton mostRecentButton = new JButton("Most recent");
        mostRecentButton.setPreferredSize(new Dimension(150, 230));
        panel.add(newButton);
        panel.add(openButton);
        panel.add(mostRecentButton);
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TextEditor();
            }
        });
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenDialogue.showDialog(CustomInterface.this);
            }
        });
        mostRecentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextArea recentTextArea = (JTextArea) ((JScrollPane) recentPanel.getComponent(0)).getViewport().getView();
                recentTextArea.append("Most recent button clicked\n");
            }
        });
        return panel;
    }
//    private void openTextEditor() {
//        if (textEditorPanel == null) {
//            textEditorPanel = new TextEditor();
//        }
//        JFrame frame = new JFrame("Text Editor");
//        frame.getContentPane().add(textEditorPanel);
//        frame.pack();
//        frame.setLocationRelativeTo(this);  // Center the dialog relative to the CustomInterface frame
//        frame.setVisible(true);
//    }
    private ImageIcon resizeImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    private void addTextEditorPanel() {
        remove(recentPanel);
        add(textEditorPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
