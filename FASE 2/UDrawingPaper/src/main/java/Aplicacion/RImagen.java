/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Aplicacion;

import Estructuras.ArbolABB;
import Estructuras.ArbolB;
import Estructuras.Imagen;
import Estructuras.NodoABB;
import Estructuras.NodoB;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author JJONK19
 */
public class RImagen extends javax.swing.JDialog {

    /**
     * Creates new form RImagen
     */
    public RImagen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        capas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        registrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UDrawing Paper");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(253, 251, 251));

        jLabel1.setFont(new java.awt.Font("Candara Light", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Registrar Imagen");

        jLabel6.setFont(new java.awt.Font("Candara Light", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ID de Imagen");

        id.setBackground(new java.awt.Color(253, 251, 251));
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Candara Light", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lista de Capas");

        capas.setBackground(new java.awt.Color(253, 251, 251));
        capas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        capas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capasActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Candara Light", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Asegurese que ID sea un número. No se aceptan letras o cualquier otro carácter. Para las capas, ingrese los IDs separados por una coma. ");

        registrar.setBackground(new java.awt.Color(53, 108, 114));
        registrar.setFont(new java.awt.Font("Candara Light", 2, 16)); // NOI18N
        registrar.setForeground(new java.awt.Color(255, 255, 255));
        registrar.setText("Registrar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id)
                                    .addComponent(capas, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                                    .addComponent(registrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(capas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        try{
            URL url = new File("src/main/java/Imagenes/LogoR(I).png").toURI().toURL();
            ImageIcon imageIcon = new ImageIcon(url);
            icono.setIcon(imageIcon);
        }catch(Exception e){

        }
        id.setText("");

        //Adaptado de https://stackoverflow.com/questions/3519151/how-to-limit-the-number-of-characters-in-jtextfield
        id.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (id.getText().length() >= 13 ) // limit textfield to 3 characters
                e.consume();
            }
        });
        id.setText("");

        //Adaptado de https://stackoverflow.com/questions/3519151/how-to-limit-the-number-of-characters-in-jtextfield
        id.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (id.getText().length() >= 13 ) // limit textfield to 3 characters
                e.consume();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //Serealizar
        try{    
            //Crear data    
            FileOutputStream f=new FileOutputStream("src/main/java/data.ser");    
            ObjectOutputStream out=new ObjectOutputStream(f); 
            out.writeObject(data);    
            out.flush();        
            out.close();    
        }catch(Exception e){
                    
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        // TODO add your handling code here:
        try {
            FileInputStream abrir = new FileInputStream("src/main/java/data.ser");
            ObjectInputStream escribir = new ObjectInputStream(abrir);
            data =  (ArbolB) escribir.readObject();
            escribir.close();
            abrir.close();
            user = Usuario.user;
            aux = data.buscar(user, data.raiz);
            
        } catch (IOException i) {
           data = new ArbolB();
           i.printStackTrace();
            
        } catch (ClassNotFoundException c) {
            data = new ArbolB();
            
        }
    }//GEN-LAST:event_formWindowOpened

    private void capasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capasActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        // TODO add your handling code here:
        if(aux.contenido.capas.raiz != null){
           try{
               int ban = 0;
               String ID = id.getText();
               String lista = capas.getText();
               int d = Integer.valueOf(ID);
               lista = lista.replace(" ", "");
               String[] l = lista.split(",");
               ArbolABB nuevo = new ArbolABB();
               //Generar Arbol
               if(aux.contenido.imagenes.search(d) == null){
                   for(int i = 0; i < l.length; i++){
                       String temp = l[i];
                       int t = Integer.valueOf(temp);
                       NodoABB dat = aux.contenido.capas.search(t);
                       if(dat == null){
                           ban = 1;
                       }else{
                           nuevo.add(dat.content, nuevo.raiz);
                       }
                   }
                   
                   Imagen a = new Imagen(d, nuevo);
                   aux.contenido.imagenes.add(a);
                   aux.contenido.imagenes.dibujar("src/main/java/Imagenes/AVL.txt", "src/main/java/Imagenes/AVL.png");
                   id.setText("");
                   capas.setText("");
                   if(ban == 1){
                       JOptionPane.showMessageDialog(this, "Proceso completo. Algunas capas no existen.");
                   }else{
                       JOptionPane.showMessageDialog(this, "Proceso finalizado con exito..");
                   }
               }else{
                   JOptionPane.showMessageDialog(this, "El identificador de su imagen ya existe.");
               }
           }catch(Exception e){
               JOptionPane.showMessageDialog(this, "Ocurrio un error. Verifique sus entradas.");
           }
           
        }else{
            JOptionPane.showMessageDialog(this, "No hay Capas cargadas en memoria.");
        }

    }//GEN-LAST:event_registrarActionPerformed
    public ArbolB getArbol(){
        return data;
    }
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
            java.util.logging.Logger.getLogger(RImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RImagen dialog = new RImagen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    String user = "";
    ArbolB data = new ArbolB();
    NodoB aux = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField capas;
    private javax.swing.JLabel icono;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton registrar;
    // End of variables declaration//GEN-END:variables
}