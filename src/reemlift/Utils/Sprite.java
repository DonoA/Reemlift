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

package reemlift.Utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static reemlift.Reemlift.FileSep;

/**
 *
 * @author Donovan
 */
public class Sprite {
    
    private Image mask;
    
    private int X;
    
    private int Y;
    
    private String src;
    
    
    public Sprite(int x, int y, String mask){
        this.X = x;
        this.Y = y;
        this.src = mask;
        try {
            BufferedImage img = ImageIO.read(new File(src));
            this.mask = img.getScaledInstance(img.getHeight(), img.getWidth(), 0);
        } catch (IOException e) {
        }
    }
    public int getX(){return X;}
    public int getY(){return Y;}
    public void setY(int y){this.Y = y;}
    public void setX(int x){this.X = x;}
    public Image getMask(){return mask;}
    public void reloadMask(){this.mask = new ImageIcon(src).getImage();}
    protected void setMask(Image mask){this.mask = mask;}
    public void setSrc(String src){this.src = src;}
    
}
