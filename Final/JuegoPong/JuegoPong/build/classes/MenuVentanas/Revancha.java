
package MenuVentanas;
import pong.Pong;

/**
 *La clase Revancha representa a una ventana, la cual se muestra cuando el juego concluye y decide el usuario si quiere seguir jugando o no 
 *
 */
public class Revancha extends javax.swing.JFrame {
    Pong pong = new Pong();
    Ingresar ingresar = new Ingresar();

    /**
     * Creates new form Revancha
     */
    public Revancha() {
         initComponents();
         mostrarPuntuaciones();
         botonesTransparentes();
        this.setLocationRelativeTo(null);//para que este en el centro 
    }
    
    /**
     * El metodo botonesTransparentes se encarga de 
     * transparentar los botones presentados en el menu.
     */
     public void botonesTransparentes(){
       Revancha.setOpaque(false);//Hacemos que  no se dibujen los pixeles del boton
       Revancha.setContentAreaFilled(false);//Opcion principal para tener un boton transparente
       Revancha.setBorderPainted(false);//No dibujamos el borde
        
       Salir.setOpaque(false);
       Salir.setContentAreaFilled(false);
       Salir.setBorderPainted(false);
    }
     
     /**
      * El metodo mostrara en un jlabel las puntuaciones comenzando por la mas alta dicendo que usuario fue el ganador 
      */
     public void mostrarPuntuaciones(){
        if (pong.obtenerPlayer1() == 3){//se obtienen las puntuaciones desde la clase pong que fue instanciada anteriormente
            puntuaciones.setText(ingresar.getUsuario()+" ha ganado con "+pong.puntuacionPlayer1()+" puntos \n\n"+ingresar.getUsuario2()+" ha perdido con "+pong.puntuacionPlayer2()+" puntos");
            
        }//dependiendo de la puntuacion es el ganador que se mostrara en el jlabel. 
        else{
            puntuaciones.setText(ingresar.getUsuario2()+" ha ganado con "+pong.puntuacionPlayer2()+" puntos \n\n"+ingresar.getUsuario()+" ha perdido con "+pong.puntuacionPlayer1()+" puntos");
        }
  
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Revancha = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        puntuaciones = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        puntuaciones1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Revancha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/REVANCHA.png"))); // NOI18N
        Revancha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RevanchaMouseClicked(evt);
            }
        });
        getContentPane().add(Revancha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 333, 130, 70));

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/SALIRREV.png"))); // NOI18N
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 333, 130, 70));

        puntuaciones.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        getContentPane().add(puntuaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 490, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pong rev.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        puntuaciones1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        getContentPane().add(puntuaciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 400, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RevanchaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RevanchaMouseClicked
        // TODO add your handling code here:
        Instrucciones instrucciones = new Instrucciones();//creamos una instancia de la ventana instrucciones
        instrucciones.setVisible(true);// Se muestra nuevamente la ventana de insrucciones 
       this.setVisible(false);//se oculta esta ventana
    }//GEN-LAST:event_RevanchaMouseClicked

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Revancha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Revancha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Revancha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Revancha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Revancha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Revancha;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel puntuaciones;
    private javax.swing.JLabel puntuaciones1;
    // End of variables declaration//GEN-END:variables
}
