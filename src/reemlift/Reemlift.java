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
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Donovan
 */
public class Reemlift {
    private static JFrame frame;
    private static Container fPain;
    private static HashMap<String, Menu> menus = new HashMap<>();
    private static void Setup(){
        frame = new JFrame("ReemLift");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(700, 450));
        fPain = frame.getContentPane();
        fPain.add(emptyLabel, BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);
        menus.put("main", new Menu(Arrays.asList(new String[] {"kill" , "live"}), true, frame, new Menu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(Menu.OptionClickEvent event) {
                if(event.getName().equalsIgnoreCase("kill")){
                    menus.get("mn_kill").show();
                }else{
                    menus.get("mn_live").show();
                }
                event.setWillClose(true);
            }
        }));
        menus.put("mn_kill", new Menu(Arrays.asList(new String[] {"animal1" , "aminal2", "animal3" , "aminal4", "animal5" , "aminal6", "animal7" , "aminal8", "tttttttt1", "ttttttt2"}), true, frame, new Menu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(Menu.OptionClickEvent event) {
                if(event.getName().equalsIgnoreCase("animal1")){
                    System.out.println("no1");
                }else{
                    System.out.println("no2");
                }
                menus.get("main").show();
                event.setWillClose(true);
            }
        }));
        menus.put("mn_live", new Menu(Arrays.asList(new String[] {"animal1" , "aminal2"}), true, frame, new Menu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(Menu.OptionClickEvent event) {
                if(event.getName().equalsIgnoreCase("animal1")){
                    System.out.println("yes1");
                }else{
                    System.out.println("yes2");
                }
                menus.get("main").show();
                event.setWillClose(true);
            }
        }));
    }
    public static void main(String[] args) {
        Setup();
        frame.pack();
        menus.get("main").show();
    }
}
