package proiectpoo.pkg1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AdaugaTest extends JFrame {

    private JLabel nrintrebare, nrintrebare1, capitol, intrebare, r1, r2, r3, r4, rc;
    private JTextField tintrebare, tr1, tr2, tr3, tr4, trc;
    private JButton adauga;
    String[] teste = {"Test 1", "Test 2", "Test 3", "Test 4", "Test 5", "Test 6", "Test 7", "Test 8", "Test 9", "Test 10"};
    final JComboBox cteste = new JComboBox(teste);
    private static final String FILENAME = "Date\\Teste.txt";

    public AdaugaTest(ArrayList<ListaTeste> LT) {
        setLayout(new FlowLayout());
        JPanel p0 = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(10, 1, 10, 10));
        nrintrebare = new JLabel("Intrebarea cu nr:");
        p1.add(nrintrebare);
        capitol = new JLabel("Test:");
        intrebare = new JLabel(" Intrebare:");
        r1 = new JLabel(" Raspuns 1:");
        r2 = new JLabel(" Raspuns 2:");
        r3 = new JLabel(" Raspuns 3:");
        r4 = new JLabel(" Raspuns 4:");
        rc = new JLabel(" Raspuns corect(1-4):");
        p1.add(capitol);
        p1.add(intrebare);
        p1.add(r1);
        p1.add(r2);
        p1.add(r3);
        p1.add(r4);
        p1.add(rc);
        JPanel p2 = new JPanel(new GridLayout(10, 1, 10, 10));
        nrintrebare1 = new JLabel("0");
        p2.add(nrintrebare1);
        p2.add(cteste);
        tintrebare = new JTextField(10);
        tr1 = new JTextField(10);
        tr2 = new JTextField(10);
        tr3 = new JTextField(10);
        tr4 = new JTextField(10);
        trc = new JTextField(10);
        p2.add(tintrebare);
        p2.add(tr1);
        p2.add(tr2);
        p2.add(tr3);
        p2.add(tr4);
        p2.add(trc);

        p0.add(p1, BorderLayout.LINE_START);
        p0.add(p2, BorderLayout.CENTER);
        adauga = new JButton("Adauga intrebare");
        p0.add(adauga, BorderLayout.PAGE_END);
        this.add(p0);
        adauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (tintrebare.getText().length() == 0 || tr1.getText().length() == 0 || tr2.getText().length() == 0
                        || tr3.getText().length() == 0 || tr4.getText().length() == 0 || trc.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Toate campurile sunt obligatorii.");
                } else if (trc.getText().length() > 1) {
                    JOptionPane.showMessageDialog(null, "Poate fi adaugata doar litera corespunzatoare raspunsului corect!");
                }
                else 
                {
                ListaTeste teste = new ListaTeste(cteste.getSelectedItem().toString(), tintrebare.getText(), tr1.getText(), tr2.getText(), tr3.getText(),
                        tr4.getText(), trc.getText());
                LT.add(teste);
                salveazaDate(LT);
                JOptionPane.showMessageDialog(null, "Intrebare adaugata cu succes!"); 
                dispose();
                
                }
            }
        });

        setVisible(true);
        setTitle("e-Certificate JAVA");
        setSize(450, 450);
        setResizable(false);
    }

    public static void salveazaDate(ArrayList<ListaTeste> LT) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Date\\Teste.txt"))) {
            for (int i = 0; i < LT.size(); i++) {
                bw.write(LT.get(i).capitol + ",");
                bw.write(LT.get(i).intrebare + ",");
                bw.write(LT.get(i).r1 + ",");
                bw.write(LT.get(i).r2 + ",");
                bw.write(LT.get(i).r3 + ",");
                bw.write(LT.get(i).r4 + ",");
                bw.write(LT.get(i).rcorect + ",");
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
