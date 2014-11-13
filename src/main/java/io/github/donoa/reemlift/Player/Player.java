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
import javax.imageio.ImageIO;
import main.java.io.github.donoa.reemlift.Reemlift;
import static main.java.io.github.donoa.reemlift.Reemlift.FileSep;
import main.java.io.github.donoa.reemlift.Utils.Sprite;

/**
 *
 * @author Donovan
 */
public class Player extends Sprite{
    private BufferedImage maskUp;
    private BufferedImage maskRight;
    private BufferedImage maskLeft;
    private BufferedImage maskDown;
    
    private int speed = 3;
    public Player(){
        super(40, 60, Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Player-Up.jpg");
        try {
            maskUp = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Player-Up.jpg"));
            maskRight = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Player-Right.jpg"));
            maskDown = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Player-Down.jpg"));
            maskLeft = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Player-Left.jpg"));
        } catch (IOException e) {
        }
    }
    public void Move(String Dir){
        if(Dir.equals("w")){
            setY(getY()-speed);
            super.setMask(maskUp);
        }else if(Dir.equals("a")){
            setX(getX()-speed);
            super.setMask(maskLeft);
        }else if(Dir.equals("s")){
            setY(getY()+speed);
            super.setMask(maskDown);
        }else if(Dir.equals("d")){
            setX(getX()+speed);
            super.setMask(maskRight);
        }
        Reemlift.gameFrame.repaint();
    }
}
