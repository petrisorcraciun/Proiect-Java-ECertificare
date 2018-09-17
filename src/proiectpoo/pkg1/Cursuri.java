package proiectpoo.pkg1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

public final class Cursuri extends JPanel {

    JTable tabel;
    DefaultTableModel tabelcursuri;
    private JLabel total, ramas, punctaj, disponibil, ltotal, lramas, lpunctaj, ldisponibil;
    private int nrcursuri = 5;
    public Cursuri(ArrayList<Cursanti> Student, int index) {

        setLayout(new BorderLayout());
        JPanel pt = new JPanel(new BorderLayout());
        JPanel p0 = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(3, 1, 10, 10));
        total = new JLabel("Nr cursuri parcurse:");
        ramas = new JLabel("Nr cursuri ramase:");
        punctaj = new JLabel("Punctaj total:");
        p1.add(total);
        p1.add(ramas);
        p1.add(punctaj);


        JPanel p2 = new JPanel(new GridLayout(3, 1, 10, 10));
        ltotal = new JLabel();
        lramas = new JLabel();
        lpunctaj = new JLabel();

        p2.add(ltotal);
        p2.add(lramas);
        p2.add(lpunctaj);
    

        ltotal.setText(String.valueOf(Student.get(index).cursuri));
        lramas.setText(String.valueOf(getRamas(Student.get(index).cursuri)));
        lpunctaj.setText(String.valueOf(Student.get(index).punctaj));

        p0.add(p1, BorderLayout.LINE_START);
        p0.add(p2, BorderLayout.CENTER);

        JPanel p3 = new JPanel(new BorderLayout());
        p3.add(p0, BorderLayout.LINE_START);
        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p3, BorderLayout.LINE_START);

        pt.add(p0, BorderLayout.PAGE_START);
        this.add(pt, BorderLayout.PAGE_START);

 
        tabel = new JTable();
        tabelcursuri = (DefaultTableModel) tabel.getModel();
        JPanel ptabel = new JPanel(new BorderLayout());
        JPanel meniu = new JPanel(new FlowLayout());
        String[] columns = new String[]{
            "Cursuri disponibile", "Stare"
        };
        tabelcursuri.setColumnIdentifiers(columns);
        Object[] data = new Object[5];
        for (int j = 1; j <= nrcursuri; j++) {
            for (int i = 1; i <= Student.get(index).cursuri; i++) {
                if (i <= Student.get(index).cursuri) {
                    data[0] = "Cursul nr " + j;
                    data[1] = true;
                }
            }
            if (j > Student.get(index).cursuri) {
                    data[0] = "Cursul nr " + j;
                    data[1] = false;
                }
           tabelcursuri.addRow(data);
        }
        tabel.setEnabled(false);
        tabel.setRowHeight(20);
        tabel.getTableHeader().setReorderingAllowed(false);
        JScrollPane stabel = new JScrollPane(tabel);
        stabel.setPreferredSize(new Dimension(675, 170));
        meniu.add(stabel);

        ptabel.add(meniu, BorderLayout.LINE_START);
        this.add(ptabel, BorderLayout.CENTER);

        
        JButton incepe = new JButton("Incepe curs");
        JPanel butoane = new JPanel(new FlowLayout());
        butoane.add(incepe);
        this.add(butoane, BorderLayout.PAGE_END);
        
        incepe.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                new CitesteCurs(Student,index);

            }
        });

        setSize(700, 400);
        setVisible(true);
    }

    public int getRamas(int nr) {
        nr = 5 - nr;
        return nr;
    }


}
