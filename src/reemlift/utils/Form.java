/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift.utils;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Donovan
 */
public class Form implements ActionListener{
    private HashMap<JLabel, JTextField> items = new HashMap<>();
    private JButton submit = new JButton("Submit");
    private JPanel buttonPane = new JPanel();
    private JFrame frame;
    public Form(List<String> items, JFrame fm){
        frame = fm;
        for(String s: items){
            this.items.put(new JLabel(s), new JTextField(10));
        }
        
    }
    public void Show(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int posy = 0;
        for(JLabel jb : this.items.keySet()){
            gbc.gridx = 0;
            gbc.gridy = posy;
            gbc.ipady = 10;
            buttonPane.add(jb, gbc);
            gbc.gridx = 1;
            gbc.gridy = posy;
            gbc.ipady = 10;
            buttonPane.add(this.items.get(jb), gbc);
            posy++;
        }
        frame.getContentPane().add(buttonPane, BorderLayout.NORTH);
        frame.revalidate();
        frame.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
