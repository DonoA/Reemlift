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

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import lombok.Getter;

/**
 *
 * @author Donovan
 */
public class ActionHandler extends KeyAdapter{
    
    @Getter
    private static boolean Down[] = {false, false, false, false};
    
    
    //////Press
    /////Events
    ////Here
    @Getter
    private static Action MOVEPRESSW = new AbstractAction("MovePressW") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                Down[0]=true;
            }
        };
    @Getter
    private static Action MOVEPRESSA = new AbstractAction("MovePressA") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                Down[1]=true;
            }
        };
    @Getter
    private static Action MOVEPRESSS = new AbstractAction("MovePressS") {
            @Override
            public void actionPerformed(ActionEvent ev) {
               Down[2]=true;
            }
        };
    @Getter
    private static Action MOVEPRESSD = new AbstractAction("MovePressD") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                Down[3]=true;
            }
        };
    /////Key
    ////Release
    ///Here
    @Getter
    private static Action MOVERELEASEW = new AbstractAction("MoveReleaseW") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                    Down[0] = false;
            }
        };
    @Getter
    private static Action MOVERELEASEA = new AbstractAction("MoveReleaseA") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                    Down[1] = false;
            }
        };
    @Getter
    private static Action MOVERELEASES = new AbstractAction("MoveReleaseS") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                    Down[2] = false;
            }
        };
    @Getter
    private static Action MOVERELEASED = new AbstractAction("MoveReleaseD") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                    Down[3] = false;
            }
        };    
    
    
    
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
    
}
