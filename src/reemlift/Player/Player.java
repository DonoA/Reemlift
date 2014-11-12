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

package reemlift.Player;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import reemlift.Reemlift;
import static reemlift.Reemlift.FileSep;
import reemlift.Utils.ActionHandler;
import reemlift.Utils.Sprite;

/**
 *
 * @author Donovan
 */
public class Player extends Sprite{
    private Image maskUp;
    private Image maskRight;
    private Image maskLeft;
    private Image maskDown;
    public Player(){
        super(40, 60, Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player.jpg");
        try {
            BufferedImage img = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player-Up.jpg"));
            maskUp = img.getScaledInstance(img.getHeight(), img.getWidth(), 0);
            img = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player-Right.jpg"));
            maskRight = img.getScaledInstance(img.getHeight(), img.getWidth(), 0);
            img = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player-Down.jpg"));
            maskDown = img.getScaledInstance(img.getHeight(), img.getWidth(), 0);
            img = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player-Left.jpg"));
            maskLeft = img.getScaledInstance(img.getHeight(), img.getWidth(), 0);
        } catch (IOException e) {
        }
    }
    public void Move(String Dir){
        if(Dir.equals("w")){
            setY(getY()-2);
            super.setMask(maskUp);
        }else if(Dir.equals("a")){
            setX(getX()-2);
            super.setMask(maskLeft);
        }else if(Dir.equals("s")){
            setY(getY()+2);
            super.setMask(maskDown);
        }else if(Dir.equals("d")){
            setX(getX()+2);
            super.setMask(maskRight);
        }
        Reemlift.gameFrame.repaint();
    }
}
