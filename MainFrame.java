package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * the main frame containing the control panel and the design panel
 */
public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    public DesignPanel designPanel;

    public MainFrame(String title)
    {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controlPanel=new ControlPanel(this);
        designPanel=new DesignPanel(this);

        getContentPane().setLayout(new BorderLayout());

        add(controlPanel,BorderLayout.NORTH);
        add(designPanel,BorderLayout.CENTER);

        pack();
    }

}