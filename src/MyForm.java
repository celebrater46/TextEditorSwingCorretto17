import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

// For Test
public class MyForm extends JFrame {
    private JPanel panel1;
    private JLabel label1;
    private JButton buttonRead;
    private JButton buttonWrite;
    private JTextArea textArea1;
    private JScrollPane scrollPane1;

    public static void main(String[] args) {
        MyForm myForm1 = new MyForm();
    }

    public MyForm() {
        super("Text Editor");

        label1 = new JLabel("Choose your file.");
        buttonRead = new JButton("Read");
        buttonWrite = new JButton("Write");
        textArea1 = new JTextArea();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();

        panel1.add(buttonRead);
        panel1.add(buttonWrite);

        add(label1, BorderLayout.NORTH);
        add(scrollPane1, BorderLayout.CENTER);
        add(panel1, BorderLayout.SOUTH);

        buttonRead.addActionListener(new buttonActionListener());
        buttonWrite.addActionListener(new buttonActionListener());
        addWindowListener(new WindowListener());
        setSize(400, 300);
        setVisible(true);

//        buttonRead.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                label1.setText("Hello World");
//            }
//        });
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setContentPane(panel1);
//        pack();
//        setVisible(true);
    }

    class buttonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Container container = getContentPane();
            JFileChooser fileChooser = new JFileChooser();

            FileFilter filter = new FileNameExtensionFilter("Text File", "txt");
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
            fileChooser.addChoosableFileFilter(filter);
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int res;

            if(e.getSource() == buttonRead) {
                res = fileChooser.showOpenDialog(container);
            } else if(e.getSource() == buttonWrite) {
                res = fileChooser.showSaveDialog(container);
            } else {
                System.out.println("e.getSource is wrong");
                return;
            }

            if(res != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File file = fileChooser.getSelectedFile();

            try {
                if(e.getSource() == buttonRead) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    textArea1.read(bufferedReader, null);
                    bufferedReader.close();
                } else if(e.getSource() == buttonWrite) {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    textArea1.write(bufferedWriter);
                    bufferedWriter.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    class WindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
