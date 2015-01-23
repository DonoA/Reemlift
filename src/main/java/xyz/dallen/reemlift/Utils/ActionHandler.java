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

package main.java.xyz.dallen.reemlift.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;
import main.java.xyz.dallen.reemlift.NPC.npc;
import main.java.xyz.dallen.reemlift.Player.Player;
import main.java.xyz.dallen.reemlift.Player.Shot;
import main.java.xyz.dallen.reemlift.Reemlift;
import static main.java.xyz.dallen.reemlift.Reemlift.TICKTIME;
import main.java.xyz.dallen.reemlift.SaveData.DBmanager;
import main.java.xyz.dallen.reemlift.Utils.Level.LevelDBmanager;

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
            });
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
            });
    private static final Timer timer4 = new Timer(TICKTIME, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });
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
                timer2.stop();
                timer3.stop();
                timer4.stop();
            }
        };
    
    public static Action MOVEPRESSA = new AbstractAction("MovePressA") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.player;
                e = ev;
                isDown=true;
                timer2.start();
                timer1.stop();
                timer3.stop();
                timer4.stop();
            }
        };
    
    public static Action MOVEPRESSS = new AbstractAction("MovePressS") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.player;
                e = ev;
                isDown=true;
                timer3.start();
                timer2.stop();
                timer1.stop();
                timer4.stop();
            }
        };
    
    public static Action MOVEPRESSD = new AbstractAction("MovePressD") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.player;
                e = ev;
                isDown=true;
                timer4.start();
                timer2.stop();
                timer3.stop();
                timer1.stop();
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
    
    private static boolean cooling = false;
    
    private static final Timer FireTimer = new Timer(DBmanager.player.getROF(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    cooling = false;
                    FireTimer.stop();
                }
            });
    
    public static Action FIRETAP = new AbstractAction("FireTap"){
        @Override
        public void actionPerformed(ActionEvent ev){
                if(!cooling){
                    Shot holder = new Shot(0, 0, DBmanager.player.getDir());
                    Number x = DBmanager.player.getHitBox().getCenterX() - (holder.getHitBox().width/2);
                    Number y = DBmanager.player.getHitBox().getCenterY() - (holder.getHitBox().height/2);
                    Shot s = new Shot(x.intValue(), y.intValue(), DBmanager.player.getDir());
                    DBmanager.MovingShots.add(s);
                    DBmanager.ForRender.add(s);
                    cooling = true;
                    FireTimer.start();
                    Reemlift.frame.repaint();
                }
            }
        };
    
    
    /////Interactions
    ////Handler
    ///Here
    
    public static Action INTERACT = new AbstractAction("Interact"){
        @Override
        public void actionPerformed(ActionEvent ev){
                if(LevelDBmanager.CurrLevel.getNpcDB().inRange(DBmanager.player.getHitBox())!= null){
                    //interact with npc
                }else{
                    //open inventory
                }
            }
        };
    
    @Override
    public void keyReleased(KeyEvent e) {
//        int key = e.getKeyCode();
//        System.out.println(key + ": thing");
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        int key = e.getKeyCode();
//        System.out.println(key + ": thing");
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        
//    }
    
}
