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

import lombok.Getter;
import main.java.xyz.dallen.reemlift.Utils.Sprite;

/**
 *
 * @author Donovan
 */
public class Item {
    
    @Getter
    private Sprite Mask;
    
    @Getter
    private ItemType Type;
    
    public Item(){
        
    }
    
}
