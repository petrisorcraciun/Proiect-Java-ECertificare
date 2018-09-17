package proiectpoo.pkg1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TesteAdmin extends JPanel {

    private JTable tabel;
    private JScrollPane stabel;
    private JLabel nrintrebare, nrintrebare1, capitol, intrebare, r1, r2, r3, r4, rc;
    private JTextField tintrebare, tr1, tr2, tr3, tr4, trc;
    String[] capitole = {"Capitol 1", "Capitol 2", "Capitol 3", "Capitol 4", "Capitol 5"};
    final JComboBox capitole1 = new JComboBox(capitole);
    ArrayList<ListaTeste> LT = new ArrayList<ListaTeste>();
    DefaultTableModel LTeste;
    private JButton adauga,sterge,modifica;

    public TesteAdmin() {
        setLayout(new BorderLayout());
        String line;
        try {
            BufferedReader bfw = new BufferedReader(new FileReader("Date\\Teste.txt"));
            while ((line = bfw.readLine()) != null) {
                String[] s = line.split(",");
                ListaTeste teste = new ListaTeste(s[0], s[1], s[2], s[3], s[4], s[5], s[6]);
                LT.add(teste);

            }
            bfw.close();
        } catch (Exception ex) {
            
        }
        tabel = new JTable();
        LTeste = (DefaultTableModel) tabel.getModel();
        String[] columns = new String[]{
            "Capitol", "Intrebare", "Raspuns 1", "Raspuns 2", "Raspuns 3", "Raspuns 4", "Raspuns Corect"
        };
        LTeste.setColumnIdentifiers(columns);
        Object[] date = new Object[11];
        for (int i = 0; i < LT.size(); i++) {
            date[0] = LT.get(i).capitol;
            date[1] = LT.get(i).intrebare;
            date[2] = LT.get(i).r1;
            date[3] = LT.get(i).r2;
            date[4] = LT.get(i).r3;
            date[5] = LT.get(i).r4;
            date[6] = LT.get(i).rcorect;
            LTeste.addRow(date);
        }
        JScrollPane stabel = new JScrollPane(tabel);
        tabel.getTableHeader().setReorderingAllowed(false);
        stabel.setPreferredSize(new Dimension(775, 330));
        this.add(stabel, BorderLayout.PAGE_START);
        
        JPanel buton = new JPanel(new FlowLayout());
        JPanel butoane = new JPanel(new GridLayout(1,3,10,10));
        adauga = new JButton("Adauga intrebare");
        sterge = new JButton("Sterge intrebare");
        modifica = new JButton("Modifica intrebare");
        butoane.add(adauga);
        butoane.add(sterge);
        butoane.add(modifica);
        adauga.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                new AdaugaTest(LT);
                
            }
        });
        sterge.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                try {
                    int linieselectata = tabel.getSelectedRow();
                    LTeste.removeRow(linieselectata);
                    LT.remove(LT.get(linieselectata));
                    JOptionPane.showMessageDialog(null, "Intrebare stearsa cu succes!");
                    salveazaDate(LT);
                } catch (Exception ex) {

                }
                
            }
        });
        buton.add(butoane);
        this.add(buton, BorderLayout.CENTER);
        setVisible(true);
    }
    public void salveazaDate(ArrayList<ListaTeste> LT) {
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
