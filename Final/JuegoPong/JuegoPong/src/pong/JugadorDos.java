/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.KeyEvent;

/**
 * La clase <i>JugadorDos</i>
 * @author Roel Pérez
 */
public class JugadorDos extends Jugador{

    /**
     * Constructor del jugador de la derecha.
     * Se inicializa con cero puntos y anotaciones.
     */
    JugadorDos(){
        setPuntuacion(0);
        setX( VentanaPong.getAncho() - 40 ); 
        setY( ((VentanaPong.getAlto())/2) - (longitud/2) ); 
    }

    /**
     * Constructor del jugador.
     * Inicializa su posici&oacute;n con la puntuaci&oacute;n y cantidad de anotaciones
     * actual.
     * @param p La puntuaci&oacute;n actual del jugador.
     * @param a La cantidad de anotaciones actual del jugador.
     */
    JugadorDos(int p, int a){
        setPuntuacion(p);
        setAnotaciones(a);
        setX( VentanaPong.getAncho() - 40 ); 
        setY( ((VentanaPong.getAlto())/2) - (longitud/2) );
    }

    @Override
    void acelerar( int e ){
        if( e == KeyEvent.VK_O ){
            if( Math.abs(getDY()) >= 8 ){
                setDY( getDY() );
            }
            else{
                setDY(getDY()-2);
            } 
        }

        if( e == KeyEvent.VK_K ){
            if( Math.abs(getDY()) >= 8 ){
                setDY( getDY() );
            }
            else{
                setDY(getDY()+2);
            }
        }

    }

}