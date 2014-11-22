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

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.java.io.github.donoa.reemlift.Reemlift;
import static main.java.io.github.donoa.reemlift.Reemlift.FileSep;
import main.java.io.github.donoa.reemlift.Utils.Level.LevelDBmanager;
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
    
    private final int ROF = 1000/5;
    
    private Rectangle HitBox;
    
    private final int speed = 3;
    public Player(){
        super(40, 60, Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Player-Up.png");
        HitBox = new Rectangle(40, 60, super.getBuffMask().getWidth(), super.getBuffMask().getHeight());
        try {
            maskUp = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Player-Up.png"));
            maskRight = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Player-Right.png"));
            maskDown = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Player-Down.png"));
            maskLeft = ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Player-Left.png"));
        } catch (IOException e) {
        }
    }
    public void Move(String Dir){
        if(Dir.equals("w")){
            if(!LevelDBmanager.CurrLevel.HasHit(new Rectangle(getX(), getY()-speed, HitBox.width, HitBox.height)))
                setY(getY()-speed);
            super.setMask(maskUp);
            super.setDir(0);
            super.setBuffMask(maskUp);
        }else if(Dir.equals("a")){
            if(!LevelDBmanager.CurrLevel.HasHit(new Rectangle(getX()-speed, getY(), HitBox.width, HitBox.height)))
                setX(getX()-speed);
            super.setMask(maskLeft);
            super.setDir(3);
            super.setBuffMask(maskLeft);
        }else if(Dir.equals("s")){
            if(!LevelDBmanager.CurrLevel.HasHit(new Rectangle(getX(), getY()+speed, HitBox.width, HitBox.height)))
                setY(getY()+speed);
            super.setMask(maskDown);
            super.setDir(2);
            super.setBuffMask(maskDown);
        }else if(Dir.equals("d")){
            if(!LevelDBmanager.CurrLevel.HasHit(new Rectangle(getX()+speed, getY(), HitBox.width, HitBox.height)))
                setX(getX()+speed);
            super.setMask(maskRight);
            super.setDir(1);
            super.setBuffMask(maskRight);
        }
        Reemlift.gameFrame.repaint();
    }
//    
//    private void reCalcHitBox(){
//        HitBox = new Rectangle(new Dimension(BuffMask.getWidth(), BuffMask.getHeight()));
//    }
//    
    public int getROF(){return this.ROF;}
}
