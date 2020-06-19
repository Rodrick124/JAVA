package com.company;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {
    private JButton ADD;
    private JButton REMOVE;
    private JButton EXIST;

    private StringListener textListener;

    public Toolbar(){

        setBorder(BorderFactory.createEtchedBorder());
        ADD = new JButton("ADD");
        REMOVE = new JButton("REMOVE");
        EXIST = new JButton("EXIST");

        ADD.addActionListener(this);
        REMOVE.addActionListener(this);
        EXIST.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.RIGHT));

        add(ADD);
        add(REMOVE);
        add(EXIST);
    }

    public void setStringListener(StringListener Listener){
        this.textListener = Listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if(clicked == ADD){
            if (textListener != null){
                textListener.textEmiter("Add the student\n");
            }
        }else if(clicked == REMOVE){
            if (textListener != null){
                textListener.textEmiter("Removed the student\n");
            }
        }else{
           if(textListener != null){
               textListener.textEmiter("Goodbye\n");
           }
        }
    }
}
