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
import lombok.Getter;
import main.java.xyz.dallen.reemlift.NPC.npc;
import main.java.xyz.dallen.reemlift.Player.Player;
import main.java.xyz.dallen.reemlift.Player.Shot;
import main.java.xyz.dallen.reemlift.Reemlift;
import main.java.xyz.dallen.reemlift.SaveData.DBmanager;
import main.java.xyz.dallen.reemlift.Utils.Level.LevelDBmanager;

/**
 *
 * @author Donovan
 */
public class ActionHandler extends KeyAdapter/*implements ActionListener*/{
    private static Player p;
    private static ActionEvent e;
    private static final Timer timer1 = new Timer(Reemlift.getTICKTIME(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });
    private static final Timer timer2 = new Timer(Reemlift.getTICKTIME(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });
    private static final Timer timer3 = new Timer(Reemlift.getTICKTIME(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        p.Move(e.getActionCommand());
                    }
                }
            });
    private static final Timer timer4 = new Timer(Reemlift.getTICKTIME(), new ActionListener() {
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
    @Getter
    private static Action MOVEPRESSW = new AbstractAction("MovePressW") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.getPlayer();
                e = ev;
                isDown=true;
                timer1.start();
                timer2.stop();
                timer3.stop();
                timer4.stop();
            }
        };
    @Getter
    private static Action MOVEPRESSA = new AbstractAction("MovePressA") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.getPlayer();
                e = ev;
                isDown=true;
                timer2.start();
                timer1.stop();
                timer3.stop();
                timer4.stop();
            }
        };
    @Getter
    private static Action MOVEPRESSS = new AbstractAction("MovePressS") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.getPlayer();
                e = ev;
                isDown=true;
                timer3.start();
                timer2.stop();
                timer1.stop();
                timer4.stop();
            }
        };
    @Getter
    private static Action MOVEPRESSD = new AbstractAction("MovePressD") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                p = DBmanager.getPlayer();
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
    @Getter
    private static Action MOVERELEASEW = new AbstractAction("MoveReleaseW") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(isDown){
                    timer1.stop();
                    isDown = false;
                }
            }
        };
    @Getter
    private static Action MOVERELEASEA = new AbstractAction("MoveReleaseA") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(isDown){
                    timer2.stop();
                    isDown = false;
                }
            }
        };
    @Getter
    private static Action MOVERELEASES = new AbstractAction("MoveReleaseS") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(isDown){
                    timer3.stop();
                    isDown = false;
                }
            }
        };
    @Getter
    private static Action MOVERELEASED = new AbstractAction("MoveReleaseD") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(isDown){
                    timer4.stop();
                    isDown = false;
                }
            }
        };    
    
    /////Interactions
    ////Handler
    ///Here
    @Getter
    private static Action INTERACT = new AbstractAction("Interact"){
        @Override
        public void actionPerformed(ActionEvent ev){
//                if(LevelDBmanager.CurrLevel.getNpcDB().inRange(DBmanager.getPlayer().getLocation())!= null){
//                    //interact with npc
//                }else{
//                    //open inventory
//                }
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
