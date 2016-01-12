/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeladdergame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author alpha
 */
public class Form extends JFrame{
    
    
    public void work(int no){
        String[] name = new String[no];
        this.setSize(90*no,70*no);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        JLabel[] names = new JLabel[no];
        JTextField[] texts = new JTextField[no];
        JPanel p1 = new JPanel();
        GridLayout g1 =  new GridLayout(no,2);
        p1.setLayout(g1);
        Font myFont1,myFont2;
        myFont1 = new Font("Serif", Font.ITALIC|Font.BOLD, 16);
        myFont2 = new Font("Impact",Font.BOLD,16);
        for(int i=1;i<=no;++i){
            names[i-1] = new JLabel("Player "+ Integer.toString(i)+":");
            names[i-1].setFont(myFont1);
            names[i-1].setHorizontalAlignment(SwingConstants.CENTER);
            names[i-1].setPreferredSize(new Dimension(100,100));
            p1.add(names[i-1]);
            texts[i-1] = new JTextField();
            texts[i-1].setPreferredSize(new Dimension(100,100));
            texts[i-1].addActionListener(new inputEngine());
            p1.add(texts[i-1]);
        }
        JPanel p2 = new JPanel();
        JButton start = new JButton("Let's Play!!");
        start.setFont(myFont2);
        start.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag=1;
                for(int i=0;i<no;++i){
                    name[i]=texts[i].getText();
                    if("".equals(name[i])){
                        flag=0;
                    }
                }
                if(flag==0){
                    JOptionPane.showMessageDialog(rootPane,"Please enter name of all"
                            + " the players", null, flag);
                }
            }
            
    });
        p2.add(start);
        JPanel main = new JPanel();
        GridLayout g2 = new GridLayout(2,1);
        main.setLayout(g2);
        main.add(p1);
        main.add(p2);
        this.setContentPane(main);
    }
    
    class inputEngine implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object eventSource = e.getSource();
            JTextField text = (JTextField) eventSource;
            String input;
            input = text.getText();
        }
        
    }
    
}
