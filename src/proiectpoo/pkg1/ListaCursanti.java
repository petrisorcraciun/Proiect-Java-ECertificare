package proiectpoo.pkg1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListaCursanti extends JPanel {

    private JTable tabel;
    DefaultTableModel listacursanti;
    private JButton adauga, sterge ,modifica;

    public ListaCursanti(ArrayList<Cursanti> Student) {

        setLayout(new BorderLayout());
        JPanel ptabel = new JPanel(new BorderLayout());
        tabel = new JTable();
        listacursanti = (DefaultTableModel) tabel.getModel();
        String[] columns = new String[]{
            "ID", "User", "Parola", "Nume", "Prenume", "Email", "Telefon", "Teste", "Puntaj", "Cursuri", "Acces"
        };
        listacursanti.setColumnIdentifiers(columns);

        Object[] lista = new Object[11];
        for (int i = 0; i < Student.size(); i++) {
            lista[0] = Student.get(i).id;
            lista[1] = Student.get(i).user;
            lista[2] = Student.get(i).parola;
            lista[3] = Student.get(i).nume;
            lista[4] = Student.get(i).prenume;
            lista[5] = Student.get(i).email;
            lista[6] = Student.get(i).telefon;
            lista[7] = Student.get(i).teste;
            lista[8] = Student.get(i).punctaj;
            lista[9] = Student.get(i).cursuri;
            lista[10] = Student.get(i).acces;
            listacursanti.addRow(lista);
        }
        tabel.getTableHeader().setReorderingAllowed(false);
        JScrollPane stabel = new JScrollPane(tabel);
        stabel.setPreferredSize(new Dimension(775, 330));
        this.add(stabel, BorderLayout.PAGE_START);
        JPanel buton = new JPanel(new FlowLayout());
        JPanel butoane = new JPanel(new GridLayout(1, 2, 10, 10));
        adauga = new JButton("Adauga student");
        sterge = new JButton("Sterge student");
        modifica = new JButton("Modificari informatii");
        butoane.add(adauga);
        butoane.add(sterge);
        butoane.add(modifica);
        buton.add(butoane);
        this.add(buton, BorderLayout.CENTER);
        adauga.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                new AdaugaCont(Student);

            }
        });
        sterge.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                    
                 try {
                 int  n = JOptionPane.showConfirmDialog(null, "Sigur doriti sa stergeti acest cont?", "Sterge Cont", JOptionPane.YES_NO_OPTION);
                 if (n == JOptionPane.YES_OPTION) {
                    int linieselectata = tabel.getSelectedRow();
                    listacursanti.removeRow(linieselectata);
                    Student.remove(Student.get(linieselectata));
                    JOptionPane.showMessageDialog(null, "Cont sters cu succes!");
                    salveazaDate(Student); 
                    }           
                 
                } catch (Exception ex) {

                }
                
            }
        });
        
        modifica.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                
                
                
                try {
                    int linieselectata =  tabel.getSelectedRow();
                    if(linieselectata == -1  )
                    {
                       JOptionPane.showMessageDialog(null, "Este necesara alegerea unui rand din tabel.");
                    }
                    else 
                    {
                        new ModificaDate(Student,linieselectata);
                    }
                    
                    
                } catch (Exception ex) {

                }
                

            }
        });
       
        setVisible(true);
        setSize(600, 400);

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
