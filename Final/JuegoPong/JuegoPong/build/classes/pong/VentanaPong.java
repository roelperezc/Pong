/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.HashSet;


/**
 * <i>Ventana Pong</i> es la ventana de JFrame en la que se mostrar&aacute; la partida
 * de Pong. Implementa interfaces para detecci&oacute;n de botones del mouse y acciones
 * en la ventana.
 */
public class VentanaPong extends JFrame implements KeyListener{
	
    /**
     *
     */
    protected Pong pong;
    private final static int ALTO = 600;
    private final static int ANCHO = 850; 
    HashSet<Character> teclasPresionadas = new HashSet();
   
    static Ejecucion exe;

    /**
     * Devuelve el ancho en pixeles de la ventana.
     * @return El ancho de la ventana.
     */
    public static int getAncho(){
        return ANCHO;
    }

    /**
     * Devuelve el alto en pixeles de la ventana.
     * @return El alto de la ventana.
     */
    public static int getAlto(){
        return ALTO;
    }
        
    /**
     * Devuelve la instancia de Pong en esta ventana.
     * @return La instancia de Pong de la ventana.
     */
    public Pong getPong(){
        return this.pong;
    }

    /**
     * Constructor de la ventana. Se encarga de crear una instancia de Pong y
     * las caracter&iacute;sticas de la ventana, sin hacerla visible.
     */
    public VentanaPong(){
        this.addKeyListener(this);
        pong = new Pong();
        lanzarVentana();
    }
    
    /**
     * Asigna a la ventana sus caracter&iacutesticas, sin lanzarla.;
     */
    private void lanzarVentana(){
        setTitle("Pong");
        setSize(ANCHO, ALTO);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    

    @Override
    public synchronized void keyPressed( KeyEvent e ){
		
        teclasPresionadas.add( e.getKeyChar() );

        for( Character i : teclasPresionadas ){
            pong.getP1().acelerar( KeyEvent.getExtendedKeyCodeForChar(i) );
            pong.getP2().acelerar( KeyEvent.getExtendedKeyCodeForChar(i) );
        }
    }

    @Override
    public synchronized void keyReleased( KeyEvent e ){
        teclasPresionadas.remove( e.getKeyChar() );
    }

    @Override
        public void keyTyped( KeyEvent e ){
    }

}