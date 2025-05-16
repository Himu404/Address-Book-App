import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class addressBook {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Address Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setLocation(500,250);
        Container cont = new Container();
        cont = frame.getContentPane();
        cont.setLayout(null);
       
        Cursor crs = new Cursor(Cursor.HAND_CURSOR);

        JLabel lbl = new JLabel("Set Name:");
        lbl.setBounds(20,25,120,30);
        cont.add(lbl);
        JLabel lbl1 = new JLabel("Set Address");
        lbl1.setBounds(150,25,120,30);
        cont.add(lbl1);

        JTextField txt = new JTextField();
        txt.setBounds(20,50,120,30);
        cont.add(txt);
        JTextField txt1 = new JTextField();
        txt1.setBounds(150,50,120,30);
        cont.add(txt1);
        JButton btn = new JButton("Submit");
        btn.setBounds(280,50,80,30);
        btn.setCursor(crs);
        cont.add(btn);
        JButton btn1 = new JButton("Clear");
        btn1.setBounds(370,50,80,30);
        btn1.setCursor(crs);
        cont.add(btn1);


        JLabel lbl4 = new JLabel("All Details: ");
        lbl4.setBounds(20,100,130,30);
        cont.add(lbl4);
        JTextArea txta = new JTextArea();
        txta.setLineWrap(true);
        txta.setWrapStyleWord(true);
        txta.setEditable(false);
        txta.setFocusable(false);
                
        JScrollPane scrl = new JScrollPane(txta);
        scrl.setBounds(20,130,440,110);
        cont.add(scrl);

        File book = new File("addressBook.txt");
        if (book.exists()){
            try {
                FileReader fl = new FileReader(book);
                BufferedReader reader = new BufferedReader(fl);
                String line ;
                while ((line = reader.readLine()) != null) {
                    txta.append(line+"\n");
                }
                reader.close();

            } catch (Exception e) {
                System.out.println(e);
                
            }
        }
        

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String name = txt.getText();  
                String address = txt1.getText();
                if (!name.isEmpty() && !address.isEmpty()){
                    String entry = "Name: "+name+"\t\tAddress: "+address+"\n";
                    try {
                        FileWriter fw = new FileWriter(book,true);
                        BufferedWriter writer = new BufferedWriter(fw);
                        writer.append(entry);
                        txta.append(entry);
                        writer.close();
                        
                    } catch (Exception a) {
                        System.out.println(a);
                    }
                    
                }
                txt.setText("");
                txt1.setText("");
            }     
        });
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                txta.setText("");
                try {
                    FileWriter fw = new FileWriter(book);
                    BufferedWriter writer = new BufferedWriter(fw);
                    writer.close();
                    
                } catch (Exception a) {
                    System.out.println(a);
                }
            
            
            }
        });

 
        frame.setVisible(true);
        
    }
}