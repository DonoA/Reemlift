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

package reemlift.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;
import reemlift.Player.Player;
import reemlift.Reemlift;
import reemlift.SaveData.DBmanager;

/**
 *
 * @author Donovan
 */
public class ActionHandler extends KeyAdapter/*implements ActionListener*/{
    private static Player p;
    private static ActionEvent e;
    private static Timer timer1;
    private static Timer timer2;
    private static Timer timer3;
    private static Timer timer4;
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
                timer1 = new Timer(200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });
            timer1.start();
            }
        };
    
    public static Action MOVEPRESSA = new AbstractAction("MovePressA") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.player;
                e = ev;
                isDown=true;
                timer2 = new Timer(200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });
            timer2.start();
            }
        };
    
    public static Action MOVEPRESSS = new AbstractAction("MovePressS") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.player;
                e = ev;
                isDown=true;
                timer3 = new Timer(200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });
            timer3.start();
            }
        };
    
    public static Action MOVEPRESSD = new AbstractAction("MovePressD") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.player;
                e = ev;
                isDown=true;
                timer4 = new Timer(200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });
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
                    timer1 = null;
                    isDown = false;
                }
            }
        };
    
    public static Action MOVERELEASEA = new AbstractAction("MoveReleaseA") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(isDown){
                    timer2.stop();
                    timer2 = null;
                    isDown = false;
                }
            }
        };
    
    public static Action MOVERELEASES = new AbstractAction("MoveReleaseS") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(isDown){
                    timer3.stop();
                    timer3 = null;
                    isDown = false;
                }
            }
        };
    
    public static Action MOVERELEASED = new AbstractAction("MoveReleaseD") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(isDown){
                    timer4.stop();
                    timer4 = null;
                    isDown = false;
                }
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
