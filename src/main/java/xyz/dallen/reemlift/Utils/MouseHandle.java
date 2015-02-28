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

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Timer;
import main.java.xyz.dallen.reemlift.Player.Shot;
import main.java.xyz.dallen.reemlift.Reemlift;
import main.java.xyz.dallen.reemlift.SaveData.DBmanager;

/**
 *
 * @author Donovan
 */
public class MouseHandle implements MouseMotionListener, MouseListener{

    private static final Timer timer = new Timer(DBmanager.getPlayer().getROF(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(isDown){
                        Shot holder = new Shot(0, 0, DBmanager.getPlayer().getDir());
                        Number x = DBmanager.getPlayer().getHitbox().getCenterX() - (holder.getHitbox().width/2);
                        Number y = DBmanager.getPlayer().getHitbox().getCenterY() - (holder.getHitbox().height/2);
                        Shot s = new Shot(x.intValue(), y.intValue(), DBmanager.getPlayer().getDir());
                        DBmanager.MovingShots.add(s);
                        DBmanager.ForRender.get(1).add(s);
                        Reemlift.getFrame().repaint();
                    }
                }
            });
    
    private static boolean isDown = false;
    
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        DBmanager.getPlayer().getCurrPL().updateAngle(
                getAngle(e.getLocationOnScreen(),
                        new Point(DBmanager.getPlayer().getLocation().x, DBmanager.getPlayer().getLocation().y)));
        LogUtil.debug("Mouse Move" + DBmanager.getPlayer().getCurrPL().getDir());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Shot holder = new Shot(0, 0, DBmanager.getPlayer().getDir());
        Number x = DBmanager.getPlayer().getHitbox().getCenterX() - (holder.getHitbox().width/2);
        Number y = DBmanager.getPlayer().getHitbox().getCenterY() - (holder.getHitbox().height/2);
        Shot s = new Shot(x.intValue(), y.intValue(), DBmanager.getPlayer().getDir());
        DBmanager.MovingShots.add(s);
        DBmanager.ForRender.get(1).add(s);
        Reemlift.getFrame().repaint();
        isDown=true;
        timer.start();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(isDown){
            timer.stop();
            isDown = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    public int getAngle(Point target, Point start) {
        float angle = (float) Math.toDegrees(Math.atan2(target.y - start.y, target.x - start.x));
        if(angle < 0){
            angle += 360;
        }
        return Math.round(angle);
    }
}
