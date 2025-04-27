package kabaDev;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1280; // Width de la ventana del juego
    public static final int HEIGHT = 780; // Height de la ventana del juego
    // Frames por segundo (FPS)
    final int FPS = 60; // Velocidad de actualización del juego (frames por segundo)
    Thread gameThread; // Hilo del juego
    PlayManager pm; // Instancia de la clase PlayManager

    // Constructor de la clase GamePanel
    public GamePanel() {
        // Panel Settings
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.gray);
        this.setLayout(null);
        // Implement KeyListener
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true); // Habilitar el foco para recibir eventos de teclado

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
        if (!KeyHandler.pausePressed) {
            pm.update();
        }
    }

    @Override
    public void paintComponent(Graphics g) { // Anotación @Override agregada
        super.paintComponent(g);
        // Lógica de renderizado del juego
        Graphics2D g2 = (Graphics2D) g; // Casteo a Graphics2D
        pm.draw(g2); // Llamada al método draw de PlayManager
    }
}