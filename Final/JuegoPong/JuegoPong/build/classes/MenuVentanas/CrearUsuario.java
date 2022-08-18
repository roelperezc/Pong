
package MenuVentanas;

import javax.swing.JOptionPane;
import java.io.*;

    /**
     * La clase <i>CrearUsuario</i>, representa una forma en la que se puede, si no 
     * ha sido creado el jugador una forma en la que se puede registrar e iniciar el 
     * juego
     */
public class CrearUsuario extends javax.swing.JFrame {
    
    /**
    * Se inicializan las ventanas y los botones que la contieneen, con el 
    * objetivo de que estas aparezcan en el centro de la venntana abierta
    */
    public CrearUsuario() {
       initComponents();
       botonesTransparentes();
        this.setLocationRelativeTo(null);//para que este en el centro 
    }
    
    /**
     * El metodo botonesTransparentes se encarga de 
     * transparentar los botones presentados en el menu.
     */
     public void botonesTransparentes(){
     
        jButton1.setOpaque(false);//Hacemos que  no se dibujen los pixeles del boton
        jButton1.setContentAreaFilled(false);//Opcion principal para tener un boton transparente
        jButton1.setBorderPainted(false);//No dibujamos el borde
        
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        Pass1 = new javax.swing.JPasswordField();
        Pass2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel2.setText("Nuevo usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 140, 40));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel4.setText("Confirma tu contraseña:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        nombre.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 260, 30));

        Pass1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 210, 30));

        Pass2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 210, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/crear.png"))); // NOI18N
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 80, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/salirs.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpeg"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents
        /**
         * Este es el boton que hace referencia a la salida de la ventana, poniendo fin a lo que se llevaba de
         * avance en el juego, ya que cierra por completo todos los archivos, ventanas, hilos, que se estaban
         * ejecutando
         */
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        
        System.exit(0);
    }//GEN-LAST:event_jButton2MouseClicked
        /**
        * El evento "botón", en este caso es una forma en la cual se realiará una 
        * búsqueda del archivo deseado y en caso de existir se realizará una
        * lectura del mismo linea por línea, obteeniendo cada dato por separado 
        * ya que se colocarron ";" para que cada elemento de la información se
        * localizara de una formma más rápida, por lo que una vez encontrado el
        * jugador se verificará que no se hayan creado con las mismas contraseñas
        * enviando un mensaje si éste fuera el caso, de no ser así el jugador se ha 
        * registrado de manera adecuada y puede continuar con su partida.
        */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
       if(nombre.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Por favor escribe un nombre de usuario");
       }
       else if(Pass1.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Por favor escribe una contraseña");
       }
       else if(Pass2.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Por favor confirma tu contraseña");
       }
       else if(Pass1.getText().equals(Pass2.getText())){
           try{

		File archivo  = new File("usuarios.txt");
		FileWriter escribir = new FileWriter(archivo,true);
		PrintWriter linea = new PrintWriter(escribir);
		String Nombre="";

		if(archivo.exists()){
                    linea.println(nombre.getText()+";"+Pass1.getText()+";"+"0");
                    linea.close();
                    escribir.close();
				}
				else{
					escribir= new FileWriter(archivo);
					linea.println(nombre.getText()+";"+Pass1.getText()+";"+"0");
					linea.close();
					escribir.close();
				}

				}catch(Exception ex){
					ex.printStackTrace();
				}
           Menu men=new Menu();
           men.setVisible(true);
           this.setVisible(false);
           JOptionPane.showMessageDialog(null,"Tu usuario se ha creado correctamente");   
       }
       else{
           JOptionPane.showMessageDialog(null,"Las contraseñas no son las mismas,, intentalo de nuevo.");
               }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuario().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Pass1;
    private javax.swing.JPasswordField Pass2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
