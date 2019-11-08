import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.JOptionPane;
import static java.lang.Math.sqrt;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main extends JFrame {
    private JTextField TFieldHeight,TFieldMass;
    private Graphs graphs;
    JLabel coasterchoice;
    boolean choiceanalysis;
    public static boolean ViewGraphs;
    double vA, vB, vC, vD, h1, h2, h3, h4, g, m;

    public Main (Graphs graphs){
        super("Conservation of Energy Calculator");
        setLayout(new GridLayout(5,1));

        this.graphs = graphs;

        //Creating Panels add everything at the end
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        add(panel1);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1,2));
        add(panel4);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1,3));
        add(panel3);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        add(panel2);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayout(1,2));
        add(panel5);

        //panel 1
        JLabel Hlabel = new JLabel("Enter the initial height (m)");
        panel1.add(Hlabel);

        Hlabel.setFont(new Font("Century Gothic", Font.BOLD,30));
        Hlabel.setHorizontalAlignment(JTextField.CENTER);

        TFieldHeight = new JTextField("", 30);
        panel1.add(TFieldHeight);

        TFieldHeight.setFont(new Font("Century Gothic", Font.BOLD,30));
        TFieldHeight.setHorizontalAlignment(JTextField.CENTER);

        //panel 4
        JLabel mlabel = new JLabel("Enter the initial mass (kg)");
        panel4.add(mlabel);

        mlabel.setFont(new Font("Century Gothic", Font.BOLD,30));
        mlabel.setHorizontalAlignment(JTextField.CENTER);

        TFieldMass = new JTextField("", 30);
        panel4.add(TFieldMass);

        TFieldMass.setFont(new Font("Century Gothic", Font.BOLD,30));
        TFieldMass.setHorizontalAlignment(JTextField.CENTER);

        //panel2
        coasterchoice = new JLabel("");
        panel2.add(coasterchoice);

        //panel 3
        JLabel Customize = new JLabel("Select your roller coaster:",10);
        panel3.add(Customize);

        Customize.setFont(new Font("Century Gothic", Font.BOLD,20));
        Customize.setHorizontalAlignment(JTextField.CENTER);

        JButton coaster1 = new JButton("Roller Coaster 1");
        JButton coaster2 = new JButton("Roller Coaster 2");

        coaster1.setFont(new Font("Century Gothic", Font.BOLD,20));
        coaster1.setHorizontalAlignment(JTextField.CENTER);

        coaster2.setFont(new Font("Century Gothic", Font.BOLD,20));
        coaster2.setHorizontalAlignment(JTextField.CENTER);

        panel3.add(coaster1);
        panel3.add(coaster2);

        //panel 5
        JButton txt = new JButton("Save Values");
        panel5.add(txt);

        txt.setFont(new Font("Century Gothic", Font.BOLD,30));
        txt.setHorizontalAlignment(JTextField.CENTER);

        JButton Analyze = new JButton("View Coaster Analysis");
        panel5.add(Analyze);

        Analyze.setFont(new Font("Century Gothic", Font.BOLD,30));
        Analyze.setHorizontalAlignment(JTextField.CENTER);

        //Action Listeners
        ActionListener acts1 = new action1();
        coaster1.addActionListener(acts1);

        ActionListener acts2 = new action2();
        coaster2.addActionListener(acts2);

        ActionListener acts3 = new action3();
        Analyze.addActionListener(acts3);

        ActionListener acts4 =new action4();
        txt.addActionListener(acts4);

    }

    public class action1 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JFrame coasters1 = new JFrame();
            coasters1.setVisible(true);
            coasters1.setResizable(false);
            coasters1.setSize(907,590);

            ImageIcon coaster1 = new ImageIcon("Roller Coaster 1.png");
            JLabel pics1 = new JLabel(coaster1);
            coasters1.add(pics1);

            JOptionPane.showMessageDialog(null, "Roller coasters are not drawn to scale");

            coasterchoice.setFont(new Font("Century Gothic", Font.BOLD,30));
            coasterchoice.setHorizontalAlignment(JTextField.CENTER);

            coasterchoice.setText("You have selected roller coaster 1");
            choiceanalysis = true;

        }
    }

    public class action2 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JFrame coasters1 = new JFrame();
            coasters1.setVisible(true);
            coasters1.setResizable(false);
            coasters1.setSize(907,590);

            ImageIcon coaster1 = new ImageIcon("Roller Coaster 2.png");
            JLabel pics1 = new JLabel(coaster1);
            coasters1.add(pics1);

            JOptionPane.showMessageDialog(null, "Roller coasters are not drawn to scale");

            coasterchoice.setFont(new Font("Century Gothic", Font.BOLD,30));
            coasterchoice.setHorizontalAlignment(JTextField.CENTER);

            coasterchoice.setText("You have selected roller coaster 2");
            choiceanalysis = false;

        }
    }

    public class action3 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(TFieldHeight.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "ERROR MISSING VALUES");
            }

            else if(choiceanalysis==true){

                String sHeight = TFieldHeight.getText();
                h1 = Double.parseDouble(sHeight);

                g = 9.81;

                vA = sqrt(2*g*h1);

                h2 = 0.4*h1;
                vB = sqrt((.5*(vA*vA)-(g*h2))/.5);

                h3 = 1.3*h1;
                vC = sqrt((.5*(vB*vB)+(g*h3))/.5);

                h4 = 0.2*h1;
                vD =sqrt((.5*(vC*vC)-(g*h4))/.5);

                vA = Math.floor(vA*100)/100;
                vB = Math.floor(vB*100)/100;
                vC = Math.floor(vC*100)/100;
                vD = Math.floor(vD*100)/100;

                JFrame analysis1 = new JFrame("Coaster Analysis");
                analysis1.setLayout(new GridLayout(6,1));

                analysis1.setLocation(50,400);

                JPanel A1panel1 = new JPanel();
                A1panel1.setLayout(new GridLayout(1,1));

                JPanel A1panel2 = new JPanel();
                A1panel2.setLayout(new GridLayout(1,1));

                JPanel A1panel3 = new JPanel();
                A1panel3.setLayout(new GridLayout(1,1));

                JPanel A1panel4 = new JPanel();
                A1panel4.setLayout(new GridLayout(1,1));

                JPanel A1panel5 = new JPanel();
                A1panel5.setLayout(new GridLayout(1,1));

                JLabel title = new JLabel("Velocity of the cart at Different Points");
                JLabel velocityA1 = new JLabel("The Velocity at point A is " + vA + " m/s");
                JLabel velocityB1 = new JLabel("The Velocity at point B is " + vB + " m/s");
                JLabel velocityC1 = new JLabel("The Velocity at point C is " + vC + " m/s");
                JLabel velocityD1 = new JLabel("The Velocity at point D is " + vD + " m/s");

                title.setFont(new Font("Century Gothic", Font.BOLD,20));
                title.setHorizontalAlignment(JTextField.CENTER);
                velocityA1.setFont(new Font("Century Gothic", Font.BOLD,20));
                velocityA1.setHorizontalAlignment(JTextField.CENTER);
                velocityB1.setFont(new Font("Century Gothic", Font.BOLD,20));
                velocityB1.setHorizontalAlignment(JTextField.CENTER);
                velocityC1.setFont(new Font("Century Gothic", Font.BOLD,20));
                velocityC1.setHorizontalAlignment(JTextField.CENTER);
                velocityD1.setFont(new Font("Century Gothic", Font.BOLD,20));
                velocityD1.setHorizontalAlignment(JTextField.CENTER);

                A1panel1.add(title);
                A1panel2.add(velocityA1);
                A1panel3.add(velocityB1);
                A1panel4.add(velocityC1);
                A1panel5.add(velocityD1);

                analysis1.add(A1panel1);
                analysis1.add(A1panel2);
                analysis1.add(A1panel3);
                analysis1.add(A1panel4);
                analysis1.add(A1panel5);

                analysis1.setSize(850,550);
                analysis1.setVisible(true);
                analysis1.setResizable(false);

                ViewGraphs = true;    
                graphs.showFrame();

            }
            else{
                String sHeight = TFieldHeight.getText();
                h1 = Double.parseDouble(sHeight);

                g = 9.81;

                vA = sqrt(2*g*h1);

                h2 = 0.7*h1;
                vB = sqrt((.5*(vA*vA)-(g*h2))/.5);

                h3 = 0.35*h1;
                vC = sqrt((.5*(vB*vB)+(g*h3))/.5);

                h4 = 0.3*h1;
                vD = sqrt((.5*(vC*vC)+(g*h4))/.5);

                vA = Math.floor(vA*100)/100;
                vB = Math.floor(vB*100)/100;
                vC = Math.floor(vC*100)/100;
                vD = Math.floor(vD*100)/100;

                JFrame analysis2 = new JFrame("Coaster Analysis");
                analysis2.setLayout(new GridLayout(6,1));

                analysis2.setLocation(50,400);

                JPanel A2panel1 = new JPanel();
                A2panel1.setLayout(new GridLayout(1,1));

                JPanel A2panel2 = new JPanel();
                A2panel2.setLayout(new GridLayout(1,1));

                JPanel A2panel3 = new JPanel();
                A2panel3.setLayout(new GridLayout(1,1));

                JPanel A2panel4 = new JPanel();
                A2panel4.setLayout(new GridLayout(1,1));

                JPanel A2panel5 = new JPanel();
                A2panel5.setLayout(new GridLayout(1,1));

                JLabel title = new JLabel("Velocity of the Cart at Different Points");
                JLabel velocityA2 = new JLabel("The Velocity at point A is " + vA + " m/s");
                JLabel velocityB2 = new JLabel("The Velocity at point B is " + vB + " m/s");
                JLabel velocityC2 = new JLabel("The Velocity at point C is " + vC+ " m/s");
                JLabel velocityD2 = new JLabel("The Velocity at point D is " + vD + " m/s");

                title.setFont(new Font("Century Gothic", Font.BOLD,20));
                title.setHorizontalAlignment(JTextField.CENTER);
                velocityA2.setFont(new Font("Century Gothic", Font.BOLD,20));
                velocityA2.setHorizontalAlignment(JTextField.CENTER);
                velocityB2.setFont(new Font("Century Gothic", Font.BOLD,20));
                velocityB2.setHorizontalAlignment(JTextField.CENTER);
                velocityC2.setFont(new Font("Century Gothic", Font.BOLD,20));
                velocityC2.setHorizontalAlignment(JTextField.CENTER);
                velocityD2.setFont(new Font("Century Gothic", Font.BOLD,20));
                velocityD2.setHorizontalAlignment(JTextField.CENTER);

                A2panel1.add(title);
                A2panel2.add(velocityA2);
                A2panel3.add(velocityB2);
                A2panel4.add(velocityC2);
                A2panel5.add(velocityD2);

                analysis2.add(A2panel1);
                analysis2.add(A2panel2);
                analysis2.add(A2panel3);
                analysis2.add(A2panel4);
                analysis2.add(A2panel5);

                analysis2.setSize(850,550);
                analysis2.setVisible(true);
                analysis2.setResizable(false);

                ViewGraphs = true;    
                graphs.showFrame();

            }

        }
    }

    public class action4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ConservationOfEnergy.txt"), "utf-8"));

                String sHeight = TFieldHeight.getText();
                h1 = Double.parseDouble(sHeight);

                String sMass = TFieldMass.getText();
                m = Double.parseDouble(sMass);

                writer.write("The initial height is " + h1 + " m");
                writer.newLine();
                writer.write("The mass of the cart is " + m + " kg");
                writer.write("The velocity at point A is " + vA + " m/s");
                writer.newLine();
                writer.write("The velocity at point B is " + vB + " m/s");
                writer.newLine();
                writer.write("The velocity at point C is " + vC + " m/s");
                writer.newLine();
                writer.write("The velocity at point D is " + vD + " m/s");
                writer.newLine();
            }
            catch(IOException f){
            }

            JOptionPane.showMessageDialog(null, "Your input values, and velocities have been saved");
        }
    }
}
