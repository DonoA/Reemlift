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

package main.java.io.github.donoa.reemlift.Player;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import main.java.io.github.donoa.reemlift.Reemlift;
import static main.java.io.github.donoa.reemlift.Reemlift.FileSep;
import main.java.io.github.donoa.reemlift.Utils.Sprite;

/**
 *
 * @author Donovan
 */
public class Shot extends Sprite{
    private int Dir;
    
    private static BufferedImage MaskUp;
    private static BufferedImage MaskDown;
    private static BufferedImage MaskRight;
    private static BufferedImage MaskLeft;
    public Shot(int X, int Y, int Dir){
        super(X, Y, "");
        this.Dir = Dir;
        try {
            MaskUp = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" + FileSep + "Shot" + FileSep + "Shot-Up.jpg"));
            MaskRight = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Shot" + FileSep + "Shot-Right.jpg"));
            MaskDown = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Shot" + FileSep + "Shot-Down.jpg"));
            MaskLeft = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Shot" + FileSep + "Shot-Left.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Shot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Update(){
        
    }
    
}
