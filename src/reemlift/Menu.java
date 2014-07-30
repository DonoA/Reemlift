/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author Donovan
 */
public class Menu implements ActionListener{
    public List<String> ops = new ArrayList<String>();
    public HashMap<String, JButton> btns = new HashMap<>();
    private OptionClickEventHandler handler;
    private static final ScheduledExecutorService worker = 
                         Executors.newSingleThreadScheduledExecutor();
    private JFrame frame;
    private JPanel buttonPane = new JPanel();
    public Menu(List<String> ops, boolean hasBack, JFrame frame, OptionClickEventHandler handler){
        this.handler = handler;
        this.frame = frame;
        this.ops.addAll(ops);
        if(hasBack || ops.isEmpty()){
            this.ops.add("back");
        }
        for(String s : ops){
            JButton btn = new JButton(s);
            btn.addActionListener(this);
            btn.setActionCommand(s);
            btns.put(s, btn);
        }
        
    }
    public void show(){
        for(JButton btn : btns.values()){
            buttonPane.add(btn);
        }
        frame.getContentPane().add(buttonPane, BorderLayout.WEST);
        frame.repaint();
//        frame.pack();
    }
    public void addOP(String s){
        ops.add(s);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String name = e.getActionCommand();
        JButton btn = btns.get(name);
        OptionClickEvent event = new OptionClickEvent(btn, name);
        handler.onOptionClick(event);
        if(event.willClose()){
            Runnable clear = new Runnable() {
                @Override
                public void run() {
                  frame.getContentPane().remove(buttonPane);
                  frame.repaint();
                }
              };
            worker.schedule(clear, 5, TimeUnit.MILLISECONDS);
        }
    }
    
    public interface OptionClickEventHandler {
        public void onOptionClick(OptionClickEvent event);       
    }
    public class OptionClickEvent {
        private int pos;
        private String name;
        private boolean close;
        private boolean destroy;
       
        public OptionClickEvent(JButton btn, String name) {
//            this.pos = pos;
            this.name = name;
            this.close = true;
            this.destroy = false;
        }
       
//        public int getPos() {
//            return pos;
//        }
//        
        public String getName() {
            return name;
        }
       
        public boolean willClose() {
            return close;
        }
       
        public boolean willDestroy() {
            return destroy;
        }
       
        public void setWillClose(boolean close) {
            this.close = close;
        }
       
        public void setWillDestroy(boolean destroy) {
            this.destroy = destroy;
        }
    }
}
