package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Appointments extends JFrame implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
    private final DetailPanel detailPanel;


    public Appointments(boolean isUpdate)  {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,0,0);



        detailPanel = new DetailPanel( this);
        gbc.insets = new Insets(30,30,30,10);
        gbc.gridwidth = 1;
        gbc.gridy =1;
        gbc.gridx =0;
        panel.add(detailPanel, gbc);


        addMouseListener(this);
        addMouseMotionListener(this);

        add(panel);
        panel.setBackground(Color.BLACK);
        setUndecorated(true);
        pack();
        setLocation(300,75);
        setVisible(true);
    }

    int mouseX;
    int mouseY;
    public DetailPanel getDetailPanel() {

        return detailPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        setLocation(getX()+(e.getX()-mouseX),getY()+(e.getY()-mouseY));
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
