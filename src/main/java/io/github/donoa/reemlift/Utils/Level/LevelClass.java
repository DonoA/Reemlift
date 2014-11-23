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

import java.awt.Rectangle;

/**
 *
 * @author Donovan
 */
public class LevelClass {
    private Block[][] Blocks;
    
//    public Level(int i){}
    public LevelClass(Block[][] blocks){
        Blocks = blocks;
    }
    
    public Block[][] getBlocks(){return Blocks;}
    
    public boolean HasHit(Rectangle HitBox){
        Number dx1 = (HitBox.getMaxX()/10);
        Number dy1 = (HitBox.getMaxY()/10);
        Number dx2 = (HitBox.getMinX()/10);
        Number dy2 = (HitBox.getMinY()/10);
        System.out.println(dx1.intValue() + ", " + dy1.intValue() + " : " + dx2.intValue() + ", " + dy2.intValue());
        for(int x  = dx2.intValue(); x<= dx1.intValue(); x++){
            for(int y = dy2.intValue(); y<= dy1.intValue(); y++){
                Block b = Blocks[x][y];
                if(b.isSolid()){
                    System.out.println("Hit" + x + " " + y);
                    return true;
                }
            }
        }
        return false;
    }
}
