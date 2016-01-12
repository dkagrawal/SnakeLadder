/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeladdergame;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import javax.swing.JLabel;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author alpha
 */
public class Dice {
    
    Image[] images = new Image[6];
    Image[] dimg = new Image[6];
    public Dice(){
        for(int i=0;i<6;++i){
            try {
                images[i]=null;
                dimg[i]=null;
                images[i] = ImageIO.read(getClass().getResource("images/"+
                        Integer.toString(i+1)+".jpeg"));
                dimg[i] = images[i].getScaledInstance(80,80,Image.SCALE_SMOOTH);
            } 
            catch (IOException e) {
                System.out.println("Error occured");
            }
        }
    }
    public JLabel diceroll(){
        Random rand = new Random();
        int randomno = rand.nextInt(6)+1;
        System.out.println(randomno);
        JLabel diceimg = new JLabel();
        ImageIcon imageIcon;
        imageIcon = new ImageIcon(dimg[randomno-1]);
        diceimg.setPreferredSize(new Dimension(80,80));
        diceimg.setIcon(imageIcon);
        diceimg.setName(Integer.toString(randomno));
        return diceimg;
    }
    //get all the images
    
}
