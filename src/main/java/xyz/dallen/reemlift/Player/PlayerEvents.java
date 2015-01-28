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

import java.awt.Event;

/**
 *
 * @author Donovan
 */
public class PlayerEvents extends Event{

    public PlayerEvents(Object target, long when, int id, int x, int y, int key, int modifiers, Object arg) {
        super(target, when, id, x, y, key, modifiers, arg);
    }
    
}
