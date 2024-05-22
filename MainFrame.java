import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Main Frame");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

  /*       // Create buttons to open different windows
        JButton window1Button = new JButton("Open Window 1");
        window1Button.addActionListener(e -> openWindow("Window 1"));
        JButton window2Button = new JButton("Open Window 2");
        window2Button.addActionListener(e -> openWindow("Window 2"));

        // Add buttons to main panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(window1Button);
        buttonPanel.add(window2Button);
        mainPanel.add(buttonPanel, BorderLayout.NORTH); */

        setVisible(true);
    }

    private void openWindow(String windowName) {
        JFrame newFrame = new JFrame(windowName);
        newFrame.setSize(300, 200);
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}