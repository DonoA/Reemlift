/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift;

import java.awt.Dimension;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import reemlift.Player.Player;
import reemlift.SaveData.DBmanager;
import reemlift.Utils.GamePanel;


/**
 *
 * @author Donovan
 */
public class Reemlift {
    public static JFrame frame;
    public static GamePanel gameFrame;
    
    public static String FileSep = System.getProperty("file.separator");
    
    public static String Source;
    
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    
    private static void Setup(){
        Source = ClassLoader.getSystemClassLoader().getResource(".").getPath();
        System.out.println(Source);
        Source = Source.replace("/", FileSep);
        Source = Source.substring(1, Source.length());
        Source += "reemlift" + FileSep;
        frame = new JFrame("ReemLift");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gameFrame = new GamePanel();
        DBmanager.player = new Player();
    }
    public static void main(String[] args) {
        Setup();
        frame.add(gameFrame);
        frame.setSize(500, 400);
        gameFrame.repaint();
    }
}