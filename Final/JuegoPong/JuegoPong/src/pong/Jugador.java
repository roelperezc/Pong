/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * La clase abstracta <i>Jugador</i> representa a un jugador gen&eacute;rico en 
 * la partida de Pong. Para crear a un jugador concreto, deben definirse las teclas
 * que se utilizan para moverlo.
 */
public abstract class Jugador {
    
    private int puntuacion;
    private int anotaciones;

    final public int longitud = 150; 


    private int x; 
    private int y;
    private int dy;

    /**
     * Devuelve la puntuaci&oacute;n actual del jugador.
     * @return La puntuaci&oacute;n actual del jugador.
     */
    public int getPuntuacion(){
        return this.puntuacion;
    }

    /**
     * Asigna un valor a la puntuaci&oacute;n del juguador.
     * @param p La nueva puntuaci&oacute;n del jugador.
     */
    public void setPuntuacion(int p){
        this.puntuacion = p;
    }

    /**
     * Devuelve la cantidad de anotaciones actual del jugador.
     * @return La cantidad de anotacinoes del jugador.
     */
    public int getAnotaciones(){
        return this.anotaciones;
    }

    /**
     * Asigna un valor a las anotaciones del jugador.
     * @param a El nuevo valor de las anotaciones del jugador.
     */
    public void setAnotaciones(int a){
        this.anotaciones = a;
    }

    /**
     * Devuelve la posici&oacute;n en x del jugador.
     * @return La posici&oacute;n en x del jugador.
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * Devuelve la posici&oacute;n en y del jugador.
     * @return La posici&oacute;n en y del jugador.
     */
    public int getY(){
        return this.y;
    }
    
    /**
     * Asigna un valor a la posici&oacute;n en x del jugador.
     * @param x La nueva posici&oacute;n en x del jugador.
     */
    public void setX( int x ){
        this.x = x;
    }
    
    /**
     * Asigna un valor a la posici&oacute;n en y del jugador.
     * @param y La nueva posici&oacute;n en y del jugador.
     */
    public void setY( int y ){
        this.y = y;
    }
    
    /**
     * Devuelve la velocidad en y del jugador.
     * @return La velocidad en y del jugador.
     */
    public int getDY(){
        return this.dy;
    } 
    
    /**
     * Asigna un valor a la velocidad en y del jugador.
     * @param dy El nuevo valor de velocidad en y del jugador.
     */
    public void setDY( int dy ){
        this.dy = dy;
    }

    /**
     * Acelera la pelota basada en la tecla que est&aacute; siendo presionada.
     * @param e La clave de la tecla que est&aacute; siendo presionada. 
     */
    abstract void acelerar(int e);

    /**
     * Modifica la posici&oacute;n del jugador basado en su velocidad actual.
     */
    public void mover(){

        y = y + dy;

        if( y <= 10 ){
            y = 10;
        }
        else if( y >=  VentanaPong.getAlto() - ( 40 + (longitud) ) ){
            y = VentanaPong.getAlto() - ( 40 + (longitud) ) ;
        }

    }

    /**
     * Muestra el jugador en la ventana de la partida.
     * @param g El gr&aacute;fico del panel de la ventana donde se muestra el jugador.
     * @param frame Indica qu&eacute; cuadro del sprite deber&iacute;a mostrarse.
     */
    public void mostrarJugador(Graphics g, int frame) {
        BufferedImage img = null;
        try{
            img = ImageIO.read( getClass().getResourceAsStream( Media.JUGADOR + frame + ".png" ) );
        }
        catch(IOException e){
            System.out.println("Imagen no encontrada.");
        }
        g.drawImage( img, x, y, null );

    }

}
