/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift.utils;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
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
    public Form(ArrayList<String> items){
        for(String s: items){
            this.items.put(new JLabel(s), new JTextField(10));
        }
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        for(int i=0; i<items.size(); i++){
//            gbc.gridx = 0;
//            gbc.gridy = i;
//            gbc.ipady = 10;
//            buttonPane.add(this.items.keySet()., gbc);
//            if(pt == 11){
//                pt2++;
//                pt = 0;
//            }else{
//                pt++;
//            }
//        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
