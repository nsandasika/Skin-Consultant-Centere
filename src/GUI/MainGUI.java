package GUI;

import com.company.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class MainGUI extends JFrame implements MouseListener, MouseMotionListener, ActionListener {
    //declares a class called MainGUI, which extends the JFrame class and implements the MouseListener,
    // MouseMotionListener, and ActionListener interfaces

    //declare private instance variables of the MainGUI class.
    // The button variable is of type JButton, the label variable is of type JLabel, and the tableModel variable is of type DocTable

    private JButton button;
    private JLabel label;
    private DocTable tableModel;



    public MainGUI() throws IOException{
        //throws an IOException,can throw an exception if an I/O error occurs

        // public constructor for the MainGUI class
        JPanel panel = new JPanel();
        // create a new JPanel called panel, set its layout to a GridBagLayout, and create a new GridBagConstraints object.
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(30,30,30,30);


        //doctorTablePanel is created by calling the doctorDetailsTable method
        JPanel doctorTablePanel = doctorDetailsTable(); //left
        //mainButtonPanel is created by calling the MainPanel constructor
        JPanel mainButtonPanel = new MainPanel(this); //right

        gbc.gridy =0;
        gbc.gridx =0;
        panel.add(mainButtonPanel, gbc);

        gbc.insets = new Insets(10,10,10,10);
        gbc.gridy =0;
        gbc.gridx =1;
        panel.add(doctorTablePanel,gbc);

        button.addActionListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        add(panel);
        panel.setBackground(Color.BLACK);
        setUndecorated(true);
        pack();
        setLocation(350,75);
        setVisible(true);
    }


    private JPanel doctorDetailsTable() {
        label = new JLabel("Order Doctor names Alphabetically ", SwingConstants.CENTER);
        button = new JButton("Enter");
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Serif", Font.BOLD | Font.BOLD, 20));

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(30,30,30,10);

        gbc.gridy =0;
        gbc.gridx =0;
        mainPanel.add(label, gbc);

        gbc.gridx =1;

        mainPanel.add(button, gbc);

        tableModel = new DocTable();
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        table.setRowHeight(30);
        table.setBackground(Color.blue);
        table.setForeground(Color.white);

        table.setFillsViewportHeight(true);
        scrollPane.setBackground(Color.WHITE);
        mainPanel.setBackground(Color.DARK_GRAY);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);

        columnModel.getColumn(1).setMinWidth(60);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.LEFT );
        columnModel.getColumn(0).setMinWidth(60);

        columnModel.getColumn(2).setCellRenderer( centerRenderer );
        table.setGridColor(Color.red);

        scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width,scrollPane.getPreferredSize().height+45));
        table.setRowHeight((scrollPane.getPreferredSize().height)/10);

        gbc.gridwidth = 2;
        gbc.gridy =1;
        gbc.gridx =0;
        mainPanel.add(scrollPane, gbc);
        return mainPanel;
    }

    @Override
    // defines a method that will be called when the mouse is clicked within the GUI
    public void mouseClicked(MouseEvent e) {
        // MouseEvent object, e, contains information about the event,
        // such as the location of the mouse cursor.

    }

    //  declares two variables, mouseX and mouseY,
    //  which will be used to store the x and y coordinates of the mouse cursor
    int mouseX, mouseY;

    @Override
    // defines a method that will be called when a mouse button is pressed within the GUI
    public void mousePressed(MouseEvent e) {
        // MouseEvent object, e, contains information about the event, such as the location of the mouse cursor.
        // method stores the current x and y coordinates of the mouse cursor in the mouseX and mouseY variables
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    // defines a method that will be called when a mouse button is released within the GUI
    public void mouseReleased(MouseEvent e) {

        // MouseEvent object, e, contains information about the event, such as the location of the mouse cursor
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        // defines a method that will be called when the mouse cursor enters the GUI.
        // The MouseEvent object, e, contains information about the event, such as the location of the mouse cursor
    }

    @Override
    // defines a method that will be called when the mouse cursor exits the GUI
    public void mouseExited(MouseEvent e) {
        // MouseEvent object, e, contains information about the event, such as the location of the mouse cursor

    }

    @Override
    // defines a method that will be called when the mouse is dragged within the GUI
    public void mouseDragged(MouseEvent e) {
        setLocation(getX()+(e.getX()-mouseX),getY()+(e.getY()-mouseY));
    }
    // method updates the position of the GUI by calculating the difference between the current and previous mouse positions and adding it to the current position of the GUI

    @Override
    // defines a method that will be called when the mouse is moved within the GUI
    public void mouseMoved(MouseEvent e) {
        // MouseEvent object, e, contains information about the event, such as the location of the mouse cursor

    }
    class sortByname implements Comparator<Doctor> {

        @Override
        // defines a class, sortByname, that implements the Comparator interface for the Doctor class
        public int compare(Doctor doc1, Doctor doc2) {
            // Comparator interface allows objects to be sorted by implementing the compare method
            return doc1.getName().compareTo(doc2.getName());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== button) {

            ArrayList<Doctor> d = tableModel.getMyList();
            d.sort(new sortByname());
            tableModel.fireTableDataChanged();
            button.setBackground(Color.orange);



        }
    }
}


