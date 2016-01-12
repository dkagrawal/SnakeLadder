/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeladdergame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alpha
 */
public class Board {
    Image image = null;
    Image dimg = null;
    JLabel[][] grid = new JLabel[10][10];
    GridLayout gl = new GridLayout(10,10);
    public Board(){
        //this.setSize(500,500);
        try {
            image = ImageIO.read(getClass().getResource("images/board.jpg"));
            dimg = image.getScaledInstance(500,500,Image.SCALE_SMOOTH);
        }
        catch(IOException e){
            //do nothing
        }
    }
    
    public JPanel gameboard(){
        ImagePanel panel = new ImagePanel(dimg);
        JPanel board = new JPanel();
        board.add(panel);
        return board;
    }
    
    public class ImagePanel extends JPanel{
        Image image;
        
        
        public ImagePanel(Image image){
            this.setLayout(gl);
            this.image = image;
            Dimension size = new Dimension(500,500);
            this.setPreferredSize(size);
            for(int i=0;i<10;++i){
                for(int j=0;j<10;++j){
                    grid[i][j] = new JLabel();
                    grid[i][j].setName(Integer.toString(100-(10*i+j)));
                    if(i%2==0){
                        this.add(grid[i][j]);
                    }
                    else{
                        this.add(grid[i][j],10*i);
                    }
                }
            }
            
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0,0, this);
        }
    }
    
    public JLabel[][] gamegrid(){
        return grid;
    }
}
