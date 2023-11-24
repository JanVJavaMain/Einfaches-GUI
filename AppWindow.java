import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
//import javax.swing.JTextArea;
//import javax.swing.event.CaretEvent;
//import javax.swing.event.CaretListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;

public class AppWindow extends JFrame {
    JTextField textfield_dm, textfield_euro;
    JButton button;

    public AppWindow() {
        this.getContentPane().setLayout(null);
        this.initWindow();
        this.addWindowListener(new WindowListener() {
            public void windowClosing(WindowEvent e) { System.exit(1); }
            public void windowClosed(WindowEvent arg0) { }
            public void windowActivated(WindowEvent e) { }
            public void windowDeactivated(WindowEvent e) { }
            public void windowDeiconified(WindowEvent e) { }
            public void windowIconified(WindowEvent e) { }
            public void windowOpened(WindowEvent e) { }
        });
    }

    protected void initWindow() {
        textfield_dm = new JTextField();
        textfield_euro = new JTextField();

        button = new JButton("DM in Euro.");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                buttonBerechneClicked();
            }
        });

        textfield_dm.setBounds(5, 10, 400, 25);
        textfield_euro.setBounds(5, 80, 400, 25);

        button.setBounds(300, 110, 100, 30);

        this.getContentPane().add(textfield_dm);
        this.getContentPane().add(textfield_euro);
        this.getContentPane().add(button);

        this.pack();
    }

    public void buttonBerechneClicked() {
        double dm = 0;
        try {
            dm = Double.parseDouble(textfield_dm.getText());
        } catch (Exception e) {
            dm = -1;
        }
        if (dm >= 0) {
            double euro = this.dm2euro(dm);

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);

            String ausgabe = nf.format(euro);

            textfield_dm.setText(ausgabe);
        } else {
            textfield_euro.setText("Einagbe ist nicht in Ordnung.");
        }
    }

    public double dm2euro(double dm) {
        double euro = (dm / 1.95583);
        
        return euro;
    }
}