/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift.Game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import reemlift.utils.DBmanager;
import reemlift.utils.Index;
import reemlift.utils.Menu;
import reemlift.utils.WaitBar;

/**
 *
 * @author Donovan
 */
public class Game {
    private JFrame frame;
    private Container fPain;
    private HashMap<String, Menu> menus = new HashMap<>();
    private WaitBar bar;
    private JTextArea consoleLog;
    public Game(JFrame frame){
        this.frame = frame;
//        WaitBar loader = new WaitBar(frame);
//        loader.Show(0, false);
//        loader.setProg(10);
        consoleLog = new JTextArea(5, 20);
//        consoleLog.setMaximumSize(new Dimension(200, 300));
        consoleLog.setEditable(false);
        this.frame.add(consoleLog, BorderLayout.EAST);
        Menu mhold = new Menu(frame, new Menu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(Menu.OptionClickEvent event) {
                String stats = "";
                for(String s:Index.races.get(event.getName()).keySet()){
                    stats += s + ": " + Index.races.get(event.getName()).get(s) + "\n";
                }
                stats += "Description: " + Index.raceDes.get(event.getName());
                consoleLog.setText(stats);
                menus.get("mnu_raceSelecty/n").show(BorderLayout.WEST);
            }
        })
        .SetTitle("Race Select");
        int pos = 1;
        for(String s: Index.races.keySet()){
            mhold.addOP(pos, s, s);
            pos++;
        }
        menus.put("mnu_raceSelect", mhold);
        mhold = new Menu(frame, new Menu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(Menu.OptionClickEvent event) {
                if(event.getName().equalsIgnoreCase("yes")){
                    
                }else{
                    menus.get("mnu_raceSelect").show(BorderLayout.WEST);
                }
            }
        });
        mhold.addOP(1, "Yes", "yes");
        mhold.addOP(2, "No", "no");
        menus.put("mnu_raceSelecty/n", mhold);
//        loader.setProg(100);
//        loader.unload();
    }
    public void Start(){
        frame.getContentPane().add(consoleLog, BorderLayout.EAST);
        frame.revalidate();
        frame.repaint();
        menus.get("mnu_raceSelect").show(BorderLayout.WEST);
    }
}
