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

package reemlift.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Donovan
 */
public class ActionHandler extends KeyAdapter/*implements ActionListener*/{
    
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);
//        if (key == KeyEvent.VK_LEFT) {
//            dx = -1;
//        }
//
//        if (key == KeyEvent.VK_RIGHT) {
//            dx = 1;
//        }
//
//        if (key == KeyEvent.VK_UP) {
//            dy = -1;
//        }
//
//        if (key == KeyEvent.VK_DOWN) {
//            dy = 1;
//        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
    
}
