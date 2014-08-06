/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift.Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import reemlift.utils.Console;
import reemlift.utils.DBmanager;
import reemlift.utils.Form;
import reemlift.utils.Index;
import reemlift.utils.Menu;
import reemlift.utils.WaitBar;

/**
 *
 * @author Donovan
 */
public class Game {
    //utils
    private JFrame frame;
    private Container fPain;
    private HashMap<String, Menu> menus = new HashMap<>();
    private WaitBar bar;
    private Console consoleLog;
    //locations
    
    //player stuff
    
    public Game(JFrame frame){
        this.frame = frame;
        ////console setup////
        consoleLog = new Console(8, 20, false);
        ////form setups////
        final Form form_newChar = new Form(Arrays.asList(new String[] {"Name", "thing2"}), this.frame);
        ////loadbar setup////
        bar = new WaitBar(this.frame);
        ////menus setups (The big stuff)////
        Menu mhold;
        ///scenes///
        //---1---//
        mhold = new Menu(frame, new Menu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(Menu.OptionClickEvent event) {
                consoleLog.setText("You stand up pushing brush branches away from your face. You can only make out a dirt path ahead of you.");
                bar.Start(10, new WaitBar.OptionClickEventHandler() {
                        @Override
                        public void onOptionClick(WaitBar.OptionClickEvent event) {
//                            menus.get("mn_kill").show();
                        }
                    });
                }
            });
        mhold.addOP(1, "Stand up", "Stand up");
        menus.put("mnu_Scene1", mhold);
        //---2---//
        mhold = new Menu(frame, new Menu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(Menu.OptionClickEvent event) {
                
            }
        });
        mhold.addOP(1, "Walk to path", "Walk");
        menus.put("mnu_Scene2", mhold);
        
        
        ///Utils///
        mhold = new Menu(frame, new Menu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(Menu.OptionClickEvent event) {
                String stats = "";
                for(String s:Index.races.get(event.getName()).keySet()){
                    stats += s + ": " + Index.races.get(event.getName()).get(s) + "\n";
                }
                stats += "Description: " + Index.raceDes.get(event.getName());
                consoleLog.setTextTimed(stats, 100);
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
                    form_newChar.Show();
                }else{
//                    consoleLog.setText("");
                    menus.get("mnu_raceSelect").show(BorderLayout.WEST);
                }
            }
        });
        mhold.addOP(1, "Yes", "yes");
        mhold.addOP(2, "No", "no");
        mhold.SetTitle("Are you sure?");
        menus.put("mnu_raceSelecty/n", mhold);
    }
    public Game Load(){
        return null;
    }
    public void Start(){
        bar.Show(true);
        JScrollPane jcp = new JScrollPane(consoleLog);
        frame.add(jcp, BorderLayout.PAGE_END);
        frame.revalidate();
        frame.repaint();
        consoleLog.setText("You wake up on your back surrounded by thick leaves and tall grasses. Your head hurts and you feel a bruses up your arm and onto your head. You are helpess and alone with only the cloths on your back and the shoes on your feet.");
        menus.get("mnu_Scene1").show(BorderLayout.WEST);
    }
    public void Resume(){
        
    }
}
