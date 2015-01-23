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

package main.java.xyz.dallen.reemlift.Player;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import main.java.xyz.dallen.reemlift.Reemlift;
import static main.java.xyz.dallen.reemlift.Reemlift.FileSep;
import main.java.xyz.dallen.reemlift.Utils.Level.LevelDBmanager;
import main.java.xyz.dallen.reemlift.Utils.Sprite;

/**
 *
 * @author Donovan
 */
public class Shot extends Sprite{
    private int Dir;
    
    private int speed = 5;
    
    public boolean dead = false;
    
    public Shot(int X, int Y, int Dir){
        super(X, Y, "");
        this.Dir = Dir;
        if(this.Dir == 0){
            try {
                super.setBuffMask(ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" + FileSep + "Shot" + FileSep + "Shot-Up.png")));
                super.setMask(ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" + FileSep + "Shot" + FileSep + "Shot-Up.png")));
            } catch (IOException ex) {
                Logger.getLogger(Shot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(this.Dir == 1){
            try {
                super.setBuffMask(ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" + FileSep + "Shot" + FileSep + "Shot-Right.png")));
                super.setMask(ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Shot" + FileSep + "Shot-Right.png")));
            } catch (IOException ex) {
                Logger.getLogger(Shot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(this.Dir == 2){
            try {
                super.setBuffMask(ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" + FileSep + "Shot" + FileSep + "Shot-Down.png")));
                super.setMask(ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Shot" + FileSep + "Shot-Down.png")));
            } catch (IOException ex) {
                Logger.getLogger(Shot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(this.Dir == 3){
            try {
                super.setBuffMask(ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" + FileSep + "Shot" + FileSep + "Shot-Left.png")));
                super.setMask(ImageIO.read(new File(Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player" +  FileSep + "Shot" + FileSep + "Shot-Left.png")));
            } catch (IOException ex) {
                Logger.getLogger(Shot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setHitBox(new Rectangle(getX(),getY(), super.getBuffMask().getWidth(), super.getBuffMask().getHeight()));
    }
    public void Update(){
        if(Dir == 0){
            if(!LevelDBmanager.CurrLevel.HasHit(new Rectangle(getX(), getY()-speed, getHitBox().width, getHitBox().height))){
                setY(getY()-speed);
            }else{
                dead = true;
            }
        }else if(Dir == 3){
            if(!LevelDBmanager.CurrLevel.HasHit(new Rectangle(getX()-speed, getY(), getHitBox().width, getHitBox().height))){
                setX(getX()-speed);
            }else{
                dead = true;
            }
        }else if(Dir == 2){
            if(!LevelDBmanager.CurrLevel.HasHit(new Rectangle(getX(), getY()+speed, getHitBox().width, getHitBox().height))){
                setY(getY()+speed);
            }else{
                dead = true;
            }
        }else if(Dir == 1){
            if(!LevelDBmanager.CurrLevel.HasHit(new Rectangle(getX()+speed, getY(), getHitBox().width, getHitBox().height))){
                setX(getX()+speed);
            }else{
                dead = true;
            }
        }
        if(getX()<0 || getY()<0 || getY()>Reemlift.frame.getHeight() || getX()>Reemlift.frame.getWidth()){
            dead = true;
        }
    }
    
}
