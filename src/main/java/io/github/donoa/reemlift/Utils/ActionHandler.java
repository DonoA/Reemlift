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

package main.java.io.github.donoa.reemlift.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;
import main.java.io.github.donoa.reemlift.Player.Player;
import static main.java.io.github.donoa.reemlift.Reemlift.TICKTIME;
import main.java.io.github.donoa.reemlift.SaveData.DBmanager;

/**
 *
 * @author Donovan
 */
public class ActionHandler extends KeyAdapter/*implements ActionListener*/{
    private static Player p;
    private static ActionEvent e;
    private static final Timer timer1 = new Timer(TICKTIME, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });;;
    private static final Timer timer2 = new Timer(TICKTIME, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });
    private static final Timer timer3 = new Timer(TICKTIME, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });;;
    private static final Timer timer4 = new Timer(TICKTIME, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });;
    private static boolean isDown = false;
    
    
    //////Press
    /////Events
    ////Here
    public static Action MOVEPRESSW = new AbstractAction("MovePressW") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.player;
                e = ev;
                isDown=true;
                timer1.start();
            }
        };
    
    public static Action MOVEPRESSA = new AbstractAction("MovePressA") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.player;
                e = ev;
                isDown=true;
                
                timer2.start();
            }
        };
    
    public static Action MOVEPRESSS = new AbstractAction("MovePressS") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.player;
                e = ev;
                isDown=true;
                
                timer3.start();
            }
        };
    
    public static Action MOVEPRESSD = new AbstractAction("MovePressD") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.player;
                e = ev;
                isDown=true;
                timer4.start();
            }
        };
    /////Key
    ////Release
    ///Here
    public static Action MOVERELEASEW = new AbstractAction("MoveReleaseW") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(isDown){
                    timer1.stop();
                    isDown = false;
                }
            }
        };
    
    public static Action MOVERELEASEA = new AbstractAction("MoveReleaseA") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(isDown){
                    timer2.stop();
                    isDown = false;
                }
            }
        };
    
    public static Action MOVERELEASES = new AbstractAction("MoveReleaseS") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(isDown){
                    timer3.stop();
                    isDown = false;
                }
            }
        };
    
    public static Action MOVERELEASED = new AbstractAction("MoveReleaseD") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(isDown){
                    timer4.stop();
                    isDown = false;
                }
            }
        };
    /////Fire
    ////Tap
    ///Here
    
//    private Timer FireCool = new Timer();
    private boolean cooling = false;
    
    public static Action FIRETAP = new AbstractAction("FireTap"){
        @Override
        public void actionPerformed(ActionEvent ev){
                System.out.println("Fire");
            }
            
        };
    
    
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key + ": thing");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key + ": thing");
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        
//    }
    
}
