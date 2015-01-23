/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.java.xyz.dallen.reemlift;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import main.java.xyz.dallen.reemlift.Player.Player;
import main.java.xyz.dallen.reemlift.Player.Shot;
import main.java.xyz.dallen.reemlift.SaveData.DBmanager;
import main.java.xyz.dallen.reemlift.Utils.GamePanel;
//import main.java.org.*;
/**
 *
 * @author Donovan
 */
public class Reemlift {
//    public static ObjectMapper parser;
    
    public static JFrame frame;
    
    public static GamePanel gameFrame;
    
    public static String FileSep = System.getProperty("file.separator");
    
    public static String Source;
    
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    
    public static final int TICKTIME = 25;
    
    public static final int HEIGHT = 408;
    public static final int WIDTH = 506;
    
    public final static Timer MainLoop = new Timer(Reemlift.TICKTIME, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Reemlift.MainTick.run();
                }
            });
    
    private final static Runnable MainTick = new Runnable(){

        @Override
        public void run() {
            if(!DBmanager.MovingShots.isEmpty()){
                for(Shot s:DBmanager.MovingShots){
                    if(!s.dead){
                        s.Update();
                    }else{
                        DBmanager.ForRender.remove(s);
//                        DBmanager.MovingShots.remove(s);
                    }
                }
            }
            
            frame.repaint();
        }
    };
    
    private static void Setup(){
        Source = ClassLoader.getSystemClassLoader().getResource(".").getPath();
        Source = Source.replace("/", FileSep);
        Source = Source.substring(1, Source.length());
        Source += "main" + FileSep + "java" + FileSep + "io" + FileSep + "github" + FileSep + "donoa" + FileSep + "reemlift" + FileSep;
        frame = new JFrame("ReemLift");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 200);
    }
    private static void MainMenu(){
        final JPanel btnp = new JPanel();
        btnp.setBackground(Color.BLUE);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton Hbtn = new JButton("New Game");
        Hbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    frame.remove(btnp);
                    gameFrame = new GamePanel();
                    DBmanager.ForRender.add(DBmanager.player);
                    frame.add(gameFrame);
                    gameFrame.repaint();
                    frame.setSize(WIDTH, HEIGHT);
                }
            });
        btnp.add(Hbtn);
        Hbtn = new JButton("Load Game");
        Hbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    JPanel btnpLoad = new JPanel();
                    //menu of saves
                }
            });
        btnp.add(Hbtn);
        Hbtn = new JButton("Quit Game");
        Hbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    frame.dispose();
                }
            });
        btnp.add(Hbtn);
        frame.add(btnp, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        Setup();
        MainMenu();
    }
}