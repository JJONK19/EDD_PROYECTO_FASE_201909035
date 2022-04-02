/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Aplicacion;

import Estructuras.ArbolB;
import Estructuras.NodoABB;
import Estructuras.NodoAVL;
import Estructuras.NodoB;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author JJONK19
 */
public class CImagenes extends javax.swing.JDialog {

    /**
     * Creates new form CImagenes
     */
    public CImagenes(java.awt.Frame parent, boolean modal) {
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
        jLabel1 = new javax.swing.JLabel();
        icono = new javax.swing.JLabel();
        generar = new javax.swing.JButton();
        actualiza = new javax.swing.JButton();
        lista = new javax.swing.JComboBox<>();
        gencap = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        arbol = new javax.swing.JLabel();

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
        jLabel1.setText("Capas por Imágen");

        generar.setBackground(new java.awt.Color(53, 108, 114));
        generar.setFont(new java.awt.Font("Candara Light", 2, 16)); // NOI18N
        generar.setForeground(new java.awt.Color(255, 255, 255));
        generar.setText("Generar Arbol de Imágenes");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });

        actualiza.setBackground(new java.awt.Color(53, 108, 114));
        actualiza.setFont(new java.awt.Font("Candara Light", 2, 16)); // NOI18N
        actualiza.setForeground(new java.awt.Color(255, 255, 255));
        actualiza.setText("Actualizar Lista de Capas");
        actualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizaActionPerformed(evt);
            }
        });

        lista.setBackground(new java.awt.Color(53, 108, 114));
        lista.setFont(new java.awt.Font("Candara Light", 0, 16)); // NOI18N
        lista.setForeground(new java.awt.Color(0, 0, 0));
        lista.setBorder(null);
        lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaActionPerformed(evt);
            }
        });

        gencap.setBackground(new java.awt.Color(53, 108, 114));
        gencap.setFont(new java.awt.Font("Candara Light", 2, 16)); // NOI18N
        gencap.setForeground(new java.awt.Color(255, 255, 255));
        gencap.setText("Mostrar Capa");
        gencap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gencapActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(ar);

        jScrollPane2.setViewportView(arbol);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(generar, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lista, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gencap, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(actualiza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lista)
                        .addComponent(gencap, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        try{
            URL url = new File("src/main/java/Imagenes/LogoR(I).png").toURI().toURL();
            ImageIcon imageIcon = new ImageIcon(url);
            icono.setIcon(imageIcon);
        }catch(Exception e){

        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        // TODO add your handling code here:
        int ban = 0;

        if(aux.contenido.imagenes.raiz != null){
            aux.contenido.imagenes.dibujar("src/main/java/Imagenes/AVL.txt", "src/main/java/Imagenes/AVL.png");
            ban = 1;
        }else{
            JOptionPane.showMessageDialog(this, "El arbol está vacío.");
        }

        if(ban == 1){
            File a = new File ("src/main/java/Imagenes/AVL.png");
            if(a.exists()){
                try {
                    BufferedImage img = ImageIO.read(a.getAbsoluteFile());
                    arbol.setSize(img.getWidth(), img.getHeight());
                    arbol.setIcon(new ImageIcon(img));
                }catch (IOException ex) {

                }
            }else{
                arbol.setIcon(null);

            }
        }
    }//GEN-LAST:event_generarActionPerformed
    
    //LLenar Lista de nombres
    public void llenar(NodoAVL inicio, ArrayList a){
        if(aux.contenido.imagenes.raiz != null){
            if(inicio.hijo1 != null){
                llenar(inicio.hijo1, a);
            }

            a.add(Integer.toString(inicio.content.id)); 

            if(inicio.hijo2 != null){
                llenar(inicio.hijo2, a);
            }
        }
    }
    
    private void actualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizaActionPerformed
        // TODO add your handling code here:
        if(aux.contenido.imagenes.raiz != null){
            ArrayList<String> x = new ArrayList();
            //Recorrer arbol
            llenar(aux.contenido.imagenes.raiz, x);
            //Crear Modelo
            DefaultComboBoxModel nuevo = new DefaultComboBoxModel();
            nuevo.addElement("Seleccionar");
            for(int i = 0; i < x.size(); i++){
                nuevo.addElement(x.get(i));
            }
            lista.setModel(nuevo);
        }else{
            JOptionPane.showMessageDialog(this, "El arbol está vacío.");
        }

    }//GEN-LAST:event_actualizaActionPerformed

    private void listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaActionPerformed
        // TODO add your handling code here:
        if(aux.contenido.imagenes.raiz != null){
            String na =  (String) lista.getSelectedItem();
            int name = Integer.valueOf(na);
            NodoAVL bus = aux.contenido.imagenes.search(name);
            
            bus.content.capas.dibujar("src/main/java/Imagenes/ABB.txt", "src/main/java/Imagenes/ABB.png");

        }else{
            JOptionPane.showMessageDialog(this, "El arbol está vacío.");
        }
    }//GEN-LAST:event_listaActionPerformed

    private void gencapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gencapActionPerformed
        // TODO add your handling code here:
        String na =  (String) lista.getSelectedItem();
        if(na == null || na.length() == 0){

        }else{
            if(aux.contenido.imagenes.raiz != null){
                File a = new File ("src/main/java/Imagenes/ABB.png");
                if(a.exists()){
                    try {
                        BufferedImage img = ImageIO.read(a.getAbsoluteFile());
                        ar.setSize(img.getWidth(), img.getHeight());
                        ar.setIcon(new ImageIcon(img));
                    }catch (Exception ex) {

                    }
                }else{
                    ar.setIcon(null);

                }
            }else{
                JOptionPane.showMessageDialog(this, "El arbol está vacío.");
            }
        }

    }//GEN-LAST:event_gencapActionPerformed

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
            java.util.logging.Logger.getLogger(CImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CImagenes dialog = new CImagenes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton actualiza;
    private javax.swing.JLabel ar;
    private javax.swing.JLabel arbol;
    private javax.swing.JButton gencap;
    private javax.swing.JButton generar;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> lista;
    // End of variables declaration//GEN-END:variables
}