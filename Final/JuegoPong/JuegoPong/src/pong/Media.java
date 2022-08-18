/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

/**
 * Almacena las rutas de los sprites y la m&uacute;sica que se utiliza en el juego. 
 */
public interface Media {
    
    /**
     *
     */
    String RUTA = "/pong/media/";
    
    /**
     *
     */
    String JUGADOR = RUTA +"Jugador";
   
    /**
     *
     */
    String PELOTA = RUTA + "Pelota";
   
    /**
     *
     */
    String FONDO = RUTA + "Fondo";
   
    /**
     *
     */
    String SONIDO_CHOQUE =  RUTA + "Choque.mp3";
   
    /**
     *
     */
    String SONIDO_RODANDO = RUTA + "Rodando.mp3";
   
    /**
     *
     */
    String MUSICA = RUTA + "Musica.mp3";
    
    
    
}
