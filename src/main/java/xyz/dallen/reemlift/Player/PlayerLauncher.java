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

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Random;
import main.java.xyz.dallen.reemlift.Reemlift;
import main.java.xyz.dallen.reemlift.SaveData.DBmanager;
import main.java.xyz.dallen.reemlift.Utils.LogUtil;
import main.java.xyz.dallen.reemlift.Utils.Sprite;

/**
 *
 * @author Donovan
 */
public class PlayerLauncher extends Sprite{
    
    private double currentRotation = 0;
    
    private AffineTransform atf = new AffineTransform();
    
    private final String type;
    
    public PlayerLauncher(Point loc, String type){
        super(loc.x, loc.y, Reemlift.getSource() + "Resources" + 
                     Reemlift.getFileSep() + "Sprites" + 
                     Reemlift.getFileSep() + "Player" +  
                     Reemlift.getFileSep() + "Launchers" + 
                     Reemlift.getFileSep() + type + ".png");
        super.reloadMask();
        this.type = type;
        super.setRotated(true);
    }
    
    public void updateAngle(double Dir){
//        BufferedImage Img = new BufferedImage(getBuffMask().getWidth(), getBuffMask().getHeight(), BufferedImage.TYPE_BYTE_INDEXED);
//        Img.getGraphics().drawImage(getBuffMask(), 0, 0, null);
////        atf.translate(0, Img.getHeight() / 2);
//        int rand = new Random().nextInt(360);
//        LogUtil.debug(rand);
//        atf.rotate(/*Math.PI*((/*Dir-currentRotation/ rand)/360)*/ 0.5,0 ,0);
////        atf.translate(0, -Img.getHeight()/2);
//        AffineTransformOp op = new AffineTransformOp(atf, AffineTransformOp.TYPE_BILINEAR);
//        currentRotation = Dir;
//        BufferedImage hold = new BufferedImage(Img.getWidth(), Img.getHeight(), BufferedImage.TYPE_BYTE_INDEXED);
//        op.filter(Img, hold);
//        setBuffMask(hold);
        AffineTransform at = new AffineTransform();
        at.translate(DBmanager.getPlayer().getLocation().x + ((DBmanager.getPlayer().getBuffMask().getWidth()/2) - getBuffMask().getWidth()/2), DBmanager.getPlayer().getLocation().y + (DBmanager.getPlayer().getBuffMask().getHeight()/2)- (getBuffMask().getHeight()/2));
//        currentRotation++;
        at.rotate(Math.PI * Dir);
//        at.translate(-getBuffMask().getWidth()/2, -getBuffMask().getHeight()/2);
        super.setTrans(at);
    }
}
