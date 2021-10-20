import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// For Test
public class MyForm extends JFrame {
    private JPanel panel1;
    private JLabel label1;
    private JButton buttonRead;
    private JButton buttonWrite;

    public MyForm() {
        buttonRead.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                label1.setText("Hello World");
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setVisible(true);
    }
}
