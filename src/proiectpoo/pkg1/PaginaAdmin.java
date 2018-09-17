package proiectpoo.pkg1;

import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PaginaAdmin extends JFrame {

    private JButton utilizatori, cursuri, teste;
    private JPanel pprincipal;
    private JButton b1, b2, b3, b4, b5, b6;
    private ListaCursanti listacursanti;
    JPanel test;

    public PaginaAdmin(ArrayList<Cursanti> Student) {
        setLayout(new BorderLayout());
        JPanel pmeniu = new JPanel(new FlowLayout());
        b1 = new JButton("Lista Studenti");
        b2 = new JButton("Pagina Teste");
        b3 = new JButton("Pagina Cursuri");
        b6 = new JButton("Iesire Cont");
        pmeniu.add(b1);
        pmeniu.add(b2);
        pmeniu.add(b3);
        pmeniu.add(b6);
        pmeniu.setBorder(new TitledBorder("Pagina Admin"));
        this.add(pmeniu, BorderLayout.PAGE_START);

        test = new JPanel(new FlowLayout());

        JPanel p2 = new JPanel(new BorderLayout());
        ListaCursanti pp = new ListaCursanti(Student);
        p2.add(pp, BorderLayout.LINE_START);
        test.add(p2);
        this.add(test);

        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                salveazaDate(Student);
                test.removeAll();
                test.revalidate();
                test.repaint();
                JPanel p2 = new JPanel(new BorderLayout());
                ListaCursanti pp = new ListaCursanti(Student);
                p2.add(pp, BorderLayout.LINE_START);
                test.add(p2);
                test.revalidate();
                test.repaint();

            }
        });
        this.add(test);
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                test.removeAll();
                test.revalidate();
                test.repaint();
                JPanel p3 = new JPanel(new BorderLayout());
                TesteAdmin pe = new TesteAdmin();
                p3.add(pe, BorderLayout.LINE_START);
                test.add(p3);
                test.revalidate();
                test.repaint();
            }
        });
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                test.removeAll();
                test.revalidate();
                test.repaint();
                JPanel p4 = new JPanel(new BorderLayout());
                CursuriAdmin po = new CursuriAdmin();
                p4.add(po, BorderLayout.LINE_START);
                test.add(p4);
                test.revalidate();
                test.repaint();
            }
        });
 
        b6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                new PaginaLogin();
                dispose();
            }
        });
        

        setTitle("e-Certificate JAVA");
        setSize(800, 500);
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
