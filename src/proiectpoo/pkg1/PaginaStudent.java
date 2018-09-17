package proiectpoo.pkg1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.LinkedList;
import java.util.TreeSet;

public class PaginaStudent extends JFrame {

   
    private JButton b1, b2, b3, b4, b5, b6;
    private JPanel incepe, cursuri, certificat, test;
    private JLabel nume, prenume, email, tnume, tprenume, tuser, user, telefon,parola;
    private JTextField temail, ttelefon;
    private JTextField tparola;
    private PaginaLogin login;
    int pagina;

    public PaginaStudent(ArrayList<Cursanti> Student, int index) {

        setLayout(new BorderLayout());
        JPanel pmeniu = new JPanel(new FlowLayout());
        b1 = new JButton("Profilul meu");
        b2 = new JButton("Pagina teste");
        b3 = new JButton("Pagina cursuri");
        b4 = new JButton("Pagina examen");
        b6 = new JButton("Iesire Cont");
        pmeniu.add(b1);
        pmeniu.add(b2);
        pmeniu.add(b3);
        pmeniu.add(b4);
        pmeniu.add(b6);
        pmeniu.setBorder(new TitledBorder("Bun venit," + Student.get(index).nume + " " + Student.get(index).prenume));
        this.add(pmeniu, BorderLayout.PAGE_START);

        test = new JPanel(new FlowLayout());
        
        JPanel n0 = new JPanel(new GridLayout(1, 2, 20, 20));
        JPanel p00 = new JPanel(new BorderLayout());
        JPanel p0 = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(6, 1, 10, 10));
        user = new JLabel(" User:");
        nume = new JLabel(" Nume:");
        prenume = new JLabel(" Prenume:");
        parola = new JLabel("Parola:");
        email = new JLabel(" Email:");
        telefon = new JLabel(" Telefon:");
        p1.add(user);
        p1.add(nume);
        p1.add(prenume);
        p1.add(parola);
        p1.add(email);
        p1.add(telefon);
        JPanel p2 = new JPanel(new GridLayout(6, 1, 10, 10));
        tuser = new JLabel();
        tnume = new JLabel();
        tprenume = new JLabel();
        tparola = new JTextField(17);
        temail = new JTextField(17);
        ttelefon = new JTextField(17);
        p2.add(tuser);
        p2.add(tnume);
        p2.add(tprenume);

        tuser.setText(Student.get(index).user);
        tnume.setText(Student.get(index).nume);
        tprenume.setText(Student.get(index).prenume);
        tparola.setText(Student.get(index).parola);
        temail.setText(Student.get(index).email);
        ttelefon.setText(Student.get(index).telefon);

        JPanel jparola = new JPanel(new BorderLayout());
        jparola.add(tparola, BorderLayout.LINE_START);
        p2.add(jparola);
        JPanel jemail = new JPanel(new BorderLayout());
        jemail.add(temail, BorderLayout.LINE_START);
        p2.add(jemail);
        JPanel jtelefon = new JPanel(new BorderLayout());
        jtelefon.add(ttelefon, BorderLayout.CENTER);
        p2.add(jtelefon);
   

        p0.add(p1, BorderLayout.LINE_START);
        p0.add(p2, BorderLayout.CENTER);
        
        p00.add(p0, BorderLayout.PAGE_START);
        JPanel lmodifica = new JPanel(new FlowLayout());
        JButton modifica = new JButton("Salveaza date!");
        lmodifica.add(modifica);
        p00.add(lmodifica,BorderLayout.CENTER);

        p00.setBorder(new TitledBorder("Detalii cont:"));
 
        test.add(p00, BorderLayout.LINE_START);
        this.add(test,BorderLayout.LINE_START);

        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                salveazaDate(Student);
                test.removeAll();
                test.revalidate();
                test.repaint();
                test.add(p00, BorderLayout.LINE_START);
                test.revalidate();
                test.repaint();
            }
        });
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                salveazaDate(Student);
                test.removeAll();
                test.revalidate();
                test.repaint();
                incepe = new Teste(Student, index);
                JPanel p4 = new JPanel(new BorderLayout());
                p4.add(incepe, BorderLayout.LINE_START);
                test.add(p4);
                test.revalidate();
                test.repaint();
            }
        });
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                salveazaDate(Student);
                test.removeAll();
                test.revalidate();
                test.repaint();
                cursuri = new Cursuri(Student, index);
                JPanel p5 = new JPanel(new BorderLayout());
                p5.add(cursuri, BorderLayout.LINE_START);
                test.add(p5);
                test.revalidate();
                test.repaint();

            }
        });
        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                    
                test.removeAll();
                test.revalidate();
                test.repaint();
                certificat = new Certificat(Student, index);
                test.add(certificat, BorderLayout.CENTER);
                test.revalidate();
                test.repaint();
                salveazaDate(Student);

            }
        });
        b6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                new PaginaLogin();
                dispose();
            }
        });
        modifica.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                Student.get(index).setParola(tparola.getText());
                Student.get(index).setEmail(temail.getText());
                Student.get(index).setTelefon(ttelefon.getText());
                JOptionPane.showMessageDialog(null, "Datele au fost salvate cu succes!");
            }
        });

        setTitle("e-Certificate JAVA");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void salveazaDate(ArrayList<Cursanti> Student) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Date\\Conturi.txt"))) {
            for (int i = 0; i < Student.size(); i++) {
                bw.write(Student.get(i).id + " ");
                bw.write(Student.get(i).user + " ");
                bw.write(Student.get(i).parola + " ");
                bw.write(Student.get(i).nume + " ");
                bw.write(Student.get(i).prenume + " ");
                bw.write(Student.get(i).email + " ");
                bw.write(Student.get(i).telefon + " ");
                bw.write(Student.get(i).teste + " ");
                bw.write(Student.get(i).punctaj + " ");
                bw.write(Student.get(i).cursuri + " ");
                bw.write(Student.get(i).acces + " ");
                bw.newLine();

            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
