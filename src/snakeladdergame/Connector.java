/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeladdergame;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alpha
 */
public class Connector extends JFrame{
    public Connector(){
        this.setSize(new Dimension(500,500));
        this.setLocationRelativeTo(null);
        Board obj = new Board();
        JPanel p1;
        p1 = obj.gameboard();
        JLabel[][] grid;
        grid = obj.grid;
        grid[5][5].setText("alpha");
        this.setContentPane(p1);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args){
        Connector obj = new Connector();
        
    }
}
