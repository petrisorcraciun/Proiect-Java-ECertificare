package proiectpoo.pkg1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.LinkedList;

public class Certificat extends JPanel {

    private JTextArea t;
    private JButton b1, b2;
    private JLabel mesaj, mesaj1;
    private JButton genereaza;
    private JButton h1;
    private JLabel n1, n2;

    public Certificat(ArrayList<Cursanti> Student, int index) {
        setLayout(new FlowLayout());
        JPanel yo = new JPanel(new BorderLayout());
        mesaj = new JLabel(" Nu ati finalizat sesiune de pregatire E-Certificate JAVA!");
        mesaj.setFont(new Font("Serif", Font.PLAIN, 30));
        JPanel y1 = new JPanel(new FlowLayout());
        JPanel y2 = new JPanel(new GridLayout(2, 1, 10, 10));
        y2.add(mesaj);
        yo.add(y2, BorderLayout.CENTER);
        yo.add(y1, BorderLayout.SOUTH);
        this.add(yo);
        
        JPanel x0 = new JPanel(new BorderLayout());
        genereaza = new JButton("Genereaza Certificat");
        mesaj = new JLabel("  Felicitari ati terminat cu succes E-Certificate JAVA!");

        mesaj.setFont(new Font("Serif", Font.PLAIN, 30));
        JPanel x1 = new JPanel(new FlowLayout());
        JPanel x2 = new JPanel(new GridLayout(2, 1, 10, 10));
        x2.add(mesaj);
        x1.add(genereaza);

        x0.add(x2, BorderLayout.CENTER);
        x0.add(x1, BorderLayout.SOUTH);
        this.add(x0);
        
        if(Student.get(index).teste == 10)
        {
            x0.setVisible(true);
            yo.setVisible(false);
        }
        else 
        {
            yo.setVisible(true);
            x0.setVisible(false);
        }
        genereaza.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent evt) {
             
           new GenerareCertificat(Student,index);
             
         }
      });

        setVisible(true);

    }
}
