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

import main.java.io.github.donoa.reemlift.Reemlift;
import static main.java.io.github.donoa.reemlift.Reemlift.FileSep;
import main.java.io.github.donoa.reemlift.Utils.Sprite;

/**
 *
 * @author Donovan
 */
public enum Block_Old{
    WALL(0, true, "Wall.jpg"),
    FLOOR(1, false, "Floor.jpg"),
    BLACK(2, true, "Black.jpg");
    
    private int id;
    
    private boolean solid;
    
    private String src;
    
    private Sprite sprite;
    
    private int X;
    
    private int Y;
    
    private Block_Old(int id, boolean solid, String src) {
        this.id = id;
        this.solid = solid;
        this.src = Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Block" + FileSep + src;
        
    }
    public void setLoc(int x, int y){
        this.Y = y;
        this.X = x;
    }
}
