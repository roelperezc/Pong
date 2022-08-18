/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.KeyEvent;

/**
 * La clase <i>JugadorUno</i> 
 */
public class JugadorUno extends Jugador {

    /**
     * Constructor del jugador de la izquierda.
     * Se inicializa con cero puntos y anotaciones.
     */
    JugadorUno(){
        setPuntuacion(0);
        setX( 20 );
        setY( ((VentanaPong.getAlto())/2) - (longitud/2) );
    }

    /**
     * Constructor del jugador.
     * Inicializa su posici&oacute;n con la puntuaci&oacute;n y cantidad de anotaciones
     * actual.
     * @param p La puntuaci&oacute;n actual del jugador.
     * @param a La cantidad de anotaciones actual del jugador.
     */
    JugadorUno( int p, int a ){
        setPuntuacion(p);
        setAnotaciones(a);
        setX( 20 );
        setY( ((VentanaPong.getAlto())/2) - (longitud/2) );
    }


    @Override
    void acelerar( int e){
        if( e == KeyEvent.VK_W ){
            if( Math.abs(getDY()) >= 8 ){
                setDY( getDY() );
            }
            else{
                setDY(getDY()-2);
            }
        }

        if( e == KeyEvent.VK_S ){
            if( Math.abs(getDY()) >= 8 ){
                setDY( getDY() );
            }
            else{
                setDY(getDY()+2);
            }
        }


    }


}