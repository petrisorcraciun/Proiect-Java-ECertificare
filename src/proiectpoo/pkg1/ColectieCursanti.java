package proiectpoo.pkg1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ColectieCursanti{
   private static ColectieCursanti poo;
   ArrayList<Cursanti> llist = new ArrayList<Cursanti>();
   public ColectieCursanti()
   {
        // *****************************************
        String line;
        try {
            BufferedReader bfw = new BufferedReader(new FileReader("Date\\Conturi.txt"));
            while ((line = bfw.readLine()) != null) {
                String[] s = line.split(" ");
                Cursanti elevi = new Cursanti(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4], s[5], s[6], Integer.parseInt(s[7]), Integer.parseInt(s[8]), Integer.parseInt(s[9]), Integer.parseInt(s[10]));
                llist.add(elevi);

            }
            bfw.close();
        } catch (Exception ex) {
            System.out.println("aici #1");
        }

        // *******************************************
   }
   public static ColectieCursanti getInstanta(){
	if (poo==null) 
        {
            poo=new ColectieCursanti();
        }
	return poo;
}
}
