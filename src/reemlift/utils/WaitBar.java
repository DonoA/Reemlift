/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift.utils;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Donovan
 */
public class WaitBar {
    public int Time;
//    public int currTime;
    public boolean otherAllowed;
    private JProgressBar Bar;
    private JFrame frame;
    private Task Dummy;
    private WaitBar.OptionClickEventHandler handler;
    public WaitBar(JFrame frame){
        this.frame = frame;
        Bar = new JProgressBar(0, 100);
        Bar.setValue(0);
        Bar.setStringPainted(true);
    }
    public void Show(int Time, boolean otherAllowed){
        this.otherAllowed = otherAllowed; 
        this.Time = Time;
        frame.getContentPane().add(Bar, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
    }
    public void Start(WaitBar.OptionClickEventHandler handler){
        this.handler = handler;
        Dummy = new Task();
        for(Component c : frame.getComponents()){
            c.setEnabled(otherAllowed);
        }
        Dummy.execute();
    }
    
    
    class Task extends SwingWorker<Void, Void> {
        @Override
        public Void doInBackground() {
            Random random = new Random();
            int progress = 0;
            while (progress < 100) {
                try {
                    Thread.sleep(random.nextInt(Time*10));
                } catch (InterruptedException ignore) {}
                progress += 1;
                setProgress(Math.min(progress, 100));
                Bar.setValue(progress);
            }
            return null;
        }
        @Override
        public void done() {
            WaitBar.OptionClickEvent event = new WaitBar.OptionClickEvent();
            handler.onOptionClick(event);
        }
    }
    
    public interface OptionClickEventHandler {
        public void onOptionClick(OptionClickEvent event);       
    }
    public class OptionClickEvent {
        private boolean close;
        private boolean destroy;
       
        public OptionClickEvent() {
            this.close = true;
            this.destroy = false;
        }
    }
}
