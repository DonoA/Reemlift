/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift.utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import reemlift.Game;

/**
 *
 * @author Donovan
 */
public class Menu implements ActionListener{
    public List<String> ops = new ArrayList<String>();
    public HashMap<Integer, JButton> btns = new HashMap<>();
    private OptionClickEventHandler handler;
    private static final ScheduledExecutorService worker = 
                         Executors.newSingleThreadScheduledExecutor();
    private JFrame frame;
    private JPanel buttonPane = new JPanel();
    public Menu(JFrame frame, OptionClickEventHandler handler){
        buttonPane.setLayout(new GridBagLayout());
        this.handler = handler;
        this.frame = frame;
    }
    public void show(String doc){
        int pt = 0;
        int pt2=0;
        GridBagConstraints gbc = new GridBagConstraints();
        for(int i : btns.keySet()){
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = pt2;
            gbc.gridy = pt;
            gbc.ipady = 10;
            buttonPane.add(buttonPane.add(btns.get(i)), gbc);
            if(pt == 11){
                pt2++;
                pt = 0;
            }else{
                pt++;
            }
        }
        frame.getContentPane().add(buttonPane, doc);
        frame.revalidate();
        frame.repaint();
    }
    public Menu addOP(int pos, String name, String tip){
        JButton btn = new JButton(name);
        btn.addActionListener(this);
        btn.setToolTipText(tip);
        btn.setActionCommand(name);
        btns.put(pos, btn);
        return this;
    }
//    public void setEnabled(boolean enabled){
//        for(){
//            buttonPane.removeAll();
//            buttonPane.add(btns.get(i));
//        }
//        frame.getContentPane().add(buttonPane, BorderLayout.PAGE_START);
//        frame.revalidate();
//        frame.repaint();
//    }
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
                }
//                else if(event.willDisable()){
//                    setEnabled(false);
//                }
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
