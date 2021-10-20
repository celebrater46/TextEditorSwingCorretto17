import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyForm extends JFrame {
    private JPanel panel1;
    private JButton button1;
    private JLabel label1;

    public MyForm() {
        button1.addMouseListener(new MouseAdapter() {
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
