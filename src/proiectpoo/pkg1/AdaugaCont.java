package proiectpoo.pkg1;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class AdaugaCont extends JFrame {

    private JButton b1, b2;
    private JLabel nume, prenume, user, telefon, email, parola, mesaj1, mesaj2, nrid, tnrid,lacces;
    private JTextField tnume, tprenume, tuser, ttelefon, temail;
    private JPasswordField tparola;
    private int k = 0;
    String[] tipacces = { "Student" , "Admin"};
    final JComboBox acces = new JComboBox(tipacces);
    int idacces;

    public AdaugaCont(ArrayList<Cursanti> Student) {
        setLayout(new FlowLayout());
        JPanel p0 = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new GridLayout(8, 2, 10, 10));
        JPanel p3 = new JPanel(new FlowLayout());
        JPanel p4 = new JPanel(new FlowLayout());

        b1 = new JButton("Creare Cont");
        b2 = new JButton("Pagina Admin");
        nrid = new JLabel("ID cont:");
        tnrid = new JLabel();
        nume = new JLabel("Nume:");
        tnume = new JTextField(15);
        prenume = new JLabel("Prenume:");
        tprenume = new JTextField(15);
        user = new JLabel("User unic:");
        tuser = new JTextField(15);
        telefon = new JLabel("Telefon:");
        ttelefon = new JTextField(15);
        email = new JLabel("Email:");
        temail = new JTextField(15);
        parola = new JLabel("Parola:");
        tparola = new JPasswordField(15);
        mesaj1 = new JLabel("Adaugare cont E-Certificare Java");
        mesaj2 = new JLabel("Toate campurile sunt obligatorii!");
        lacces = new JLabel("Tip acces:");

        p1.add(mesaj1);
        p2.add(nrid);
        p2.add(tnrid);
        p2.add(user);
        p2.add(tuser);
        p2.add(parola);
        p2.add(tparola);
        p2.add(nume);
        p2.add(tnume);
        p2.add(prenume);
        p2.add(tprenume);
        p2.add(telefon);
        p2.add(ttelefon);
        p2.add(email);
        p2.add(temail);
        p2.add(lacces);
        p2.add(acces);
        p3.add(b1);
        p4.add(mesaj2);

        p0.add(p1, BorderLayout.NORTH);
        p0.add(p2, BorderLayout.CENTER);
        p0.add(p3, BorderLayout.SOUTH);

        this.add(p0);
        this.add(p4);

        for (int i = 0; i < Student.size(); i++) {
            if (Student.get(i).id > k) {
                k = Student.get(i).id;
            }
        }
        k++;
        tnrid.setText(String.valueOf(k));

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (tuser.getText().length() == 0 || tnume.getText().length() == 0 || tprenume.getText().length() == 0 || tparola.getText().length() == 0
                        || temail.getText().length() == 0 || ttelefon.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Toate campurile sunt obligatorii.");
                } 
                else 
                {

                }
                int verifica = Student.indexOf(tuser.getText());
                if(verifica == -1)
                {
                  JOptionPane.showMessageDialog(null, "Exista un cont cu acest user!");    
                }
                else 
                {
                Cursanti elevi = new Cursanti(k, tuser.getText(), tparola.getText(), tnume.getText(), tprenume.getText(), temail.getText(),
                ttelefon.getText(), 0, 0, 0, acces.getSelectedIndex() );
                Student.add(elevi);
                JOptionPane.showMessageDialog(null, "Contul a fost adaugat cu succes!");
                }
                
                
                dispose();
                
                
            }

        }
    

    );

    setTitle("e-Certificate JAVA");
    setSize(370, 370);
    setVisible(true);
    setResizable(false);

    }
}
