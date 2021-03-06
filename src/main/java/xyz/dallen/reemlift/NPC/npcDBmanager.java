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

package main.java.xyz.dallen.reemlift.NPC;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import main.java.xyz.dallen.reemlift.Reemlift;
import main.java.xyz.dallen.reemlift.SaveData.DBmanager;
import main.java.xyz.dallen.reemlift.Utils.LogUtil;

/**
 *
 * @author Donovan
 */
public class npcDBmanager {
    @Getter
    private ArrayList<npc> npcs = new ArrayList<>();
    
    public npcDBmanager(){

    }
    
    public void LoadNpcs(String lvl){
        File source = new File(Reemlift.getSource() + "Resources" + Reemlift.getFileSep() + "NPCdat" + Reemlift.getFileSep() + lvl + Reemlift.getFileSep());
        for(File f : source.listFiles()){
            try {
                npc hold = Reemlift.getJson().readValue(f, npc.class);
                hold.setSrc(Reemlift.getSource() + "Resources" + Reemlift.getFileSep() + "Sprites" + Reemlift.getFileSep() + "NPC" + Reemlift.getFileSep() + hold.getSrc());
                hold.reloadMask();
                npcs.add(hold);
                DBmanager.ForRender.get(1).add(hold);
                LogUtil.debug("added npc " + hold.getName());
            } catch (IOException ex) {
                Logger.getLogger(npcDBmanager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
//    public npc inRange(Point  loc){ 
//        for(npc n1 : npcs){
//            if(loc.dist(n1.getLocation()) < 20 && loc.inLine(n1.getLocation())){
//                    return n1;
//            }
//        }
//        return null;
//    }
    
}
