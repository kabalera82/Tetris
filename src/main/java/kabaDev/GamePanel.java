package kabaDev;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics; // Importación necesaria
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    // Created FPS for the game
    final int FPS = 60;
    Thread gameThread;
    PlayManager pm;

    public GamePanel() {
        // Panel Settings
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(null);

        pm = new PlayManager();
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // Game Loop
        double drawInterval = 1000000000 / FPS; // 1 segundo = 1000000000 nanosegundos
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    private void update() {
       pm.update();
    }

    @Override
    public void paintComponent(Graphics g) { // Anotación @Override agregada
        super.paintComponent(g);
        // Lógica de renderizado del juego
        Graphics2D g2 = (Graphics2D) g; // Cast a Graphics2D
        pm.draw(g2); // Llamada al método draw de PlayManager
    }
}