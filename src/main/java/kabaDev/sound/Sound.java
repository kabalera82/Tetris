package kabaDev.sound;

import java.net.URL;

import javax.sound.sampled.*;


public class Sound {
    Clip musicClip;
    URL url[] = new URL[10];

    //Constructor, un array con 5 objetos
    public Sound() {
        url[0] = getClass().getResource("/Tetris_converted.wav");
        url[1] = getClass().getResource("/gameover.wav");
        url[2] = getClass().getResource("/rotation.wav");
        url[3] = getClass().getResource("/touch floor.wav");
        url[4] = getClass().getResource("/delete line.wav");
    }

    public void play(int i, boolean music) {
        try {
            if (url[i] == null) {
                throw new RuntimeException("Archivo de sonido no encontrado para índice " + i);
            }
            AudioInputStream ais = AudioSystem.getAudioInputStream(url[i]);
            Clip clip = AudioSystem.getClip();

            if (music) {
                musicClip = clip;
            }
            clip.open(ais);
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        //Cerramos el clip para no utilizar excesivos recursos de memoria
                        clip.close();
                    }
                }
            });

            clip.start();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loop() {
        musicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        musicClip.stop();
        musicClip.close();
    }

}
