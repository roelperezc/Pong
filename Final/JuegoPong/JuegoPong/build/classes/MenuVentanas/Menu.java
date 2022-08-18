
package MenuVentanas;

/**
 *Clase que representa una ventana, en la cual se decide si se quiere ingresar o crear un usuario
 * 
 */
public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        botonesTransparentes();
        this.setLocationRelativeTo(null);//para que este en el centro 
    }
    
    /**
     * El metodo botonesTransparentes se encarga de 
     * transparentar los botones presentados en el menu.
     */
    public void botonesTransparentes(){
        jButton1.setOpaque(false); //Hacemos que  no se dibujen los pixeles del boton
        jButton1.setContentAreaFilled(false); //Opcion principal para tener un boton transparente
        jButton1.setBorderPainted(false); //No dibujamos el borde
       
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        
       CrearUsu.setOpaque(false);
       CrearUsu.setContentAreaFilled(false);
       CrearUsu.setBorderPainted(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CrearUsu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CrearUsu.setBackground(new java.awt.Color(255, 255, 255));
        CrearUsu.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        CrearUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Boton usuario.png"))); // NOI18N
        CrearUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CrearUsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrearUsuMouseClicked(evt);
            }
        });
        CrearUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearUsuActionPerformed(evt);
            }
        });
        getContentPane().add(CrearUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 270, 140));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Boton ingresar.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 270, 120));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/salirs.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 40, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pong_menu.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, -1, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CrearUsuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * Este metodo se encarga de cerrar todas las componentes del programa,
     * esto despues de pulsar dicho boton.
     */
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
      System.exit(0);
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * Este metodo se encarga de llamar a la ventana "Ingresar" y cerrar la ventana actual,
     * esto despues de pulsar dicho boton.
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Ingresar ing=new Ingresar();//Creamos una instancia de la ventana "Ingresar"
        this.setVisible(false);//Cerramos la ventana actual
        ing.setVisible(true);//Hacemos visible la ventana "Ingresar"
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * Este metodo se encarga de llamar a la ventana "CrearUsuario" y cerrar la ventana actual,
     * esto despues de pulsar dicho boton.
     */
    private void CrearUsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearUsuMouseClicked
        CrearUsuario crear=new CrearUsuario(); //Creamos una instancia de la ventana "CrearUsuario"
        this.setVisible(false);//Cerramos la ventana actual
        crear.setVisible(true);//Hacemos visible la ventana "CrearUsuario"
    }//GEN-LAST:event_CrearUsuMouseClicked

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearUsu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
