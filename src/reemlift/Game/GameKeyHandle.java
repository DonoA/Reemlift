/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift.Game;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Donovan
 */
class GameKeyHandle {

    public GameKeyHandle(JFrame frame) {
        JPanel jp = new JPanel();
        //inventory handle
        Action InvenAct = new AbstractAction("InventoryPress") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("killa");
            }
        };
        jp.getActionMap().put("InventoryPress", InvenAct);
        jp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('i'), "InventoryPress");
        
        frame.add(jp);
    }
    
}
