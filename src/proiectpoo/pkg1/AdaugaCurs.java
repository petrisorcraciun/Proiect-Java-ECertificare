package proiectpoo.pkg1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdaugaCurs extends JFrame {
    private JLabel numecurs,durata;
    private JTextField tcurs,tdurata;
    public AdaugaCurs()
    {
        setLayout(new FlowLayout());
        JPanel p0 = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(2,1,10,10));
        numecurs = new JLabel("Nume curs:");
        p1.add(numecurs);
        durata = new JLabel("Durata(minute):");
        p1.add(durata);
        JPanel p2 = new JPanel(new GridLayout(2,1,10,10));
        tcurs = new JTextField(20);
        p2.add(tcurs);
        tdurata = new JTextField(20);
        p2.add(tdurata);
        p0.add(p1,BorderLayout.LINE_START);
        p0.add(p2,BorderLayout.CENTER);
        this.add(p0);
        
        JButton adauga = new JButton("Adauga curs");
        this.add(adauga);
        
        setVisible(true);
        setSize(400,400);
        
    }
    
    
    
    
    
    
    
    
}
