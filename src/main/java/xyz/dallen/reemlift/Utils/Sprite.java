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

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Donovan
 */
public class Sprite {
    @Getter @Setter @JsonIgnore
    private Image mask;
    
    @Getter @Setter
    private int X;
    
    @Getter @Setter
    private int Y;
    
    @Getter @Setter
    private String src;
    
    @Getter @Setter  @JsonIgnore
    private int Dir;
    
    @Getter @Setter  @JsonIgnore
    private AffineTransformOp TransOp;
    
    @Getter @Setter  @JsonIgnore
    private BufferedImage BuffMask;
    
    @Getter @Setter  @JsonIgnore
    private Rectangle Hitbox;
    
    public Sprite(){}
    
    public Sprite(int x, int y, String mask){
        this.X = x;
        this.Y = y;
        this.src = mask;
        
        try {
            this.mask = ImageIO.read(new File(src));
            this.BuffMask = ImageIO.read(new File(src));
        } catch (IOException e) {
        }
    }
    public void reloadMask(){try {
            this.mask = ImageIO.read(new File(src));
        } catch (IOException e) {
        }}
}
