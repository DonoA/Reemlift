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

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import main.java.xyz.dallen.reemlift.Reemlift;

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
        File source = new File(Reemlift.getSource() + "NPCdat" + Reemlift.getFileSep() + lvl + Reemlift.getFileSep());
        for(File f : source.listFiles()){
            try {
                npc hold = Reemlift.getJson().readValue(f, npc.class);
                hold.reloadMask();
                npcs.add(hold);
                
            } catch (IOException ex) {
                Logger.getLogger(npcDBmanager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public npc inRange(Rectangle HitBox){
        return null;
    }
    
}
