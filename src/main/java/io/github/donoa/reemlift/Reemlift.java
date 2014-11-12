/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.java.io.github.donoa.reemlift;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.swing.JFrame;
import main.java.io.github.donoa.reemlift.Player.Player;
import main.java.io.github.donoa.reemlift.SaveData.DBmanager;
import main.java.io.github.donoa.reemlift.Utils.GamePanel;


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
//        System.out.println(Source);
        Source = Source.replace("/", FileSep);
        Source = Source.substring(1, Source.length());
        Source += "main" + FileSep + "java" + FileSep + "io" + FileSep + "github" + FileSep + "donoa" + FileSep + "reemlift" + FileSep;
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