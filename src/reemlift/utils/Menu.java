/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift.utils;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
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
    private JPanel buttonPane = new JPanel(new GridLayout(2,3));
    public Menu(List<String> ops, boolean hasBack, JFrame frame, OptionClickEventHandler handler){
        this.handler = handler;
        this.frame = frame;
        this.ops.addAll(ops);
        if(hasBack || ops.isEmpty()){
            this.ops.add("back");
        }
        for(String s : this.ops){
            JButton btn = new JButton(s);
            btn.addActionListener(this);
            btn.setActionCommand(s);
//            btn.setSize(new Dimension(100, 100));
//            btn.setMinimumSize(new Dimension(100, 100));
            btns.put(s, btn);
        }
//        System.out.println(btns.keySet());
    }
    public void show(){
        int col = 1;
        int row = 1;
        for(JButton btn : btns.values()){
            buttonPane.removeAll();
            buttonPane.add(btn);
//            frame.getContentPane().add(buttonPane, BorderLayout.WEST);
        }
        frame.getContentPane().add(buttonPane, BorderLayout.NORTH);
//        frame.getContentPane().add(buttonPane, BorderLayout.WEST);
        frame.revalidate();
        frame.repaint();
    }
    public void addOP(String s){
        ops.add(s);
    }
    public void setEnabled(boolean enabled){
        for(JButton btn : btns.values()){
            buttonPane.removeAll();
            buttonPane.add(btn);
            frame.getContentPane().add(buttonPane, BorderLayout.AFTER_LAST_LINE);
        }
        frame.getContentPane().add(buttonPane, BorderLayout.WEST);
        frame.revalidate();
        frame.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String name = e.getActionCommand();
        JButton btn = btns.get(name);
        final OptionClickEvent event = new OptionClickEvent(btn, name);
        handler.onOptionClick(event);
        Runnable clear = new Runnable() {
            @Override
            public void run() {
                if(event.willClose()){
                    frame.getContentPane().remove(buttonPane);
                    frame.revalidate();
                    frame.repaint();
                }else if(event.willDisable()){
                    setEnabled(false);
                }
            }
          };
        worker.schedule(clear, 5, TimeUnit.MILLISECONDS);
    }
    
    public interface OptionClickEventHandler {
        public void onOptionClick(OptionClickEvent event);       
    }
    public class OptionClickEvent {
        private int pos;
        private String name;
        private boolean close;
        private boolean destroy;
        private boolean disable;
       
        public OptionClickEvent(JButton btn, String name) {
//            this.pos = pos;
            this.name = name;
            this.close = true;
            this.destroy = false;
            this.disable = false;
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
        public boolean willDisable() {
            return this.disable;
        }
        public void setWillClose(boolean close) {
            this.close = close;
        }
       
        public void setWillDestroy(boolean destroy) {
            this.destroy = destroy;
        }
        public void setWillDisable(boolean destroy) {
            this.disable = destroy;
        }
    }
}
