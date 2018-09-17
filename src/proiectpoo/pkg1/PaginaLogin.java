package proiectpoo.pkg1;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.FileNotFoundException;
import static java.lang.System.in;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.LinkedList;

public class PaginaLogin extends JFrame {

    ArrayList<Cursanti> llist = new ArrayList<Cursanti>();
    private JTextField nume;
    private JPasswordField parola;
    private JButton logare;
    private JPanel p0, p1, p2, p3, p4, p5;
    private JLabel l1, l2, l3, l4, l5;
    public PaginaLogin() {
        setLayout(new BorderLayout());
        p0 = new JPanel(new BorderLayout());
        p4 = new JPanel(new FlowLayout());
        p5 = new JPanel(new BorderLayout());
        ImageIcon image = new ImageIcon("icon\\java.png");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        this.add(label, BorderLayout.PAGE_START);

        p1 = new JPanel(new GridLayout(2, 1, 15, 15));
        l1 = new JLabel("Nume:");
        l1.setFont(new Font("Century Gothic", Font.BOLD, 15));
        l2 = new JLabel("Parola:");
        l2.setFont(new Font("Century Gothic", Font.BOLD, 15));
        p1.add(l1);
        p1.add(l2);
        nume = new JTextField(20);

        p2 = new JPanel(new GridLayout(2, 1, 15, 15));
        nume = new JTextField(20);
        parola = new JPasswordField(20);
        p2.add(nume);
        p2.add(parola);
        // *************
        p0.add(p1, BorderLayout.LINE_START);
        p0.add(p2, BorderLayout.CENTER);
        p4.add(p0);
        p3 = new JPanel(new FlowLayout());
        logare = new JButton("Logare");
        p3.add(logare);
        p5.add(p4, BorderLayout.PAGE_START);
        p5.add(p3, BorderLayout.CENTER);

        this.add(p5, BorderLayout.CENTER);

        // *****************************************
        
        String line;
        try {
            BufferedReader bfw = new BufferedReader(new FileReader("Date\\Conturi.txt"));
            while ((line = bfw.readLine()) != null) {
                String[] s = line.split(" ");
                Cursanti elevi = new Cursanti(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4], s[5], s[6],
                        Integer.parseInt(s[7]), Integer.parseInt(s[8]), Integer.parseInt(s[9]), Integer.parseInt(s[10]));
                llist.add(elevi);

            }
            bfw.close();
        } catch (Exception ex) {
            
        }
          
    
        
       
        
        
        // *******************************************
        logare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                String citirenume = nume.getText();
                String citireparola = parola.getText();
                int i = 0, indexnume = 0;
                indexnume = llist.indexOf(citirenume);
                int k = 0;
                for (int j = 0; j < llist.size(); j++) {
                    if (citirenume.equals(llist.get(j).user))
                            {
                                 k=j;
                            }
                }
                
                    if (citirenume.equals(llist.get(k).user) && citireparola.equals(llist.get(k).parola)) {
                        if (llist.get(k).acces == 1) {
                            new PaginaAdmin(llist);
                            dispose();

                        } else if (llist.get(k).acces == 0) {
                            new PaginaStudent(llist, k);
                            dispose();
                        } 
 
                    }
                    else {
                    JOptionPane.showMessageDialog(null, "Detalii de acces incorecte. Va rugam sa incercati din nou.");
                    nume.setText("");
                    parola.setText("");
                    nume.requestFocus();
                }
                  
                  
            }
        });

        setTitle("e-Certificate JAVA");
        setSize(300, 230);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public int verificare(LinkedList<Cursanti> llist , String nume)
    {
        for (int j = 0; j < llist.size(); j++) {
                    if (nume.equals(llist.get(j).user))
                            {
                                 return j;
                            }
                }
        return 0;
    }

}
