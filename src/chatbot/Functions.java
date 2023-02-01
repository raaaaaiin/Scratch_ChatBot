/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import static java.nio.file.AccessMode.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JPanel;

/**
 *
 * @author Reyn
 */
public class Functions {
    private JPanel form;
    public Path Directory = Paths.get("C:\\Users\\Reyn\\Documents\\NetBeansProjects\\ChatBot\\Dir");
    static public String[] OverwrittenData;

//For Initialization of array

    public void readData() {
        int i = 0;
        try {
            FileReader in = new FileReader(Directory.toString() + "\\Chat.txt");
            BufferedReader br = new BufferedReader(in);
            String s = "";
            while ((s = br.readLine()) != null) {
                OverwrittenData[i] = s;
                i++;
            }
            in.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

 //For conversation 
 //Identifier of words
    //Identify if it is a question or a command
    //command should be always starting witwh open followed by certain  
    public void identify() {

    }

 //Teaching function
    
    
    //Main teach function
    public void Teach(String you, String Bot) {
        inserttext(you, Bot);

    }
    //Check if there is existing text
    // if ifexist true then it exist if false no
    // if text exist read line -> store in array -> add the current text to last -> save all of the array
    // if there is no text exist save the current text.
    public void inserttext(String you, String Bot) {
     //Check if there is existing text
        // if ifexist true then it exist if false no
        if (ifexist(you) == true) {
         // if text exist read line -> store in array -> add the current text to last -> save all of the array
            update(you,Bot);
        } else if (ifexist(you) == false) {
            // if there is no text exist save the current text.
            createfile(you, Bot);
        }

    }
    
    public void createfile(String you, String Bot) {
        //This creates the file and next to be use is insertext to have a text inside
        try {
            String nl = System.getProperty("line.separator");
            Path file = Paths.get(Directory.toString() + "\\" + you + ".txt");
            String s = Bot + nl;
            byte[] data = s.getBytes(StandardCharsets.UTF_8);
            OutputStream output = null;
            try {
                output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
                output.write(data);
                output.flush();
                output.close();
                System.out.println("Created successfuly");
            } catch (Exception e) {
                System.out.println("Alert: " + e.toString());
            }
        } catch (Exception ex) {
            System.out.println("BOBO WALANG FILE");
        }
    }
    
   public boolean ifexist(String you) {
        boolean re = false;
        Path file = Paths.get(Directory.toString() + "\\" + you + ".txt");
        try {
            file.getFileSystem().provider().checkAccess(file, READ, EXECUTE);
            re = true;

        } catch (IOException e) {
            re = false;
        }
        return re;
    }
    public void update(String you, String Bot){
       int i = 0;
       int count = 0;
        try {
            FileReader in = new FileReader(Directory.toString() + "\\" + you + ".txt");
            FileReader iin = new FileReader(Directory.toString() + "\\" + you + ".txt");
            BufferedReader br = new BufferedReader(in);
            BufferedReader cr = new BufferedReader(iin);
            String s = "";
            String z= "";
            while ((s = br.readLine()) != null) {
                count++;
                System.out.println(count);
            }
            
            OverwrittenData = new String[count + 1];
            System.out.println("Array Initialized :" + OverwrittenData.length);
            while ((z = cr.readLine()) != null) {
                OverwrittenData[i] = z;
                System.out.println(OverwrittenData[i]);
                i++;
                
            }
            in.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        OverwrittenData[count] = Bot;
        try{save(OverwrittenData.length,you);}catch(IOException ex){}
        

    }
    public void save(int count,String you) throws FileNotFoundException {
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(Directory.toString() + "\\" + you + ".txt"));
            for (int i = 0; i < count; i++){
                writer.write(OverwrittenData[i]);
                writer.newLine();
                writer.flush();
            }
        }catch(IOException ex){
            
        }

    }
    

    

    public void GetDataUpdated(String question, javax.swing.JTextField TextField){
    
        int i = 0;
        
        int count = 0;
        try {
            FileReader in = new FileReader(Directory.toString() + "\\" + question + ".txt");
            FileReader iin = new FileReader(Directory.toString() + "\\" + question + ".txt");
            BufferedReader br = new BufferedReader(in);
            BufferedReader cr = new BufferedReader(iin);
            String s = "";
            String z= "";
            while ((s = br.readLine()) != null) {
                count++;
            }
            
            OverwrittenData = new String[count + 1];
            while ((z = cr.readLine()) != null) {
                OverwrittenData[i] = z;
                i++;
                
            }
            in.close();
            System.out.println(reply(count));
        } catch (Exception ex) {
            Learning(question);
           
        }
        
    }
    public void Learning(String you){
        
    }
    public String reply(int count) {
        int randomnumber = (int) (Math.round(Math.random() * (count - 1)));
        return OverwrittenData[randomnumber];
    }

 // Chat balloons
    

 //Some functions
    public void Youtube(String Search) {
        try {

            URI uri = new URI("https://www.youtube.com/results?search_query=" + Search);

            java.awt.Desktop.getDesktop().browse(uri);
            System.out.println("Web page opened in browser");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
