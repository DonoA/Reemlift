/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift.utils;


import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Donovan
 */
public class WaitBar extends JProgressBar{
    public int Time;
//    public int currTime;
    public boolean isFake;
//    private JProgressBar Bar;
    private JFrame frame;
    private Task Dummy;
    private WaitBar.OptionClickEventHandler handler;
    public WaitBar(JFrame frame){
        super(0, 100);
        setValue(0);
        setStringPainted(true);
        this.frame = frame;
    }
//    public void Show(boolean isFake){
//        this.isFake = isFake; 
//        frame.getContentPane().add(this, BorderLayout.PAGE_END);
//        frame.revalidate();
//        frame.repaint();
//    }
    public void Start(int Time, WaitBar.OptionClickEventHandler handler, boolean isFake){
        this.isFake = isFake; 
        this.Time = Time;
        this.handler = handler;
        if(isFake){
            Dummy = new Task();
            Dummy.execute();
        }
    }
    public void setProg(int prog){
        setValue(prog);
    }
    public void unload(){
        frame.getContentPane().remove(this);
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
                setValue(progress);
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
