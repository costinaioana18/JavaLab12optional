package com.company;

import javax.swing.*;

/**
 * The DesignPanel represents a simple JPanel, displaying the components the user added
 * It has an editing method, which edits the name of the last added button
 */
public class DesignPanel extends JPanel {
    final MainFrame frame;
    JButton lastButton;

    public DesignPanel(MainFrame frame)
    {
        this.frame=frame;
    }

    /**
     * the method adds a neu ComboBox when the user adds one
     * @param name the name of the comboBox
     */
    public void addCombo(String name)
    {
        JLabel label;
        JComboBox comp;
        label=new JLabel(name);
        String[] types = {"", "", "", ""};
        comp = new JComboBox(types);
        comp.setSelectedIndex(0);
        this.add(label);
        this.add(comp);
        this.revalidate();
        this.repaint();

    }

    /**
     * the method adds a new textField when the user wants to
     * @param name
     */
    public void addField(String name)
    {

        JLabel labelF;
        JTextField field;

        labelF=new JLabel(name);
        field=new JTextField(10);

        this.add(labelF);
        this.add(field);
        this.revalidate();
        this.repaint();

    }

    /**
     * the method adds a new button when the user wants to
     * @param name
     */
    public void addButton(String name){
        JButton button;
        button=new JButton(name);
        this.add(button);
        this.revalidate();
        this.repaint();


        lastButton=button;
    }

    /**
     * the method adds a new JSpinner when the user  wants to
     */
    public void addSpinner(String name){
        JLabel label;
        JSpinner spinner;
        label = new JLabel(name);
        spinner = new JSpinner(new SpinnerNumberModel(10, 10, 100, 10));
        this.add(label);
        this.add(spinner);
        this.revalidate();
        this.repaint();
    }

    /**
     * the method edits the name of the last added button
     * @param name the new name for our button
     */
    public void edit(String name){
        this.remove(lastButton);
        this.revalidate();
        this.repaint();

        JButton button;
        button=new JButton(name);
        lastButton=button;
        this.add(button);
        this.revalidate();
        this.repaint();

    }

}