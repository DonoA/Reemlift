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

import main.java.xyz.dallen.reemlift.Player.Shot;
import main.java.xyz.dallen.reemlift.Reemlift;
import main.java.xyz.dallen.reemlift.SaveData.DBmanager;

/**
 *
 * @author Donovan
 */
public class MainLoop implements Runnable{

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
        Reemlift.getFrame().repaint();
        if(ActionHandler.getDown()[0]){
            DBmanager.getPlayer().Move("w");
        }
        if(ActionHandler.getDown()[1]){
            DBmanager.getPlayer().Move("a");
        }
        if(ActionHandler.getDown()[2]){
            DBmanager.getPlayer().Move("s");
        }
        if(ActionHandler.getDown()[3]){
            DBmanager.getPlayer().Move("d");
        }
    }
    
}
