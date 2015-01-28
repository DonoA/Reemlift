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

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Donovan
 */
public class Location {
    @Getter @Setter 
    private int X;
    @Getter @Setter
    private int Y;
    
    @Getter @Setter
    private int Dir;
    
    public Location(){}
    
    public Location(int x, int y, int dir){
        this.X = x;
        this.Y = y;
        this.Dir = dir;
    }
    
    public double dist(Location loc){
        return Math.sqrt((loc.getX()-getX())*(loc.getX()-getX()) + (loc.getY()-getY())*(loc.getY()-getY()));
        //int a = (int) Math.round(doubleVar);
    }
    
    public boolean inLine(Location loc){
        if(Dir==0){
            
        }else if(Dir==1){
            
        }else if(Dir==2){
            
        }else if(Dir==3){
            
        }
        return false;
    }
}
