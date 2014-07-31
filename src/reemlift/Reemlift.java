/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import reemlift.utils.DBmanager;
import reemlift.utils.Menu;
import reemlift.utils.WaitBar;

/**
 *
 * @author Donovan
 */
public class Reemlift {
    private static JFrame frame;
    private static Container fPain;
    private static HashMap<String, Menu> menus = new HashMap<>();
    private static WaitBar bar;
    public static Game main;
    private static void Setup(){
        frame = new JFrame("ReemLift");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(700, 450));
        fPain = frame.getContentPane();
        fPain.add(emptyLabel, BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);
        Menu mhold = new Menu(frame, new Menu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(Menu.OptionClickEvent event) {
                if(event.getName().equalsIgnoreCase("new game")){
                    main = new Game(frame);
                    main.Start();
                }else if(event.getName().equalsIgnoreCase("load game")){
                    Menu mhold = new Menu(frame, new Menu.OptionClickEventHandler() {
                        @Override
                        public void onOptionClick(Menu.OptionClickEvent event) {
                            Game game = DBmanager.Load(event.getName()).asGame(frame);
                            game.Start();
                        }
                    });
                    int pos = 1;
                    for(String s : DBmanager.getSaves()){
                        mhold.addOP(pos, s, "Load save " + s);
                        pos++;
                    }
                    mhold.show(BorderLayout.NORTH);
                }else{
                    WindowEvent wev = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
                    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
                }
            }
        })
        .addOP(1, "New Game", "A fresh start")
        .addOP(2, "Load Game", "Pick up where you left off")
        .addOP(3, "Exit", "nooooo");
        menus.put("main", mhold);
        bar = new WaitBar(frame);
    }
    public static void main(String[] args) {
        Setup();
        frame.pack();
        menus.get("main").show(BorderLayout.NORTH);
    }
}


//                if(event.getName().equalsIgnoreCase("kill")){
//                    event.setWillClose(false);
//                    event.setWillDisable(true);
//                    bar.Start(new WaitBar.OptionClickEventHandler() {
//                        @Override
//                        public void onOptionClick(WaitBar.OptionClickEvent event) {
//                            menus.get("mn_kill").show();
//                        }
//                    });
//                }else{
//                    menus.get("mn_live").show();
//                }