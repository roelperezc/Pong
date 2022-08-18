/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

/**
 * Excepci&oacute;n que ocurre si la pelota no es visible para evitar
 * que se muestre o se mueva.
 */
public class ExcepcionPelotaNoExistente extends Exception {
    
    /**
     * Constructor de <i>ExcepcionPelotaNoExistente</i>.
     */
    ExcepcionPelotaNoExistente( ){
        super("La pelota no existe");
    }
    
}
