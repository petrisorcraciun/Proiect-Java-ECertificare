package proiectpoo.pkg1;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Teste extends JPanel {
    private JLabel total, ramas, punctaj, disponibil, ltotal, lramas, lpunctaj, ldisponibil;
    private JButton a, b, c, d;
    private JLabel a1, b1, c1, d1;
    DefaultTableModel tabelteste;
    private int nrteste = 10;
    

    public Teste(ArrayList<Cursanti> Student , int index) {

        setLayout(new BorderLayout());
        JPanel pn = new JPanel(new BorderLayout());
        JPanel pf = new JPanel(new BorderLayout());
        JPanel pt = new JPanel(new BorderLayout());
        JPanel p0 = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(3, 1, 10, 10));
        total = new JLabel(" Nr teste parcurse:");
        ramas = new JLabel(" Nr teste ramase:");
        punctaj = new JLabel(" Punctaj total:");
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
        
        
        ltotal.setText(String.valueOf(Student.get(index).teste));
        lramas.setText(String.valueOf(getRamas(Student.get(index).teste)));
        lpunctaj.setText(String.valueOf(Student.get(index).punctaj));

        p0.add(p1, BorderLayout.LINE_START);
        p0.add(p2, BorderLayout.CENTER);

  
        JPanel p3 = new JPanel(new BorderLayout());
        p3.add(p0, BorderLayout.LINE_START);
        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p3, BorderLayout.LINE_START);

        pt.add(p0, BorderLayout.PAGE_START);
        pf.add(pt, BorderLayout.PAGE_START);
        this.add(pf);

        JPanel ptabel = new JPanel(new BorderLayout());
        JPanel meniu = new JPanel(new FlowLayout());
        String[] columns = new String[]{
            "Test", "Stare test"
        };
        
        JTable tabel = new JTable();
        tabel.repaint();
        tabelteste = (DefaultTableModel) tabel.getModel();
        tabelteste.setColumnIdentifiers(columns);
        tabel.setEnabled(false);
        Object[] data = new Object[5];
        for (int j = 1; j <= nrteste; j++) {
            for (int i = 1; i <= Student.get(index).teste; i++) {
                if (i <= Student.get(index).teste) {
                    data[0] = "Testul nr " + j;
                    data[1] = true;
                }
            }
            if (j > Student.get(index).teste) {
                    data[0] = "Testul nr " + j;
                    data[1] = false;
                }
           tabelteste.addRow(data);
        }
        tabel.setRowHeight(20);
        tabel.getTableHeader().setReorderingAllowed(false);
        JScrollPane stabel = new JScrollPane(tabel);
        stabel.setPreferredSize(new Dimension(675, 170));
        meniu.add(stabel);

        ptabel.add(meniu, BorderLayout.LINE_START);
        pf.add(ptabel, BorderLayout.CENTER);
       
        this.add(pf);

        

      
        JButton incepe = new JButton("Incepe test");
        JPanel butoane = new JPanel(new FlowLayout());
        butoane.add(incepe);
        this.add(butoane, BorderLayout.PAGE_END);

        incepe.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if(Student.get(index).teste<10)
                {
                    new IncepeTest(Student,index);
                }
                else if(Student.get(index).teste == 10)
                {
                     JOptionPane.showMessageDialog(null, "Se pare ca ati terminat cu succes toate testele." , "Felicitari !!" , JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        });

        setSize(700, 500);
        setVisible(true);
    }
    public int getRamas(int nr)
    {
        nr=10-nr;
        return nr;
        
    }
    public int getPunctaj(int nr)
    {
        nr=nr*10;
        return nr;
    }
}
