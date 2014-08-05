/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift.utils;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author Donovan
 */
public class Console extends JTextArea{
    private String PrintingText = "";
    private Task printer = new Task();
    private int Time;
    private boolean endCurrTask = false;
    public Console(int y, int x, boolean editable){
        super(y, x);
        setMaximumSize(new Dimension(400, 100));
        setEditable(editable);
        setLineWrap(true);
    }
    @Override
    public void setText(String text){
        printer.cancel(true);
        super.setText("");
        Time = -1;
        printer = new Task();
        PrintingText=text;
        printer.execute();
    }
    public void setTextTimed(String text, int Time){
        endCurrTask = true;
        super.setText("");
        this.Time = Time;
        printer = new Task();
        PrintingText=text;
        printer.execute();
    }
    public void Show(JFrame frame, String doc){
        JPanel root = new JPanel(new FlowLayout());
        root.add(this);
        frame.getContentPane().add(new JScrollPane(root), doc);
    }
    class Task extends SwingWorker<Void, Void> {
        @Override
        public Void doInBackground() {
            for(char c : PrintingText.toCharArray()){
                if(endCurrTask){
                    endCurrTask = false;
                    Thread.currentThread().interrupt();
                }
                try {
                    if(Time == -1){
                        Thread.sleep(25);
                    }else{
                        Thread.sleep(Time);
                    }
                } catch (InterruptedException ignore) {}
//                Thread.currentThread().interrupt();
                append(String.valueOf(c));
            }
            return null;
            
        }
        public void End(){
            Thread.currentThread().interrupt();
        }
//        @Override
//        public void done() {
//            
//        }
    }
}
