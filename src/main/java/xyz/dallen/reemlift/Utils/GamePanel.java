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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import main.java.xyz.dallen.reemlift.Player.Player;
import main.java.xyz.dallen.reemlift.Reemlift;
import main.java.xyz.dallen.reemlift.SaveData.DBmanager;
import main.java.xyz.dallen.reemlift.Utils.Level.LevelDBmanager;

/**
 *
 * @author Donovan
 */
public class GamePanel extends JPanel{
    
    public GamePanel(){
        
        DBmanager.setPlayer(new Player());
        
        getActionMap().put("MovePressW", ActionHandler.getMOVEPRESSW());
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "MovePressW");
        getActionMap().put("MovePressA", ActionHandler.getMOVEPRESSA());
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "MovePressA");
        getActionMap().put("MovePressS", ActionHandler.getMOVEPRESSS());
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "MovePressS");
        getActionMap().put("MovePressD", ActionHandler.getMOVEPRESSD());
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "MovePressD");
        
        getActionMap().put("MoveReleaseW", ActionHandler.getMOVERELEASEW());
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "MoveReleaseW");
        getActionMap().put("MoveReleaseA", ActionHandler.getMOVERELEASEA());
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "MoveReleaseA");
        getActionMap().put("MoveReleaseS", ActionHandler.getMOVERELEASES());
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "MoveReleaseS");
        getActionMap().put("MoveReleaseD", ActionHandler.getMOVERELEASED());
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "MoveReleaseD");

        MouseHandle mh = new MouseHandle();
        super.addMouseListener(mh);
        super.addMouseMotionListener(mh);
        
//        getActionMap().put("Interact", ActionHandler.getFIRETAP());
//        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0, false), "Interact");

        addKeyListener(new ActionHandler());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
        Reemlift.getMainTimer().start();
        LevelDBmanager.LoadLevel("2");
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        if(!LevelDBmanager.DrawLevel(g2d)){
            Logger.getLogger(LevelDBmanager.class.getName()).log(Level.SEVERE, null, "Err");
        }
        
        if(!DBmanager.ForRender.isEmpty()){
            for(Integer i : DBmanager.ForRender.keySet()){
                for(Sprite s : DBmanager.ForRender.get(i)){
                    if(s.isRotated()){
                        g2d.drawImage(s.getBuffMask(), s.getTrans(), null);
                    }else{
                        g2d.drawImage(s.getMask(), s.getLocation().x, s.getLocation().y, this);
//                        LogUtil.debug(s.toString());
                    }
                }
            }
        }
        
        g2d.draw(DBmanager.getPlayer().getHitbox());
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
//        repaint();
    }
}
