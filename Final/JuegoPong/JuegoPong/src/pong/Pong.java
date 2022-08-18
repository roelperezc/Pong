/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.MediaPlayer;
import javax.imageio.ImageIO;

/**
 * La clase <i>Pong</i> contiene todos los elementos del Pong (fondo, jugadores,
 * pelota) y se encarga de actualizar sus elementos conforme transcurre el tiempo.
 */
public class Pong extends JPanel {
	
    private Jugador p1;
    private Jugador p2;
    private Pelota b;
    private Pelota bFalse1;
    private Pelota bFalse2;
    private boolean anotacion;
    private boolean turno;
    private boolean finDePartida;
    private int contadorFrame;
    private int frame;
    private int indexFondo;
    //Se declaran estaticas para que no se corte el sonido
    private static javafx.scene.media.Media boing; 
    private static MediaPlayer reproducirRebote;
    static int puntuacion1,puntuacion2,anotacion1,anotacion2;
        
    /**
     * Devuelve al jugador uno.
     * @return Jugador uno.
     */   
    public Jugador getP1(){
        return this.p1;
    }
    
    /**
     * Devuelve al jugador dos.
     * @return Jugador dos.
     */
    public Jugador getP2(){
        return this.p2;
    }

    /**
     * Devuelve a la pelota.
     * @return La pelota.
     */
    public Pelota getB(){
        return this.b;
    }
        
    /**
     * Devuelve verdadero si la partida ha terminado y falso en caso contrario.
     * @return Si la partida ha terminado.
     */
    public boolean getFinDePartida(){
        return this.finDePartida;
    }

    /**
     * Inicializa todos los elementos del Pong en el primer turno de la partida.
     */
    public Pong(){
        this.p1 = new JugadorUno();
        this.p2 = new JugadorDos();
        turno = false;
        this.b = new Pelota();
        this.bFalse1 = new Pelota();
        this.bFalse2 = new Pelota();
        this.bFalse1.setVisible(false);
        this.bFalse2.setVisible(false);
        this.b.saque(turno);
        this.anotacion = false;
        contadorFrame = 0;
        frame = 0;
    }
    
    /**
     * Inicializa todos los elementos de Pong despu&eacute;s del primer turno,
     * seguido de una anotaci&oacute;n.
     */
    private void reiniciarPong(){
            
        this.p1 = new JugadorUno( this.p1.getPuntuacion(), this.p1.getAnotaciones() );
        this.p2 = new JugadorDos( this.p2.getPuntuacion(), this.p2.getAnotaciones() );
        this.b = new Pelota();
        this.bFalse1 = new Pelota();
        this.bFalse2 = new Pelota();
        this.bFalse1.setVisible(false);
        this.bFalse2.setVisible(false);
        this.anotacion = false;
            
        if( p2.getAnotaciones() == 3 || p1.getAnotaciones() == 3 ){
            puntuacion1 = this.p1.getPuntuacion();
            puntuacion2 = this.p2.getPuntuacion();
            anotacion1 = this.p1.getAnotaciones();
            anotacion2=this.p2.getAnotaciones();
            finDePartida = true;
        }
        else{
            this.b.saque(turno); 
        }
            
        indexFondo = (int)(Math.random()*5);
            
    }

    /**
     * Calcula la siguiente posici&oacute;n de los elementos del Pong por cuadro.
     * Modifica la velocidad de los jugadores, la posici&oacute;n de la pelota,
     * y cuenta los cuadros que han pasado para cambiar los sprites. 
     */
    void siguienteFrame(){
		
        verificarTrayectoria();
        try{
            b.movimiento();
            bFalse1.movimiento();
            bFalse2.movimiento();
        }
        catch( ExcepcionPelotaNoExistente e ){
            
        }
        p1.mover();
        p2.mover();
                
        if( p1.getDY() > 0 )
            p1.setDY( p1.getDY() - 1 );
        else if( p1.getDY() < 0 )
            p1.setDY( p1.getDY() + 1 );
                
        if( p2.getDY() > 0 )
            p2.setDY( p2.getDY() - 1 );
        else if( p2.getDY() < 0 )
            p2.setDY( p2.getDY() + 1 );
                
            
        if( contadorFrame == 5 ){
            if( frame == 2 ){
                frame = 0;
            }
            else{
                frame++;
            }
            contadorFrame = 0;
        }
        contadorFrame++;
    }
    
    /**
     * Verifica la posici&oacute;n de la pelota para saber si es necesario
     * cambiar su trayectoria por una colisi&oacute;n, contar una anotaci&oacute;n
     * o reiniciar el turno. 
     */
    public void verificarTrayectoria(){
            
        if( b.getX() >= (p2.getX() - b.getRadio()*2 ) && b.getX() <= ( p2.getX() + b.getDX() - b.getRadio()*2) ) {
            if( b.getY() >= p2.getY() && b.getY() <= p2.getY()+p2.longitud ){
                b.generarDireccion( p2.getDY() );
                //Sonido de la pelota.
                playBoing();
                    //Aquí termina audio
                this.p2.setPuntuacion( this.p2.getPuntuacion() + 100 );
                
            }
        }

        if( b.getX() <= ( p1.getX() + 20 ) && b.getX() >= ( p1.getX() + 20 + b.getDX()  )  ){
            if( b.getY() >= p1.getY() && b.getY() <= p1.getY()+p1.longitud ){
                b.generarDireccion( p1.getDY() );
                    //Aquí se escuchará el rebote
                    //Se llama al método
                playBoing();
                    //Aquí termina audio
                this.p1.setPuntuacion( this.p1.getPuntuacion() + 100 );
                
            }
        }

        if( b.getY() <= 0 ){
            b.setY( VentanaPong.getAlto() );
        }
        if( b.getY() > VentanaPong.getAlto() ){
            b.setY(0);
        }
                
        if( b.getX() <= -100 ){
            if( !anotacion ){
                this.p2.setAnotaciones( this.p2.getAnotaciones() + 1 );
                this.p2.setPuntuacion( this.p2.getPuntuacion() + 500 );
                
                turno = false;
            }
            anotacion = true;
        }
                
        if( b.getX() >= VentanaPong.getAncho() + 100 ){
            if( !anotacion ){
                this.p1.setAnotaciones( this.p1.getAnotaciones() + 1 );
                this.p1.setPuntuacion( this.p1.getPuntuacion() + 500 );
                
                turno = true;
            }
            anotacion = true;
        }
                
        if( b.getX() <= -300 ){
            reiniciarPong();
        }
                
        if( b.getX() >= VentanaPong.getAncho() + 300 ){
            reiniciarPong();
        }
                
    }
    
    /**
     * Crea dos pelotas falsas en la partida. Estas pelotas son mostradas
     * al jugador, pero no pueden ser tocadas, y anotar con ellas no hace que
     * se reinicie la partida o que se gane un punto.
     */
    public void crearPelotasFalsas(  ){
        this.bFalse1 = new Pelota();
        this.bFalse2 = new Pelota();
        bFalse1.setX( this.b.getX() );
        bFalse1.setY( this.b.getY() );
        bFalse1.setDX( b.getDX() );
        bFalse1.setDY( b.getDY() +1 );
        bFalse2.setX( this.b.getX() );
        bFalse2.setY( this.b.getY() );
        bFalse2.setDX( b.getDX() );
        bFalse2.setDY( b.getDY() - 1 );
    }

    /**
     * Devuelve el n&uacute;mero del jugador ganador de la partida.
     * @return El n&uacute;mero del jugador ganador de la partida.
     */
    public int obtenerGanador(){
        int ganador = 0;
        if( p1.getAnotaciones() == 3 )
            ganador = 1;
        if( p2.getAnotaciones() == 3 )
            ganador = 2;
        return ganador;
    }
    
    /**
     * Devuelve las anotaciones del jugador uno.
     * @return Las anotaciones del jugador uno.
     */
    public int obtenerPlayer1(){
        return anotacion1;
    }
    
    /**
     * Devuelve las anotaciones del jugador dos.
     * @return Las anotaciones del jugador dos.
     */
    public int obtenerPlayer2(){
        return anotacion2;
    }
    
    /**
     * Devuelve la puntuaci&oacute;n del jugador ganador.
     * @return La puntuaci&oacute;n del jugador ganador.
     */
    public int puntuacionGanadora(){
        if( p1.getAnotaciones() == 3 )
            return p1.getPuntuacion();
        else
        return p2.getPuntuacion();
    }
    
    /**
     * Devuelve la puntuaci&oacute;n del jugador uno.
     * @return La puntuaci&oacute;n del jugador uno.
     */
    public int puntuacionPlayer1(){
        return puntuacion1;
    }
    
    /**
     * Devuelve la puntuaci&oacute;n del jugador dos.
     * @return La puntuaci&oacute;n del jugador dos.
     */
    public int puntuacionPlayer2(){
        return puntuacion2;
    }
    
    @Override
    public void paintComponent( Graphics g ){
        super.paintComponent(g);

        BufferedImage img =  null;
        try{
            img = ImageIO.read(getClass().getResourceAsStream(Media.FONDO + indexFondo  + "_" + frame + ".png") );
            g.drawImage( img, 0, 0, null );
            p1.mostrarJugador(g, frame);
            p2.mostrarJugador(g, frame);
            b.mostrarPelota(g, frame);
        }
        catch( IOException e  ){
            System.out.println("Error al encontrar las imagenes");
        }catch (ExcepcionPelotaNoExistente e) {
            
        }
        
        try{
            bFalse1.mostrarPelota(g, frame);
            bFalse2.mostrarPelota(g, frame);
        }
        catch( ExcepcionPelotaNoExistente e ){
            
        }
        


        g.setColor(Color.WHITE);
        g.setFont( new Font("Broadway", Font.BOLD, 50) );
        g.drawString( Integer.toString( this.p1.getAnotaciones() ) , 225 , 50);
        g.drawString( Integer.toString( this.p2.getAnotaciones() ) , 600 , 50);
        g.setFont( new Font("Broadway", Font.BOLD, 20) );
        g.drawString( Integer.toString( this.p1.getPuntuacion() ) , 220, 80 );
        g.drawString( Integer.toString( this.p2.getPuntuacion() ) , 595, 80);



    }
    
    /**
     * Reproduce el sonido de un rebote de la pelota contra un jugador.
     */
    private void playBoing(){
        //Se asigna los valores estáticos necesarios y se reproduce
        boing = new javafx.scene.media.Media(this.getClass().getResource("/pong/media/Boing2.mp3").toString());
        reproducirRebote = new MediaPlayer(boing);
        reproducirRebote.play();
    }

}
