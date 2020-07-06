
package teoriainfocodificacion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author Lucho
 */
public class PanelHamming extends javax.swing.JPanel {

    private static String archivoElegido;
    private String archivoIzq;
    private String archivoDer;
    private boolean[][] aGuardarHamming;
    private int totalBitsAleer,bloqueHamming; // inicializo en Proteger archivo
    private int tamOrig;
    private int tamRedun;
    private int tamRotos;
    private int tamHamm;

    public PanelHamming() {
        initComponents();
        this.jEditorPaneDer.setContentType("text/html");
        this.jEditorPaneIzq.setContentType("text/html");
        archivoDer="";
        archivoIzq="";
        llenarListaArchivos();
    }
     public void llenarListaArchivos(){
        jComboListaArchivos.removeAllItems(); 
        File directorio = new File("./"); 
        File[] archivos=null;
        if(directorio.exists()){
            archivos = directorio.listFiles();
        }
        int i; 
        for(i=0;i<archivos.length;i++){ 
            jComboListaArchivos.addItem(""+archivos[i]);   
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

        jPanelIzq = new javax.swing.JPanel();
        jLabelTituloIzq = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPaneIzq = new javax.swing.JEditorPane();
        jPanelDer = new javax.swing.JPanel();
        jLabelTituloDer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPaneDer = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboHamming = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelArchHA = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelArchHE = new javax.swing.JLabel();
        jComboArchivosADecodificar = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboListaArchivos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabelArchivoElegido = new javax.swing.JLabel();
        panelEstadisticas = new javax.swing.JPanel();
        labelTamOrg = new javax.swing.JLabel();
        labelEditableTamOrg = new javax.swing.JLabel();
        labelTamaHam = new javax.swing.JLabel();
        labelTamHamEdit = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelBitsRedEditable = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelBitRotosEditable = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelTamBloqueEdit = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelCantBloquesEdit = new javax.swing.JLabel();

        jPanelIzq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanelIzq.setMinimumSize(new java.awt.Dimension(372, 531));
        jPanelIzq.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTituloIzq.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTituloIzq.setText("Nombre Archivo Elegido.txt");
        jPanelIzq.add(jLabelTituloIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 15, -1, 23));

        jEditorPaneIzq.setEditable(false);
        jEditorPaneIzq.setMaximumSize(new java.awt.Dimension(368, 476));
        jEditorPaneIzq.setMinimumSize(new java.awt.Dimension(368, 476));
        jEditorPaneIzq.setPreferredSize(new java.awt.Dimension(368, 476));
        jScrollPane3.setViewportView(jEditorPaneIzq);

        jPanelIzq.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 44, 430, 476));

        jPanelDer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanelDer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTituloDer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTituloDer.setText("Nombre Archivo Elegido.txt");
        jPanelDer.add(jLabelTituloDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 23));

        jEditorPaneDer.setEditable(false);
        jEditorPaneDer.setMaximumSize(new java.awt.Dimension(368, 476));
        jEditorPaneDer.setMinimumSize(new java.awt.Dimension(368, 476));
        jEditorPaneDer.setPreferredSize(new java.awt.Dimension(368, 476));
        jScrollPane1.setViewportView(jEditorPaneDer);

        jPanelDer.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 42, 440, 475));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Codificacion Hamming de Archivos txt.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Historic", 1, 14))); // NOI18N

        jButton3.setText("Dañar Archivo");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText(" Elegir el tamaño de los bloques Hamming:");

        jComboHamming.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "32-BITS (.HA1)", "128-BITS (.HA2)", "1024-BITS (.HA3)", "4096-BITS (.HA4)", "16384-BITS (.HA5)" }));

        jButton1.setText("Proteger Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Decodificar Archivo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setText("ArchivoProtegido:");

        jLabelArchHA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelArchHA.setText("Nombre Archivo Elegido.HAx");

        jLabel7.setText("ArchivoDañado:");

        jLabelArchHE.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelArchHE.setText("Nombre Archivo Elegido.HEx");

        jLabel3.setText(" Elegir el Archivo a desprotejer:");

        jLabel2.setText("Elegir archivo a proteger");

        jComboListaArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboListaArchivosActionPerformed(evt);
            }
        });

        jLabel4.setText("El archivo elegido es :");

        jLabelArchivoElegido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelArchivoElegido.setText("Ejemplo.ext");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboHamming, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboArchivosADecodificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelArchHA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelArchHE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelArchivoElegido, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboListaArchivos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboListaArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelArchivoElegido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboHamming, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelArchHA, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelArchHE, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboArchivosADecodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        panelEstadisticas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Estadisticas"));

        labelTamOrg.setText("Tamaño original:");

        labelEditableTamOrg.setText("-");

        labelTamaHam.setText("Tamaño Hamming:");

        labelTamHamEdit.setText("-");

        jLabel6.setText("Cantidad bits redundantes:");

        labelBitsRedEditable.setText("-");

        jLabel9.setText("Cantidad bits dañados");

        labelBitRotosEditable.setText("-");

        jLabel8.setText("Tamaño del Bloque:");

        labelTamBloqueEdit.setText("-");

        jLabel11.setText("Cantidad de Bloques:");

        labelCantBloquesEdit.setText("-");

        javax.swing.GroupLayout panelEstadisticasLayout = new javax.swing.GroupLayout(panelEstadisticas);
        panelEstadisticas.setLayout(panelEstadisticasLayout);
        panelEstadisticasLayout.setHorizontalGroup(
            panelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTamOrg)
                    .addComponent(labelEditableTamOrg)
                    .addComponent(labelTamaHam)
                    .addComponent(labelTamHamEdit))
                .addGap(185, 185, 185)
                .addGroup(panelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(labelBitsRedEditable)
                    .addComponent(jLabel9)
                    .addComponent(labelBitRotosEditable))
                .addGap(202, 202, 202)
                .addGroup(panelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCantBloquesEdit)
                    .addComponent(jLabel11)
                    .addComponent(labelTamBloqueEdit)
                    .addComponent(jLabel8))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        panelEstadisticasLayout.setVerticalGroup(
            panelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTamOrg)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEditableTamOrg)
                    .addComponent(labelBitsRedEditable)
                    .addComponent(labelTamBloqueEdit))
                .addGap(18, 18, 18)
                .addGroup(panelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTamaHam)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTamHamEdit)
                    .addComponent(labelBitRotosEditable)
                    .addComponent(labelCantBloquesEdit))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(864, Short.MAX_VALUE)
                    .addComponent(jPanelDer, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelDer, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(169, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        bloqueHamming=0;
        String ext="";
        switch(jComboHamming.getSelectedIndex()){//Seleccionado en Panel
            case 0:{
                ext=".HE1";
                bloqueHamming=32;
                totalBitsAleer= cantBitsInfo(bloqueHamming);
                break;
            }
            case 1:{
                ext=".HE2";
                bloqueHamming=128;
                totalBitsAleer= cantBitsInfo(bloqueHamming);
                break;
            }
            case 2:{
                ext=".HE3";
                bloqueHamming=1024;
                totalBitsAleer= cantBitsInfo(bloqueHamming);
                break;
            }
            case 3:{
                ext=".HE4";
                bloqueHamming=4096;
                totalBitsAleer= cantBitsInfo(bloqueHamming);
                break;
            }
            case 4:{
                ext=".HE5";
                bloqueHamming=16384;
                totalBitsAleer= cantBitsInfo(bloqueHamming);
                break;
            }
        }
        String nombreArchivo = jComboArchivosADecodificar.getItemAt(jComboArchivosADecodificar.getSelectedIndex());
        romperArchivo(nombreArchivo, bloqueHamming, ext);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jComboArchivosADecodificar.removeAllItems();
        protegerArchivo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String nombreArchivo = jComboArchivosADecodificar.getItemAt(jComboArchivosADecodificar.getSelectedIndex());
        String ext = nombreArchivo.substring(nombreArchivo.length()-3);//Extencion
        if(ext.contains("HH")){
            decodificarArchivo(nombreArchivo, ".HUF",false);
            return;
        }
        
        if(ext.contains("HE")){//Si el archivo esta dañado
            ext = nombreArchivo.substring(nombreArchivo.length()-1);//Tomo el ultimo
            if(0==JOptionPane.showConfirmDialog(null, "¿Desea Arreglar el archivo?","",JOptionPane.YES_NO_OPTION)){
                //Aca tengo que armar la extencion DHx
                ext =".DH"+ext;
                decodificarArchivo(nombreArchivo, ext,true);
                //Corregido “.DHx”
            }else{
                //Aca tengo que armar la extencion DEx
                ext =".DE"+ext;
                decodificarArchivo(nombreArchivo, ext,false);
                //No corregido “.DEx”
            }
        }
        else{
            ext = nombreArchivo.substring(nombreArchivo.length()-1);
            //inicializado en el boton  "protegerArchivo()"
            //Aca tengo que armar la extencion DHx
            ext =".DH"+ext;
            decodificarArchivo(nombreArchivo, ext,false);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboListaArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboListaArchivosActionPerformed
        jLabelArchivoElegido.setText((""+jComboListaArchivos.getSelectedItem()).substring(2)); //para sacarle el "./"
        elegirArchivo(""+jComboListaArchivos.getSelectedItem());
    }//GEN-LAST:event_jComboListaArchivosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboArchivosADecodificar;
    private javax.swing.JComboBox<String> jComboHamming;
    private javax.swing.JComboBox<String> jComboListaArchivos;
    private javax.swing.JEditorPane jEditorPaneDer;
    private javax.swing.JEditorPane jEditorPaneIzq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelArchHA;
    private javax.swing.JLabel jLabelArchHE;
    private javax.swing.JLabel jLabelArchivoElegido;
    private javax.swing.JLabel jLabelTituloDer;
    private javax.swing.JLabel jLabelTituloIzq;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDer;
    private javax.swing.JPanel jPanelIzq;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelBitRotosEditable;
    private javax.swing.JLabel labelBitsRedEditable;
    private javax.swing.JLabel labelCantBloquesEdit;
    private javax.swing.JLabel labelEditableTamOrg;
    private javax.swing.JLabel labelTamBloqueEdit;
    private javax.swing.JLabel labelTamHamEdit;
    private javax.swing.JLabel labelTamOrg;
    private javax.swing.JLabel labelTamaHam;
    private javax.swing.JPanel panelEstadisticas;
    // End of variables declaration//GEN-END:variables
    public void elegirArchivo(String urlArch){
        archivoElegido=urlArch;
        //archivoIzq=urlArch;
    }
    
    public void protegerArchivo(){  
        bloqueHamming=0;
        String ext="";
        switch(jComboHamming.getSelectedIndex()){//Seleccionado en Panel
            case 0:{
                ext=(archivoElegido.substring(archivoElegido.length()-3).equals("HUF"))?".HH1":".HA1";
                bloqueHamming=32;
                totalBitsAleer= cantBitsInfo(bloqueHamming);
                break;
            }
            case 1:{
                ext=(archivoElegido.substring(archivoElegido.length()-3).equals("HUF"))?".HH2":".HA2";
                bloqueHamming=128;
                totalBitsAleer= cantBitsInfo(bloqueHamming);
                break;
            }
            case 2:{
                ext=(archivoElegido.substring(archivoElegido.length()-3).equals("HUF"))?".HH3":".HA3";
                bloqueHamming=1024;
                totalBitsAleer= cantBitsInfo(bloqueHamming);
                break;
            }
            case 3:{
                ext=(archivoElegido.substring(archivoElegido.length()-3).equals("HUF"))?".HH5":".HA5";
                bloqueHamming=4096;
                totalBitsAleer= cantBitsInfo(bloqueHamming);
                break;
            }
            case 4:{
                ext=(archivoElegido.substring(archivoElegido.length()-3).equals("HUF"))?".HH5":".HA5";
                bloqueHamming=16384;
                totalBitsAleer= cantBitsInfo(bloqueHamming);
                break;
            }
        }
        readFileToBynari(totalBitsAleer,ext);
    }
    
    public void decodificarArchivo(String nameArchivo,String ext,boolean arreglar){ 
        //El totalBitsaleer y el bloqueHamming los tenemos globales e inicializados en la funcion de arriba "protegerArchivo()"
        //Te paso la extencion para ponerle al archivo que vas a crear
        //↓Ver javadoc↓ ahi explico los parametros
        readFileToText(nameArchivo,totalBitsAleer, bloqueHamming,ext,arreglar);
    }
    
    public int cantBitsInfo(int ham){
        int bitsRed = (int) (Math.log(ham)/ Math.log(2)); // creo que lo de floor ni hace falta
        return ham-bitsRed-1;
    }
    
    public String arrToString(byte[] b){
        String strArray="";
        for(int i=0; i< b.length;i++){
            strArray+=String.format("%8s", Integer.toBinaryString(b[i])).replace(' ', '0');
        }
        return strArray;
    }
    /**
     * Recibe el archivo representado en un arreglo de bytes y el tamaño de bits informacion por bloque
     * Retorna un string de 0s y 1s que representan el arreglo hamminizado
     * Le asigna el valor hamminizado en booleano del arreglo a la variable de instancia aGuardarHamming
     * @param bytesArchivo
     * @param cantBitsInfo
     * @return 
     */
    public String arrBytesToHammingString(byte[] bytesArchivo, int cantBitsInfo){
        String lineaDeBits="";
        int hasta = cantBitsInfo-1; //EJ: 26
        int desde = 0;
        float auxBloques = cantBitsInfo/8.f;
        aGuardarHamming = new boolean[(int)Math.ceil(bytesArchivo.length/auxBloques)][];
        int auxIndiceBloques = 0;
        
        while(hasta/8<bytesArchivo.length){
            boolean bitsInfo[] = Hamming.getIntervaloBits(bytesArchivo, desde, hasta);
            aGuardarHamming[auxIndiceBloques] = Hamming.getHamming(bitsInfo);
            desde = hasta+1;
            hasta += cantBitsInfo;
            lineaDeBits += new String(Hamming.toBytes(aGuardarHamming[auxIndiceBloques]))+'\n';  //le meto el bloque hamminizado
            auxIndiceBloques++;
        }
        if(desde/8 < bytesArchivo.length){
            boolean bitsInfo[] = Hamming.getIntervaloBits(bytesArchivo, desde, hasta);
            aGuardarHamming[auxIndiceBloques] = Hamming.getHamming(bitsInfo);
            lineaDeBits += new String(Hamming.toBytes(aGuardarHamming[auxIndiceBloques]));
        }
        return lineaDeBits;
    }
    
    public void romperArchivo(String pathAleer, int bitsBloque,String ext){
        try {
            byte[] bytes  = Files.readAllBytes(Paths.get("./"+pathAleer));
            this.tamOrig = bytes.length;
            this.tamHamm = aGuardarHamming.length/8;
            this.tamRedun = tamHamm - tamOrig;
            String sinExtencion = archivoElegido.substring(0, archivoElegido.length()-4);//Saco la extencion
            File archivo2 = new File("./"+sinExtencion+ext);//archivo roto
            boolean [] bits = Hamming.getIntervaloBits(bytes, 0, bytes.length*8-1);
            String datos = Hamming.toString(bits);
            
            Random random = new Random();
            float prob = 0.2f;//20% de prob de romper el byte i
            double romper;
            int posRomper;
            int i=0;
            this.tamRotos=0;
            while(i<bits.length){
                romper = Math.random();
                if(romper<=prob){
                    posRomper = random.nextInt(bitsBloque-1); //retorna un int entre 0 y bloque-1
                    bits[i+posRomper] = !bits[i+posRomper];
                    tamRotos++;
                }
                i+=bitsBloque;
            }
            String rotos = Hamming.toString(bits);
            OutputStream out = new FileOutputStream(archivo2);
            
            out.write(Hamming.toBytes(bits));
            out.close();
            
            jComboArchivosADecodificar.addItem(archivo2.getPath().substring(2));//Añado archivo a decodificar
            mostrarArchivos(Paths.get(archivoElegido).toString(), archivo2.getPath(), datos, rotos); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Recibe la cantidad de BITS de informacion necesaria para cada bloque Hamming.
     * @param cantBits 
     * @param extArchivo 
     */
    public void readFileToBynari(int cantBits,String extArchivo){
        String aImprimir;
        try {
            String sinExtencion = archivoElegido.substring(0, archivoElegido.length()-4);//Saco la extencion
            File archivo2 = new File(sinExtencion+extArchivo);//.HAx
            
            byte[] bytes  = Files.readAllBytes(Paths.get(archivoElegido));
            this.tamOrig = bytes.length;
            aImprimir = arrBytesToHammingString(bytes, cantBits);
            
            OutputStream out = new FileOutputStream(archivo2);
            
            for (boolean[] aGuardarHamming1 : aGuardarHamming) {
                out.write(Hamming.toBytes(aGuardarHamming1));
            }
            
            String contenido = new String(bytes);
            this.tamHamm = (aGuardarHamming.length*bloqueHamming)/8;
            this.tamRedun = tamHamm - tamOrig;
            this.tamRotos = 0;
            out.close(); 
            jComboArchivosADecodificar.addItem(archivo2.getPath().substring(2));//Añado archivo a decodificar
            mostrarArchivos(Paths.get(archivoElegido).toString(), archivo2.getPath(), contenido, aImprimir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String decodificar2(boolean[]codigo, int tamBloque,boolean arreglar){
        String auxString="";
        String aEscribir;
        String retorno="";
        int hasta = tamBloque-1;
        int desde = 0,i=0,t=0;
        byte byteAux;
        boolean []arrAux = new boolean[tamBloque];
        while(desde<codigo.length){//Si bloque <  final del String
            while(i<hasta){
                arrAux[t] = codigo[i];
                i++;
                t++;
            }
            t=0;
            desde = hasta+1;
            hasta += tamBloque;
            boolean []arr = Hamming.getInfo(arrAux,arreglar);
            auxString += Hamming.toString(arr);
        }
        while(8<auxString.length()){
            aEscribir = auxString.substring(0, 8);
            auxString = auxString.substring(8);
            try{
                byteAux = Byte.parseByte(aEscribir, 2);
            }
            catch(NumberFormatException e){
                byteAux = '\0';
            }
            if(byteAux==0){
                continue;
            }
            retorno +=(char)byteAux;
        }
        return retorno;
    }
    
    public byte[] decodificar(byte []codigo,int tamBloque,boolean arreglar, boolean huffman){ 
        String auxString="";
        String aEscribir;
        int hasta = tamBloque-1;
        int desde = 0;
        byte[] bytesAux = codigo;
        byte byteAux;
        while(hasta/8<bytesAux.length){//Si bloque <  final del String
            boolean [] arr = Hamming.getIntervaloBits(bytesAux, desde, hasta);
            desde = hasta+1;
            hasta += tamBloque;
            arr = Hamming.getInfo(arr,arreglar);
            auxString += Hamming.toString(arr);
        }
        if(desde/8<bytesAux.length){
            boolean [] arr = Hamming.getIntervaloBits(bytesAux, desde, hasta);
            arr = Hamming.getInfo(arr,arreglar);
            auxString += Hamming.toString(arr);
        }
        ArrayList<Byte> bytesDinamico = new ArrayList<>();
        byte aux;
        while(8<auxString.length()){
            aEscribir = auxString.substring(0, 8);
            auxString = auxString.substring(8);
            aux = (byte) Integer.parseInt(aEscribir, 2);
            if(aux != 0 || huffman){
                bytesDinamico.add(aux);
            }
        }
        return Nodo.getArregloDeBytes(bytesDinamico);
    }
    
    /**
     * 
     * @param pathAleer nombre del archivo a Decodificar
     * @param bitsAleer Bits de Informacion
     * @param bitsBloque Bits Info + Bits control
     * @param ext la extencion que le tenes que poner al archivo creado
     */
    public void readFileToText(String pathAleer,int bitsAleer, int bitsBloque,String ext,boolean arreglar){ 
        try {
            byte[] bytes  = Files.readAllBytes(Paths.get("./"+pathAleer));
            this.tamHamm = bytes.length;
            //boolean [] bitsArchivo = Hamming.getIntervaloBits(bytes, 0, bytes.length*8-1);
            String textoIzq = Hamming.toString(Hamming.getIntervaloBits(bytes, 0, bytes.length*8-1));
            String sinExtencion = pathAleer.substring(0, pathAleer.length()-4);   //Saco la extencion
            
            File archivo2 = new File("./"+sinExtencion+ext);//.H
            OutputStream bw = new FileOutputStream(archivo2);
            
            byte[]aEscribir=decodificar(bytes, bitsBloque,arreglar, ext.equals("HUF"));
            
            String textoDer = new String(aEscribir);
            this.tamOrig = aEscribir.length;
            bw.write(aEscribir);
            bw.close();
            mostrarArchivos("./"+pathAleer, archivo2.getPath(),textoIzq,textoDer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void settearLabels(String path){ 
        String ext=path.substring(path.length()-4,path.length()-1);
        switch(ext){
            case".HA":{
                jLabelArchHA.setText(path.substring(2)); 
                break;
            }
            case".HE":{ 
                jLabelArchHE.setText(path.substring(2));
                break;
            }
        }
    }
    /**
     * Recibe dos archivos y los imprime, no hay mucha vuelta.
     * @param textoIzq    * @param izq
     * @param der 
     * @param textoDer 
     */
    public void mostrarArchivos(String izq,String der, String textoIzq, String textoDer){  
        archivoIzq=izq; 
        archivoDer=der;//de la forma "./nombre.ext"
        settearLabels(archivoIzq);
        settearLabels(archivoDer);
        jLabelTituloIzq.setText(archivoIzq.substring(2,archivoIzq.length()));
        jLabelTituloDer.setText(archivoDer.substring(2,archivoDer.length()));
        this.jEditorPaneDer.setText(textoDer);
        this.jEditorPaneIzq.setText(textoIzq);
        this.labelBitsRedEditable.setText(""+this.tamRedun);
        this.labelTamHamEdit.setText(""+this.tamHamm);
        this.labelEditableTamOrg.setText(""+this.tamOrig);
        this.labelBitRotosEditable.setText(""+this.tamRotos);
        this.labelTamBloqueEdit.setText(""+this.bloqueHamming);
        this.labelCantBloquesEdit.setText(""+(this.aGuardarHamming.length/bloqueHamming));
    }
}
