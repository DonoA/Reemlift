/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Donovan
 */
public class Reemlift {
    private static Menu m1;
    private static JFrame frame;
    private static Container fPain;
    private static void Setup(){
        frame = new JFrame("ReemLift");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(700, 450));
        fPain = frame.getContentPane();
        fPain.add(emptyLabel, BorderLayout.WEST);
        frame.pack();
//        frame.setSize(new Dimension(700, 450));
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Setup();
        m1=new Menu(Arrays.asList(new String[] {"Thing1" , "Thing2"}), true, frame, new Menu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(Menu.OptionClickEvent event) {
                System.out.println(event.getName());
                event.setWillClose(true);
            }
        });
        frame.pack();
        m1.show();
    }
}
