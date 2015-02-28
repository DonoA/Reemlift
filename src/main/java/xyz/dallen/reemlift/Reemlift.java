/*
 * This file is part of Reemlift.
 * 
 * Reemlift is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Reemlift is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Reemlift.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 */

package main.java.xyz.dallen.reemlift;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import lombok.Getter;
import lombok.Setter;
import main.java.xyz.dallen.reemlift.Player.Shot;
import main.java.xyz.dallen.reemlift.SaveData.DBmanager;
import main.java.xyz.dallen.reemlift.Utils.GamePanel;
import main.java.xyz.dallen.reemlift.Utils.LogUtil;
import main.java.xyz.dallen.reemlift.Utils.Sprite;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Donovan
 */
public class Reemlift {
    
    @Getter
    private static ObjectMapper json = new ObjectMapper();
    
    @Getter
    private static JFrame frame;
    
    @Getter
    private static GamePanel gameFrame;
    
    @Getter
    private static String FileSep = System.getProperty("file.separator");
    
    @Getter
    private static String Source;
    
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    
    @Getter
    private static final int TICKTIME = 25;
    
    @Getter
    private static final int HEIGHT = 408;
    @Getter
    private static final int WIDTH = 506;
    
    @Getter
    private static boolean debug = true;
    
    @Getter
    private final static Timer MainLoop = new Timer(Reemlift.TICKTIME, new ActionListener() {
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
                    if(!s.isDead()){
                        s.Update();
                    }else{
                        DBmanager.ForRender.get(1).remove(s);
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
        Source += "main" + FileSep + "java" + FileSep;
        frame = new JFrame("ReemLift");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 200);
        LogUtil.setOutStream(System.out);
        for(int i = 0; i <= 10; i++){
            DBmanager.ForRender.put(i, new ArrayList<Sprite>());
        }
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
                    DBmanager.ForRender.get(0).add(DBmanager.getPlayer());
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