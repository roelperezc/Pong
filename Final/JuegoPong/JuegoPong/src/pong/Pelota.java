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
 * La clase <i>Pelota</i> es la pelota en la partida. 
 */
public class Pelota {

    private int x;
    private int y;
    private int radio;

    private int dx;
    private int dy;
    private int rapidez;
    
    private boolean visible;

    /**
     * Constructor que inicializa a la pelota en el centro de la pantalla
     * con cierta rapidez.
     */
    Pelota(){
        this.x = VentanaPong.getAncho()/2;
        this.y = VentanaPong.getAlto()/2;
        this.dx = 0;
        this.dy = 0;
        this.radio = 10;
        this.rapidez = 9;
        visible = true;
    }

    /**
     * Devuelve la posici&oacute;n en x de la pelota.
     * @return La posici&oacute;n en x de la pelota
     */
    public int getX(){
        return this.x;
    }
    
     /**
     * Devuelve la posici&oacute;n en y de la pelota.
     * @return La posici&oacute;n en y de la pelota
     */
    public int getY(){
        return this.y;
    }
    
    /**
     * Asigna un valor a la posici&oacute;n en x.
     * @param x La nueva posici&oacute;n en x.
     */
    public void setX( int x ){
        this.x = x;
    } 
    
    /**
     * Asigna un valor a la posici&oacute;n en y.
     * @param y La nueva posici&oacute;n en y.
     */
    public void setY( int y ){
        this.y = y;
    }
    
    /**
     * Devuelve la velocidad en x de la pelota.
     * @return La velocidad en x de la pelota
     */
    public int getDX(){
        return this.dx;
    }
    
    /**
     * Devuelve la velocidad en y de la pelota.
     * @return La velocidad en y de la pelota
     */
    public int getDY(){
       return this.dy;
    }
    
    /**
     * Asigna un valor a la velocidad en x.
     * @param dx La nueva velocidad en x.
     */
    public void setDX( int dx ){
        this.dx = dx;
    } 
    
    /**
     * Asigna un valor a la velocidad en y.
     * @param dy La nueva velocidad en y.
     */
    public void setDY( int dy ){
        this.dy = dy;
    }
    
    /**
     * Devuelve el radio de la pelota.
     * @return El radio de la pelota.
     */
    public int getRadio(){
        return this.radio;
    }
    
    /**
     * Modifica la rapidez de la pelota. Adiciona el valor de dr a la velocidad actual.
     * @param dr El cambio deseado en la velocidad.
     */
    public void cambiarRapidez(int dr){
        this.rapidez = this.rapidez + dr;
    }
    
    /**
     * Devuelve la rapidez de la pelota. 
     * @return La rapidez de la pelota.
     */
    public int getRapidez(){
        return this.rapidez;
    }
    
    /**
     * Hace que la pelota sea visible o invisible al jugador.
     * @param b El estado de visibilidad del jugador.
     */
    public void setVisible( boolean b ){
        this.visible = b;
    }

    /**
     * Muestra la pelota en la ventana de la partida.
     * @param g El gr&aacute; del panel en la ventana donde se muestra el juego.
     * @param frame  Indica qu&eacute; cuadro de la pelota deber&iacute;a mostrarse. 
     * @throws ExcepcionPelotaNoExistente 
     */
    void mostrarPelota(Graphics g, int frame) throws ExcepcionPelotaNoExistente{
        
        if( !visible ){
            throw new ExcepcionPelotaNoExistente();
        }
        
        
        BufferedImage img = null;
        try{
            img = ImageIO.read( getClass().getResourceAsStream( Media.PELOTA + frame + ".png" ) );
        }
        catch( IOException e ){
            System.out.println("Imagen no encontrada.");
        }
        
        g.drawImage( img, x, y, null );

    }

    /**
     * Modifica la posici&oacute;n de la pantalla basado en sus velocidades.
     * @throws ExcepcionPelotaNoExistente 
     */
    public void movimiento() throws ExcepcionPelotaNoExistente {
        if( !visible ){
            throw new ExcepcionPelotaNoExistente();
        }
        x = x + dx;
        y = y + dy;
    }

    /**
     * Lanzamiento de la pelota despu&eacute;s del primer turno.
     * @param turno Indica si la pelota deber&iacute;a salir hacia la izquierda
     * o hacia la derecha.
     */
    public void saque(boolean turno){

        int r = (int)(Math.random()*2);
        if( r == 2 )
            r = -1;

        if( turno ){
            dx = -(int) (Math.ceil(Math.random() * (rapidez - 2)) + 2);
            dy = 1*(int)Math.sqrt( Math.pow( (double)rapidez, (double)2 ) - Math.pow( (double)dx, (double)2 ) );

        }
        else{
            dx = (int) (Math.ceil(Math.random() * (rapidez - 2)) + 2);
            dy = r*(int)Math.sqrt( Math.pow( (double)rapidez, (double)2 ) - Math.pow( (double)dx, (double)2 ) );
        }
    }

    /**
     * Genera la nueva direcci&oacute;n de la pelota despu&eacute;s de una colisi&oacute;n.
     * @param imp Indica hacia d&oacute;nde deber&iacute;a rebotar la pelota en y. 
     */
    public void generarDireccion( int imp ){

         if( imp > 0 )
             imp = 1;
         else if( imp < 0 )
             imp = -1;
         else{
             if( dy > 0 )
                 imp = 1;
             else
                 imp = -1;
         }

        if( x >= (VentanaPong.getAncho()/2) ){
            dx = -(int) (Math.ceil(Math.random() * (rapidez - 2)) + 2);
            dy = imp*(int)Math.sqrt( Math.pow( (double)rapidez, (double)2 ) - Math.pow( (double)dx, (double)2 ) );

        }
        else{
            dx = (int) (Math.ceil(Math.random() * (rapidez - 2)) + 2);
            dy = imp*(int)Math.sqrt( Math.pow( (double)rapidez, (double)2 ) - Math.pow( (double)dx, (double)2 ) );
        }
    }


}
