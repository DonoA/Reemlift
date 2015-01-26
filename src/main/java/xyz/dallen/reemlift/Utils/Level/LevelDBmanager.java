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

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import main.java.xyz.dallen.reemlift.Reemlift;

/**
 *
 * @author Donovan
 */
public class LevelDBmanager {
    @Getter
    public static LevelClass CurrLevel;
    
    public static void LoadLevel(String Level){
        File save = new File(Reemlift.getSource() + "Resources" + Reemlift.getFileSep() + "Levels" + Reemlift.getFileSep() + Level + ".level");
        try {
            Scanner in = new Scanner(save);
            int maxX = 0;
            List<List<String>> BlokIdArray = new ArrayList<>();
            while(in.hasNext()){
                String line = in.nextLine();
                List<String> hold = Arrays.asList(line.split("\\s*,\\s*"));
                BlokIdArray.add(hold);
                if(hold.size()>maxX){
                    maxX = hold.size();
                    
                }
            }
            
            Block[][] blox = new Block[maxX][BlokIdArray.size()];
            System.out.print("Loading Level:  ");
            for(int y = 0; y<BlokIdArray.size(); y++){
                System.out.print("#");
                for(int x = 0; x<BlokIdArray.get(y).size(); x++){
                    blox[x][y] = new Block(x,y, Integer.parseInt(BlokIdArray.get(y).get(x)));
                }
            }
            CurrLevel = new LevelClass(blox, Level);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LevelDBmanager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }
    
    public static boolean DrawLevel(Graphics2D g2d){
        int X = CurrLevel.getBlocks().length;
        for(int x=0; x<X; x++){
            int Y = CurrLevel.getBlocks()[x].length;
            for(int y=0; y<Y; y++){
                g2d.drawImage(CurrLevel.getBlocks()[x][y].getMask(), x*10, y*10, Reemlift.getGameFrame());
//                g2d.draw(CurrLevel.getBlocks()[x][y].HitBox);
            }
        }
        return true;
    }
}
