/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Reyn
 */
public class ChatBalloons extends JPanel{
    public JTextArea Form;
    public static int PosY = 0;
    public static int PosX = 0;
    public static int UserPosX;
    public float NegBorder = 10;
    public float PosBorder = 10;
    public float UpBorder = 10;
    public float DownBorder = 10;
    public int Width = 0;
    public int Height = 0;
    public int lineoftext = 0;
    
    
    public ChatBalloons(JTextArea form){
        this.Form = form;
        UserPosX = form.getWidth()-65;
        
    }
    
    public void DrawImageBot(String x){
        JLabel lbl = new JLabel("hakdog");
        JPanel pnl;
        pnl = new JPanel(){
            File imgFile;
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.drawOval(5, 0, 50, 50);
                g2.drawString(x, NegBorder, 20);
                
                
            }
            
        };
       
       pnl.add(lbl);
       Form.add(pnl,0);
       pnl.setBounds(PosX,PosY,(int) NegBorder + lbl.getWidth()+(int) PosBorder,(int)UpBorder + Height + (int) DownBorder);
       scrolldown();
      
       
    
    } //
    // get the design first
   
    //identify the length of letter assign a general value for each letter // == 6 width per letter == 10 height per row
    //assign max length for letter and then find the nearest space at the max length then add new line
        // first identify howw many max length would length of the entered letter will reach
        // if it exceed one max length then there should be a two declaration of wrap word
        // if there is the y wwidth of box ill increase and the drawwstring of second wrap word ywidth wwill also increase
    //get the length of letter then move the x- as the x+ exceed the frame
        //get the length assign the size
        //the box size minus the exceeding size in frame = the position of x in negative state 
        
// there should be margin
    public void DrawImageUser(String x){
        JPanel pnl;
        pnl = new JPanel(){
            File imgFile;
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.drawOval(5, 0, 50, 50);
                g2.drawString(x, NegBorder, 20);
                
                
            }
            
        };
       
       pnl.setBounds(UserPosX,PosY,(int) NegBorder + Width +(int) PosBorder,(int)UpBorder + Height + (int) DownBorder);
       
      
       Form.add(pnl,0);
       scrolldown();
    }
    

    public void definerow(String x){
        if(x.length() >= 75){
            addrow();
        }else{
            lineoftext = 1;
        }
            
    }
    public void definewidth(String x){
       
    }
    public void addrow(){
        lineoftext +=1;
    }
    public void scrolldown(){
       PosY +=50;
       Form.append("\n");
       Form.append("\n");
}
}


