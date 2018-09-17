package proiectpoo.pkg1;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class ModificaDate extends JFrame {

    private JButton b1, b2;
    private JLabel nume, prenume, user, telefon, email, parola, mesaj1, mesaj2, nrid, tnrid,lacces;
    private JTextField tnume, tprenume, tuser, ttelefon, temail;
    private JPasswordField tparola;
    private int k = 0;
    String[] tipacces = { "Student" , "Admin"};
    final JComboBox acces = new JComboBox(tipacces);
    int idacces;

    public ModificaDate(ArrayList<Cursanti> Student,int index) {
        setLayout(new FlowLayout());
        JPanel p0 = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new GridLayout(8, 2, 10, 10));
        JPanel p3 = new JPanel(new FlowLayout());
        JPanel p4 = new JPanel(new FlowLayout());

        b1 = new JButton("Editeaza informatii");
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
        mesaj1 = new JLabel("Modificare Date E-Certificare Java");
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

        
        tnrid.setText(String.valueOf(Student.get(index).id));
        tuser.setText(Student.get(index).user);
        tparola.setText(Student.get(index).parola);
        tnume.setText(Student.get(index).nume);
        tprenume.setText(Student.get(index).prenume);
        temail.setText(Student.get(index).email);
        ttelefon.setText(Student.get(index).telefon);
        
        

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                Student.get(index).setId(Student.get(index).id);
                Student.get(index).setUser(tuser.getText());
                Student.get(index).setParola(tparola.getText());
                Student.get(index).setNume(tnume.getText());
                Student.get(index).setPrenume(tprenume.getText());
                Student.get(index).setEmail(temail.getText());
                Student.get(index).setTelefon(ttelefon.getText());
                Student.get(index).setAcces(acces.getSelectedIndex());
                salveazaDate(Student);
                JOptionPane.showMessageDialog(null, "Date au fost modificate!");
                dispose();
                
            }

        }
    

    );

    setTitle("e-Certificate JAVA");
    setSize(370, 370);
    setVisible(true);
    setResizable(false);

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
