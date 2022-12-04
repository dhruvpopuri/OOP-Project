package flashcard_App;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class LoginThread implements Runnable {

    public Thread theThread;
    private final String username;
    private final String password;
    public boolean stopThread = false;

    LoginThread(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void start() {
        if (theThread == null) {
            theThread = new Thread(this);
            theThread.start();
        }
    }

    public void setStopThread(boolean aValue) {
        stopThread = aValue;
    }

    @Override
    public void run() {
        while (!stopThread) {
            try {
                boolean userExists = doesUserExist(username, password);
                if (!userExists) {
                    // Display Incorrect Credentials
                    theThread.stop();
                } else {
                    new HomeScreen();
                    setStopThread(true);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean doesUserExist(String username, String password) {
        System.out.println(username + " " + password);
        File file = new File("src/flashcard_App/users.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split("\\.");
                if (strings[0].equals(username) && strings[1].equals(password)) {
                    br.close();
                    return true;
                }
            }
            br.close();
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

public class UserLogin {

    private final JFrame userLogin;
    private final JTextField textField;
    private final JPasswordField passwordField;

    public UserLogin() {

        userLogin = new JFrame("User Login");
        userLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userLogin.setSize(400, 500);
        userLogin.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("UserName");
        lblNewLabel.setBounds(44, 99, 79, 25);
        userLogin.getContentPane().add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(44, 225, 79, 25);
        userLogin.getContentPane().add(lblPassword);

        textField = new JTextField();
        textField.setBounds(44, 152, 195, 19);
        userLogin.getContentPane().add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(44, 282, 195, 19);
        userLogin.getContentPane().add(passwordField);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(actionEvent -> {
            String username = textField.getText();
            String password = String.valueOf(passwordField.getPassword());
            LoginThread loginThread = new LoginThread(username, password);
            loginThread.start();
            try {
                loginThread.theThread.join();
                if(loginThread.stopThread == false) {
                    JOptionPane.showMessageDialog(userLogin, "Invalid Username or Password");
                    new UserLogin();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        btnNewButton.setBounds(154, 355, 85, 21);
        userLogin.getContentPane().add(btnNewButton);
        userLogin.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserLogin::new);
    }
}
