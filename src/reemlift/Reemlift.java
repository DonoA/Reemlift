/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift;

import javax.swing.JFrame;
import reemlift.Utils.GamePanel;


/**
 *
 * @author Donovan
 */
public class Reemlift {
    private static JFrame frame;
    private static GamePanel gameFrame;
    private static void Setup(){
        frame = new JFrame("ReemLift");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize();
        frame.setVisible(true);
        gameFrame = new GamePanel();
        frame.add(gameFrame);
        
    }
    public static void main(String[] args) {
        Setup();
    }
}