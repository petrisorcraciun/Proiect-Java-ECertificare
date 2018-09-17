package proiectpoo.pkg1;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class GenerareCertificat extends JFrame {

    private JTextArea t;
    private JButton b1, b2;

    public GenerareCertificat(ArrayList<Cursanti> Student , int index) {
        setLayout(new FlowLayout());
        JPanel p0 = new JPanel(new BorderLayout());
        b1 = new JButton("Printeaza");
        b2 = new JButton("Salveaza");
        t = new JTextArea(29, 40);
        t.setEditable(false);
        
        
        t.append("-----------------------------------------------------------\n");
        t.append("--------------   E-Certificate JAVA 2018    -------\n");
        t.append("----------------------------------------------------------\n");
        t.append("\n");
        t.append("\nNume:" + Student.get(index).nume);
        t.append("\nPrenume: " + Student.get(index).prenume);
        t.append("\nEmail:" + Student.get(index).email);
        t.append("\nTelefon:" + Student.get(index).telefon);
        t.append("\t\nAti finalizat parcurgerea acestei platforme cu un punctaj de " + Student.get(index).punctaj + " puncte.");
        t.append("\n");
        t.append("----------------------------------------------------------\n ");
        t.append("-------- Felicitari ati finalizat E-Certificate ----\n ");
        t.append("----------------------------------------------------------\n ");
        
        
            JPanel p1 = new JPanel(new FlowLayout());
            JPanel p2 = new JPanel(new GridLayout(1, 2, 10, 10));

            p1.add(t);
            p2.add(b1);
            p2.add(b2);
            p0.add(p1, BorderLayout.CENTER);
            p0.add(p2, BorderLayout.SOUTH);

            this.add(p0);
            setSize(500, 550);
            setVisible(true);
            setTitle("Generare certificat / e-Certificate JAVA ");
    }
}
    