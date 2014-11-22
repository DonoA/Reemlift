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

package main.java.io.github.donoa.reemlift.Utils.Level;

import java.awt.Graphics2D;
import java.util.HashMap;
import main.java.io.github.donoa.reemlift.Reemlift;

/**
 *
 * @author Donovan
 */
public class LevelDBmanager {
    
    public static LevelClass CurrLevel;
    
    public static void LoadLevel(String Level){
        
    }
    
    public static boolean DrawLevel(Graphics2D g2d){
        int X = CurrLevel.getBlocks().length;
        for(int x=0; x<X; x++){
            int Y = CurrLevel.getBlocks()[x].length;
            for(int y=0; y<Y; y++){
                g2d.drawImage(CurrLevel.getBlocks()[x][y].getMask(), x*10, y*10, Reemlift.gameFrame);
            }
        }
        return true;
    }
}
