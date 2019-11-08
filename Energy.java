import javax.swing.*;
import java.awt.*;

public class Energy extends JFrame {
    public static void main(String[] args) {
        Graphs grf = new Graphs();
        Main execute = new Main(grf);
        
        execute.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        execute.setSize(850,550);
        execute.setVisible(true);
        execute.setResizable(false);

    }
}