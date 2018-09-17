package proiectpoo.pkg1;

import java.util.LinkedList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class IncepeTest extends JFrame {

    JLabel text;
    LinkedList<String> datetest = new LinkedList<String>();
    private JButton a, b, c, d;
    private JLabel a1, b1, c1, d1, intrebare;
    int i = 0, puncte = 0, index = 0, student;
    ArrayList<ListaTeste> LT = new ArrayList<ListaTeste>();
    String raspuns = "nu";

    public IncepeTest(ArrayList<Cursanti> Student, int nr) {

        String line;
        student = nr;
        nr = Student.get(nr).teste;
        nr++;
        String ca = "Test " + nr;
        try {
            BufferedReader bfw = new BufferedReader(new FileReader("Date\\Teste.txt"));
            while ((line = bfw.readLine()) != null) {
                String[] s = line.split(",");
                if (s[0].equals(ca)) {
                    ListaTeste teste = new ListaTeste(s[0], s[1], s[2], s[3], s[4], s[5], s[6]);
                    LT.add(teste);
                }

            }
            bfw.close();
        } catch (Exception ex) {

        }
        

        text = new JLabel();
        this.add(text);
        setLayout(new BorderLayout());
        JPanel incepetest = new JPanel(new BorderLayout());
        JPanel tn = new JPanel(new BorderLayout()); 
        JPanel t = new JPanel(new BorderLayout()); 
        JPanel t0 = new JPanel(new FlowLayout());
        JPanel t1 = new JPanel(new FlowLayout()); 
        JPanel tt = new JPanel(new FlowLayout()); 
        JPanel tp = new JPanel(new FlowLayout());

        JPanel sustot = new JPanel(new BorderLayout());
        JPanel sus0 = new JPanel(new BorderLayout());
        JPanel suss = new JPanel(new BorderLayout());
        JPanel susd = new JPanel(new BorderLayout());
        JPanel sust = new JPanel(new FlowLayout());
        intrebare = new JLabel();
        suss.add(intrebare, BorderLayout.LINE_START);
        JPanel dreapta = new JPanel(new BorderLayout());
        JLabel intrebaricorecte = new JLabel();
        JLabel punctaj = new JLabel();
        sust.add(intrebaricorecte);
        sust.add(punctaj);
        susd.add(sust, BorderLayout.CENTER);
        sustot.add(suss, BorderLayout.LINE_START);
        sustot.add(susd, BorderLayout.LINE_END);

        JPanel sus2 = new JPanel(new BorderLayout());
        JPanel sus3 = new JPanel(new FlowLayout());
        JPanel raspunsuri = new JPanel(new GridLayout(4, 1, 10, 10));
        a1 = new JLabel();
        b1 = new JLabel();
        c1 = new JLabel();
        d1 = new JLabel();
        raspunsuri.add(a1);
        raspunsuri.add(b1);
        raspunsuri.add(c1);
        raspunsuri.add(d1);
        sus3.add(raspunsuri);
        sus2.add(sus3, BorderLayout.LINE_START);

        sus0.add(sustot, BorderLayout.PAGE_START);
        sus0.add(sus2, BorderLayout.CENTER);
        //       

        JPanel sus4 = new JPanel(new BorderLayout());
        JPanel butoane = new JPanel(new GridLayout(1, 4, 10, 10));
        a = new JButton("A");
        b = new JButton("B");
        c = new JButton("C");
        d = new JButton("D");
        butoane.add(a);
        butoane.add(b);
        butoane.add(c);
        butoane.add(d);
        sus4.add(butoane, BorderLayout.PAGE_START);

        JPanel butoanej = new JPanel(new FlowLayout());
        JLabel spatiu = new JLabel("");
        butoanej.add(spatiu);
        JButton trimite = new JButton("Trimite");
        butoanej.add(trimite);
        JButton stergeraspuns = new JButton("Sterge raspuns");
        butoanej.add(stergeraspuns);
        JButton renunta = new JButton("Renunta");
        butoanej.add(renunta);
        sus4.add(butoanej, BorderLayout.CENTER);

        this.add(sus0, BorderLayout.PAGE_START);
        this.add(sus4, BorderLayout.PAGE_END);

        intrebaricorecte.setText("Corecte: " + index);
        punctaj.setText("Punctaj: " + puncte);

        intrebari(i);

        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                raspuns = "a";
                a.setBackground(Color.YELLOW);
                a.setOpaque(true);
                b.setBackground(null);
                c.setBackground(null);
                d.setBackground(null);
            }
        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                raspuns = "b";
                a.setBackground(null);
                b.setOpaque(true);
                b.setBackground(Color.YELLOW);
                c.setBackground(null);
                d.setBackground(null);
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                raspuns = "c";
                a.setBackground(null);
                c.setOpaque(true);
                b.setBackground(null);
                c.setBackground(Color.YELLOW);
                d.setBackground(null);
            }
        });
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                raspuns = "d";
                a.setBackground(null);
                d.setOpaque(true);
                b.setBackground(null);
                c.setBackground(null);
                d.setBackground(Color.YELLOW);
            }
        });
        trimite.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                
                if (i < 5 && raspuns.equals(LT.get(i).rcorect)) {
                    gresit();
                    index++;
                    puncte +=20;
                    intrebaricorecte.setText("Corecte: " + index);
                    punctaj.setText("Punctaj: " + getPuncte(puncte));
                    raspuns = "nu";

                } else if (puncte > 50 && i == 5) {
                    JOptionPane.showMessageDialog(null, "Felicitari! Ati promovat acest test cu " + getPuncte(puncte) + " puncte");
                    int n = JOptionPane.showConfirmDialog(null, "Doriti sa salvati punctajul obtinut?", "Salvare punctaj", JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        Student.get(student).setPunctaj(Student.get(student).punctaj + 10);
                        Student.get(student).setTeste(Student.get(student).teste + 1);
                    }
                    dispose();
                } else if (puncte < 50 && i == 5) {
                    JOptionPane.showMessageDialog(null, "Se pare ca nu ati promovat acest test! Ati obtinut" + getPuncte(puncte) + " puncte");
                } else if (i < 5 && raspuns != LT.get(i).rcorect && raspuns != "nu") {

                    gresit();
                    JOptionPane.showMessageDialog(null, "Raspuns Gresit!Raspunsul corect era: " + LT.get(i).rcorect);
                    raspuns = "nu";
                } else if (i < 5 && raspuns.equals("nu")) {
                    gresit();
                    JOptionPane.showMessageDialog(null, "Este necesara alegerea unui raspuns. ");
                }
                i++;
                intrebari(i);

            }

        });
        stergeraspuns.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                a.setBackground(null);
                b.setBackground(null);
                c.setBackground(null);
                d.setBackground(null);
            }
        });

        setSize(600, 350);
        setVisible(true);

    }

    public void intrebari(int i) {

        intrebare.setText("  Intrebare: " + LT.get(i).intrebare);
        a1.setText("A. " + LT.get(i).r1);
        b1.setText("B. " + LT.get(i).r2);
        c1.setText("C. " + LT.get(i).r3);
        d1.setText("D. " + LT.get(i).r4);

    }
     public int getPuncte(int puncte) {
        return puncte;
    }

   

    public void gresit() {

        a.setBackground(null);
        b.setBackground(null);
        c.setBackground(null);
        d.setBackground(null);
    }

}
