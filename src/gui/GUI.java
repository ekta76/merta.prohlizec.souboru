package gui;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class GUI extends JFrame {
    private JButton openFile;
    private JTextArea text;
    private JPanel panel;

    private final JFileChooser jFileChooser = new JFileChooser(".");

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setContentPane(gui.panel);
        gui.setBounds(700, 300, 500, 500);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public GUI() {
        openFile.addActionListener(e -> fileChooser());
        initComponents();
    }

    private void loadData (File file) {
        List<String> data = Reader.readData(file);
        data.forEach(t -> text.append(t + "\n"));
    }

    private void fileChooser() {
        int result = jFileChooser.showOpenDialog(this);

        if (result == JFileChooser.ERROR_OPTION) {
            JOptionPane.showMessageDialog(null, "Špatný soubor");
            return;
        }

        loadData(jFileChooser.getSelectedFile());
    }

    private void initComponents() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu menu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(e -> fileChooser());

        menu.add(openItem);

        jMenuBar.add(menu);
        setJMenuBar(jMenuBar);
    }
}
