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
        int x = HitBox.x/10;
        int y = HitBox.y/10;
        Block b = Blocks[x][y];
        if(b.isSolid()){
            System.out.println();
            return b.HitBox.intersects(HitBox);
        }else{
            return false;
        }
    }
}
