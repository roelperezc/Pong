/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import com.sun.javafx.application.PlatformImpl;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import MenuVentanas.Revancha;

/**
 * La clase <i>Ejecucion</i> es un hilo que se encarga de correr el juego de Pong.
 * Tiene una <i>VentanaPong</i> que refresca aproximadamente 30 veces por segundo. 
 */
public class Ejecucion extends Thread {
    
    private VentanaPong ventana;
    int contador;
    
    /**
     * Constructor del hilo <i>Ejecucion</i>. 
     * @param ventana La ventana que debe correr el hilo.
     */
    public Ejecucion(VentanaPong ventana){
        this.ventana = ventana;
        this.contador = 0;
    }
    
    /**
     * {@inheritDoc}
     * Corre la partida de Pong hasta que un jugador gane.
     */
    @Override
    public void run(){
        ventana.add( ventana.pong );
        ventana.setVisible(true);
        //Se implementa el sonido de fondo
        //Platform crea el espacio donde se puede reproducir el sonido
        PlatformImpl.startup(() -> {});
        javafx.scene.media.Media ambiente = new javafx.scene.media.Media(this.getClass().getResource("/pong/media/Ambiente.wav").toString());
        MediaPlayer reproducirAmbiente = new MediaPlayer(ambiente);
        reproducirAmbiente.setOnEndOfMedia(new Runnable(){
            @Override
            public void run(){
                reproducirAmbiente.seek(Duration.ZERO);
            }
        });
        reproducirAmbiente.play();

        while( !ventana.getPong().getFinDePartida() ){
            ventana.repaint();
            ventana.getPong().siguienteFrame();
            try{
                Thread.sleep(35);
            }
            catch( InterruptedException e ){
                
            }
            if( contador == 840 ){
                ventana.getPong().crearPelotasFalsas();
                ventana.getPong().getB().cambiarRapidez(1);
                contador = 0;
            }   
            contador++;
        }
        //Aquí se pausará y terminará la canción
        reproducirAmbiente.stop();
        reproducirAmbiente.dispose();

        JOptionPane.showMessageDialog(ventana, "Ha ganado el Jugador " + ventana.getPong().obtenerGanador());
        System.out.println(ventana.getPong().puntuacionGanadora());
        ventana.dispose();
        Revancha revancha = new Revancha();
        revancha.setVisible(true);

    }
    
    
}
