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

package main.java.xyz.dallen.reemlift.SaveData;

import java.util.ArrayList;
import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
import main.java.xyz.dallen.reemlift.Player.Player;
import main.java.xyz.dallen.reemlift.Player.Shot;
import main.java.xyz.dallen.reemlift.Utils.Sprite;

/**
 *
 * @author Donovan
 */
public class DBmanager {
    @Getter @Setter
    private static Player player;
    
    public static ArrayList<Shot> MovingShots = new ArrayList<>();
    
    public static HashMap<Integer, ArrayList<Sprite>> ForRender = new HashMap<Integer, ArrayList<Sprite>>();
    
}
