package kabaDev;




import javax.swing.JFrame;



public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Simple Tetris");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        //Add GamePanel to the frame
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        window.setLocationRelativeTo(null); // Center the window on the screen
        window.setVisible(true);

        gp.launchGame();

    }
}