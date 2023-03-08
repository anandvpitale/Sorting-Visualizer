package EntryPoint;

import Visualizer.SortingVisualizer;
import Sortings.Sortings;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Font;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class MainFrame {

    private JFrame frame;
    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JLabel success;
    private static JButton button, signUpButton;
    private String userID, password;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame window = new MainFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private boolean login(String id, String pwd) {
        Connection connection = Database.getDbConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID, PWD FROM USERS where ID ='"+id+"' and PWD='"+pwd+"'");
//				resultSet.next();
            if (resultSet.next()) {
                Database.closeConnection();
                return true;
            }
            Database.closeConnection();
            return false;
        } catch (SQLException e) {
            System.out.println(e);
            Database.closeConnection();
            return false;
        }
    };

    private boolean signup(String id, String pwd) {
        Connection connection = Database.getDbConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Users (id, pwd) VALUES (?, ?)");
            ps.setString(1, id);
            ps.setString(2, pwd);

            int ff = ps.executeUpdate();
            System.out.println(ff);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("insert into users values("+id+","+pwd+")");
            if (ff == 1) {
                Database.closeConnection();
                return true;
            }
            Database.closeConnection();
            return false;
        } catch (SQLException e) {
            System.out.println(e);
            Database.closeConnection();
            return false;
        }
    };

    /**
     * Create the application.
     */
    public MainFrame() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("User: ");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(50, 90, 80, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean auth = login(userText.getText(), passwordText.getText());
                if (userText.getText().isEmpty() || passwordText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID and Password cannot be empty");
                }
                if (auth) {
                    initialize();
                    frame.setVisible(false);
                    frame.dispose();
                } else if (!auth){
                    JOptionPane.showMessageDialog(frame, "Incorrect User ID or Password");
                }

            }
        });
        panel.add(button);

        signUpButton = new JButton("Sign up");
        signUpButton.setBounds(150, 90, 80, 25);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean auth = signup(userText.getText(), passwordText.getText());
                if (auth)
                    JOptionPane.showMessageDialog(frame, "Success");
                else{
                    JOptionPane.showMessageDialog(frame, "User already exist!");
                }
            }
        });
        panel.add(signUpButton);

//		success = new JButton();
//		success.setBounds(10, 110, 300, 25);
//		panel.add(success);

        frame.setVisible(true);

        //initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        Sortings obj = new Sortings();
        frame = new JFrame();
        frame.setBounds(0, 0, 1500, 1500);
        frame.getContentPane().setBackground(Color.BLACK);
        //frame.pack();
        frame.setVisible(true);
        //frame.setBounds(1000, 1000, 1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        ;


        JLabel title = new JLabel("OpenTutor : Study portal for sorting algorithms!\r\n");

        title.setFont(new Font("Arial Black", Font.BOLD, 42));
        title.setForeground(Color.ORANGE);
        //	title.setBounds(8,10, 208, 41 );

        //title.setBounds(20,20, 200, 20 );
        //title.setBounds(800,90, 500, 50 );
        title.setBounds(120, 90, 1500, 50);
        frame.getContentPane().add(title);


        JButton btnNewButton = new JButton("BUBBLE SORT");
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 24));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obj.vis(1, "BUBBLE SORT");
                frame.setVisible(false);
            }
        });
        //btnNewButton.setBounds(43, 48, 128, 25);
        //btnNewButton.setBounds(86, 96, 256, 50);
        btnNewButton.setBounds(100, 192, 450, 80);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("INSERTION SORT");
        btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 24));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obj.vis(4, "INSERTION SORT");
                frame.setVisible(false);
            }
        });
        //btnNewButton_1.setBounds(253, 48, 128, 25);
        //btnNewButton_1.setBounds(506, 96, 256, 50);
        btnNewButton_1.setBounds(900, 192, 450, 80);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("SELECTION SORT");
        btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 24));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obj.vis(2, "SELECTION SORT");
                frame.setVisible(false);
            }
        });
        //btnNewButton_2.setBounds(43, 116, 128, 25);
        btnNewButton_2.setBounds(100, 340, 450, 80);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("MERGE SORT");
        btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 24));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obj.vis(5, "MERGE SORT");
                frame.setVisible(false);
            }
        });
        //btnNewButton_3.setBounds(253, 116, 128, 25);
        btnNewButton_3.setBounds(900, 340, 450, 80);
        frame.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("QUICK SORT");
        btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 24));
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obj.vis(3, "QUICK SORT");
                frame.setVisible(false);
            }
        });
        //btnNewButton_4.setBounds(43, 178, 128, 25);
        btnNewButton_4.setBounds(100, 500, 450, 80);
        frame.getContentPane().add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("MAX HEAP SORT");
        btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 24));
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obj.vis(6, "HEAP SORT");
                frame.setVisible(false);
            }
        });
        //btnNewButton_5.setBounds(253, 178, 128, 25);
        btnNewButton_5.setBounds(900, 500, 450, 80);

        frame.getContentPane().add(btnNewButton_5);

        JButton visualizations = new JButton("VISUALIZATIONS!");
        visualizations.setFont(new Font("Arial", Font.BOLD, 24));
        visualizations.setBackground(Color.cyan);
        visualizations.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


//					frame1.setVisible(true);
                SortingVisualizer frame1 = new SortingVisualizer();
                frame1.idk();


            }
        });
        visualizations.setBounds(570, 650, 312, 100);
        frame.getContentPane().add(visualizations);


    }


}
