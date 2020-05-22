package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The ControlPanel will allow the user to specify any class name of a Swing component (such as JButton, JLabel, JSpinner, JComboBox ), a name for that component  and a button for creating and adding an instance of the specified component to the DesignPanel.
 * It gives us the possibility to change te name of a button
 * It has a load and a save button, and the created design panel can be saved in xml format
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JLabel componentLabel;
    JTextField componentField;
    JLabel nameLabel;
    JTextField nameField;
    JButton button;
    JButton saveButton;
    JButton loadButton;
    JLabel editLabel;
    JTextField editField;
    JButton editButton;
    ArrayList<String> elements= new ArrayList<>();
    ArrayList<String> names= new ArrayList<>();

    /**
     * Creating the panels and the button and adding them to the panel
     */
    public ControlPanel(MainFrame frame)
    {
        this.frame=frame;

        componentLabel=new JLabel("The Class name of the Swing component: ");
        componentField=new JTextField(10);

        nameLabel=new JLabel("The default text for the component: ");
        nameField=new JTextField(10);

        button=new JButton("Create & add");
        saveButton=new JButton("SAVE");
        loadButton= new JButton("LOAD");

        editLabel=new JLabel("Edit name: ");
        editField=new JTextField(10);
        editButton= new JButton("EDIT");

        add(componentLabel);
        add(componentField);
        add(nameLabel);
        add(nameField);
        add(button);
        add(saveButton);
        add(loadButton);
        add(editLabel);
        add(editField);
        add(editButton);

        button.addActionListener(this::add);
        saveButton.addActionListener(this::save);
        editButton.addActionListener(this::edit);
    }

    /**
     * The method calls a specific method of the design panel, considering what the user wrote in the fields
     */
    private void add(ActionEvent e) {

        String component = componentField.getText();
        String name=nameField.getText();
        elements.add(component);
        names.add(name);
        if(component.equals("JComboBox"))
            frame.designPanel.addCombo(name);
        if(component.equals("JTextField"))
            frame.designPanel.addField(name);
        if(component.equals("JButton"))
            frame.designPanel.addButton(name);
        if(component.equals("JSpinner"))
            frame.designPanel.addSpinner(name);

    }

    /**
     * the method saves the created design panel in an xml format
     */
    private void save(ActionEvent e) {

        File myObj = new File("myDesignPanel.xml");
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter("myDesignPanel.xml");
            myWriter.write("<DesignPanel>\n");
            for( int i=0;i< elements.size(); i++) {
                System.out.println(elements.get(i));
                System.out.println(names.get(i));
                myWriter.write("\t<"+  elements.get(i)  +"> "+ names.get(i)+" </"+ elements.get(i) +">\n");
            }
            myWriter.write("</DesignPanel>\n");
            myWriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * the method edits the name for the last added button
     */
    private void edit(ActionEvent e) {

        String name=editField.getText();
        frame.designPanel.edit(name);


    }
}