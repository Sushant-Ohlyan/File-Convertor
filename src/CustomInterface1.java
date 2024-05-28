import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomInterface1 extends JFrame {
    private JPanel recentPanel;
    private TextEditor textEditorPanel;

    public CustomInterface1() {
        // Set up the frame
        setTitle("Custom Interface");
        setSize(1000, 800);
        setLocationRelativeTo(null);  // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the custom icon for the frame
        setIconImage(new ImageIcon(getClass().getResource("/icon.jpg")).getImage());

        // Set the layout
        setLayout(new BorderLayout());

        // Create the top panel with buttons
        JPanel topPanel = createTopPanel();

        // Create the recent panel
        recentPanel = new JPanel();
        recentPanel.setLayout(new BorderLayout());
        recentPanel.setBorder(BorderFactory.createTitledBorder("Recent from the latest to oldest"));

        JTextArea recentTextArea = new JTextArea();
        recentTextArea.setEditable(false);
        recentPanel.add(new JScrollPane(recentTextArea), BorderLayout.CENTER);

        // Add panels to frame
        add(topPanel, BorderLayout.NORTH);
        add(recentPanel, BorderLayout.CENTER);
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 10, 10));

        // Create buttons with images
        JButton newButton = new JButton("New", resizeImage("/newfile.png", 100, 100));
        JButton openButton = new JButton("Open", resizeImage("/open.png", 100, 100));
        JButton mostRecentButton = new JButton("Most recent");

        // Add buttons to panel
        panel.add(newButton);
        panel.add(openButton);
        panel.add(mostRecentButton);

        // Button actions
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTextEditor();
            }
        });
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenDialogue.showDialog(CustomInterface1.this);
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

    private ImageIcon resizeImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void openTextEditor() {
        // Create a new instance of TextEditor panel
        if (textEditorPanel == null) {
            textEditorPanel = new TextEditor();
        }

        // Show the TextEditor panel in a dialog
        JDialog dialog = new JDialog(this, "Text Editor", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.getContentPane().add(textEditorPanel.getContentPane());
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CustomInterface1().setVisible(true);
            }
        });
    }
}
