package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class LoginFrame extends JPanel implements ActionListener{
    private JButton viewDetail, addConsultation, close;
    private JLabel viewDetailL, addConsultationL;
    private final JFrame container;

    public LoginFrame(JFrame container) throws IOException {
        this.container = container;
        componentInitialize();
        addDetailsForm();

        viewDetail.addActionListener(this);

        addConsultation.addActionListener(this);

        close.addActionListener(this);

    }



    private void addDetailsForm(){
        JLabel title = new JLabel("Select An Option", SwingConstants.CENTER);
        title.setForeground(Color.yellow);
        title.setFont(new Font("Serif", Font.BOLD, 20));

        // setBorder(new TitledBorder("Make an appointment."));
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(title, BorderLayout.NORTH);

        // panel.add(required, BorderLayout.CENTER);
        panel.setBackground(Color.BLACK.darker());
        setBackground(Color.YELLOW);
        gridBagConstraints.insets = new Insets(10,0,20,0);
        setPreferredSize(new Dimension(450,630));

        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight =1;

        gridBagConstraints.gridy =0;
        add(panel, gridBagConstraints);

        gridBagConstraints.insets = new Insets(10,30,0,0);
        gridBagConstraints.gridwidth =1;
        gridBagConstraints.gridy =1;
        gridBagConstraints.gridx =0;
        add(addConsultationL, gridBagConstraints);

        gridBagConstraints.insets = new Insets(5,0,30,30);
        gridBagConstraints.gridy =2;
        gridBagConstraints.gridx =1;
        add(addConsultation, gridBagConstraints);


        gridBagConstraints.insets = new Insets(10,30,0,0);
        gridBagConstraints.gridy =8;
        gridBagConstraints.gridx =0;
        add(viewDetailL, gridBagConstraints);

        gridBagConstraints.insets = new Insets(5,0,30,30);
        gridBagConstraints.gridy =9;
        gridBagConstraints.gridx =1;
        add(viewDetail, gridBagConstraints);




        gridBagConstraints.insets = new Insets(10,30,30,30);

        gridBagConstraints.gridy = 11;
        add(close, gridBagConstraints);
        close.setPreferredSize(new Dimension(407/2,630/2));

    }

    private void componentInitialize() throws IOException {

        addConsultationL = new JLabel("Find a doctor :", SwingConstants.LEFT);
        viewDetailL = new JLabel("View your \nappointment :", SwingConstants.LEFT);
        viewDetail = new JButton("View");
        addConsultation = new JButton("Book Now");

        close = new JButton("Close");


        close.setBackground(Color.BLACK);

        viewDetail.setBackground(Color.lightGray);
        viewDetail.setForeground(Color.BLACK);

        addConsultation.setBackground(Color.lightGray);
        addConsultation.setForeground(Color.BLACK);

        close.setForeground(Color.WHITE);


        addConsultationL.setForeground(Color.BLACK);

        viewDetailL.setForeground(Color.BLACK);

        addConsultationL.setFont(new Font("Serif", Font.BOLD , 18));
        viewDetail.setFont(new Font("Serif", Font.BOLD , 16));




        viewDetailL.setFont(new Font("Serif", Font.BOLD , 18));
        addConsultation.setFont(new Font("Serif", Font.BOLD , 16));



    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==viewDetail){
            container.dispose();
            new CheckIDandName();
            //  MobileNumberEnter mobileNumberEnter = new MobileNumberEnter(false, true);
        }

        else if (e.getSource()==addConsultation) {
            container.dispose();
            new Appointments(false);
        }

        else if (e.getSource() == close) {

            System.exit(0);
        }
    }


}