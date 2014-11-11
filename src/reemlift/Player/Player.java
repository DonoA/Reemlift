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

import java.io.File;
import static reemlift.Reemlift.FileSep;
import reemlift.Utils.Sprite;
import reemlift.Reemlift;

/**
 *
 * @author Donovan
 */
public class Player extends Sprite{
    
    public Player(){
        super(40, 60, Reemlift.Source + "Resources" + FileSep + "Sprites" + FileSep + "Player.jpg");
    }
    public void Move(int Dir){
        
    }
}
