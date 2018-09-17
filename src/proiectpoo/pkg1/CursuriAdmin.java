package proiectpoo.pkg1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class CursuriAdmin extends JPanel{
    private JButton L1, L3, L2, L4, L5;
    private JTextArea tL1, tL2, tL3, tL4, tL5;
    private JScrollPane sL1, sL2, sL3, sL4, sL5;
    public CursuriAdmin()
    {
        setLayout(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new GridLayout(5, 1, 10, 10));
        JPanel p4 = new JPanel(new FlowLayout());

        tL1 = new JTextArea(16, 60);
        tL2 = new JTextArea(16, 60);
        tL3 = new JTextArea(16, 60);
        tL4 = new JTextArea(16, 60);
        tL5 = new JTextArea(16, 60);
        L1 = new JButton("Capitolul 1");
        L2 = new JButton("Capitolul 2");
        L3 = new JButton("Capitolul 3");
        L4 = new JButton("Capitolul 4");
        L5 = new JButton("Capitolul 5");

        p3.add(L1);
        p3.add(L2);
        p3.add(L3);
        p3.add(L4);
        p3.add(L5);
        sL1 = new JScrollPane(tL1);
        sL1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sL2 = new JScrollPane(tL2);
        sL2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sL3 = new JScrollPane(tL3);
        sL3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sL4 = new JScrollPane(tL4);
        sL4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sL5 = new JScrollPane(tL5);
        sL5.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        p2.add(sL1);

        JPanel buton0 = new JPanel(new FlowLayout());
        JButton marcheaza = new JButton("Marcheaza citit");
        buton0.add(marcheaza);
        p4.add(p3, BorderLayout.PAGE_START);
        p4.add(p2, BorderLayout.LINE_START);
        this.add(p4);

        String filePath1 = System.getProperty("user.dir") + "\\Cap1L1.txt";
        String filePath2 = System.getProperty("user.dir") + "\\Cap1L2.txt";
        String filePath3 = System.getProperty("user.dir") + "\\Cap1L3.txt";
        String filePath4 = System.getProperty("user.dir") + "\\Cap1L3.txt";
        String filePath5 = System.getProperty("user.dir") + "\\Cap1L3.txt";
        
        L1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader reader = new FileReader(filePath1);
                    BufferedReader br = new BufferedReader(reader);
                    tL1.read(br, null);
                    br.close();
                    tL1.requestFocus();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                p2.removeAll();
                p2.revalidate();
                p2.repaint();
                p2.add(sL1);
                tL1.setVisible(true);
                
            }
        });
        tL2.setVisible(false);
        L2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                    try {

                        FileReader reader = new FileReader(filePath2);
                        BufferedReader br = new BufferedReader(reader);
                        tL2.read(br, null);
                        br.close();
                        tL2.requestFocus();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    p2.removeAll();
                    p2.revalidate();
                    p2.repaint();
                    p2.add(sL2);
                    tL2.setVisible(true);
                    
                
            }
        });

        tL3.setVisible(false);
        L3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                    try {

                        FileReader reader = new FileReader(filePath3);
                        BufferedReader br = new BufferedReader(reader);
                        tL3.read(br, null);
                        br.close();
                        tL3.requestFocus();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    p2.removeAll();
                    p2.revalidate();
                    p2.repaint();
                    p2.add(sL3);
                    tL3.setVisible(true);

                
            }
        });
        tL4.setVisible(false);
        L4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
                    try {

                        FileReader reader = new FileReader(filePath3);
                        BufferedReader br = new BufferedReader(reader);
                        tL4.read(br, null);
                        br.close();
                        tL4.requestFocus();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    p2.removeAll();
                    p2.revalidate();
                    p2.repaint();
                    p2.add(sL4);
                    tL4.setVisible(true);
               
            }
        });
        tL5.setEditable(false);
        tL5.setVisible(false);
        L5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                    try {
                        FileReader reader = new FileReader(filePath3);
                        BufferedReader br = new BufferedReader(reader);
                        tL5.read(br, null);
                        br.close();
                        tL5.requestFocus();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    p2.removeAll();
                    p2.revalidate();
                    p2.repaint();
                    p2.add(sL3);
                    tL5.setVisible(true);
                    
           
            }
        });

        setVisible(true);
    }
}
