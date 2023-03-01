package GUI;

import javax.swing.*;
import java.io.IOException;

public class Login {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        LoginFrame loginFrame = new LoginFrame(frame);
        frame.add(loginFrame);
        frame.setTitle("Doc119 | Channeling Made Easy");
        frame.setVisible(true);
        frame.setBounds(100, 150, 400, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}
