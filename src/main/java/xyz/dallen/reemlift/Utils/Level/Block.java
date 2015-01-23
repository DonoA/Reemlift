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

package main.java.xyz.dallen.reemlift.Utils.Level;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import main.java.xyz.dallen.reemlift.Reemlift;
import static main.java.xyz.dallen.reemlift.Reemlift.FileSep;
import main.java.xyz.dallen.reemlift.Utils.Sprite;

/**
 *
 * @author Donovan
 */
public class Block extends Sprite{
    
    private boolean Solid;
    
    protected Rectangle HitBox;
    
    public Block(int X, int Y, int ID){
        super(X,Y, Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Block" + FileSep + "Wall.jpg");
        if(ID == 0){try {
            //Wall
            super.setMask(ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Block" + FileSep + "Wall.jpg")));
            } catch (IOException ex) {
                Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
            }
            Solid = true;
        }else if(ID == 1){try {
            //Floor
            super.setMask(ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Block" + FileSep + "Floor.jpg")));
            } catch (IOException ex) {
                Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
            }
            Solid = false;
        }else if(ID == 2){try {
            //Void
            super.setMask(ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Block" + FileSep + "Void.jpg")));
            } catch (IOException ex) {
                Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
            }
            Solid = true;
        }
        HitBox = new Rectangle(X*10,Y*10,10,10);
    }
    
    public boolean isSolid(){return this.Solid;}
}
