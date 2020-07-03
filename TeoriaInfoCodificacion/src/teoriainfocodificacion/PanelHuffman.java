/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoriainfocodificacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static teoriainfocodificacion.Nodo.escribirHuffman;
import static teoriainfocodificacion.Nodo.exportarDescomprimido;
import static teoriainfocodificacion.Nodo.getArbol;

/**
 *
 * @author root
 */
public class PanelHuffman extends javax.swing.JPanel {

    /**
     * Creates new form PanelHuffman
     */
    public PanelHuffman() {
        initComponents();
        llenarListaArchivos();
    }
    public void llenarListaArchivos(){
        jComboListaArchivos.removeAllItems();
        String[] archivosPermitidos = {".txt",".doc",".HUF",".wp",".DH",".DE"};
        File directorio = new File("./"); 
        File[] archivos=null;
        if(directorio.exists()){
            archivos = directorio.listFiles();
        }
        int i;
        boolean permitido=false;
        for(i=0;i<archivos.length;i++){
            int j;
            for(j=0;j<archivosPermitidos.length;j++){ 
                if((""+archivos[i]).contains(archivosPermitidos[j])){ 
                    permitido=true;
                    jComboListaArchivos.addItem(""+archivos[i]); 
                    break;
                }
            } 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jButtonDescomprimir = new javax.swing.JButton();
        jButtonComprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelArchivoElegido = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelTamBytesOriginal = new javax.swing.JLabel();
        jLabelArchCreado = new javax.swing.JLabel();
        jLabelTamBytesRed = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelTamBytesCompr = new javax.swing.JLabel();
        jLabelTablaCreada = new javax.swing.JLabel();
        jComboListaArchivos = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabelTamBytesTabla = new javax.swing.JLabel();
        jPanelIzq = new javax.swing.JPanel();
        jLabelTituloIzq = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPaneIzq = new javax.swing.JEditorPane();
        jPanelDer = new javax.swing.JPanel();
        jLabelTituloDer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPaneDer = new javax.swing.JEditorPane();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Comprimir archivos - Huffman", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setText("Elegir archivo a comprimir");

        jButtonDescomprimir.setText("Descomprimir Archivo");
        jButtonDescomprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDescomprimirActionPerformed(evt);
            }
        });

        jButtonComprimir.setText("Comprimir Archivo");
        jButtonComprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComprimirActionPerformed(evt);
            }
        });

        jLabel3.setText("El archivo elegido es :");

        jLabelArchivoElegido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelArchivoElegido.setText("Ejemplo.ext");

        jLabel5.setText("Tamaño original: ");

        jLabel6.setText("Tam. arch comprimido: ");

        jLabel7.setText("Tamaño reducido: ");

        jLabelTamBytesOriginal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTamBytesOriginal.setText("tantos bits");

        jLabelArchCreado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelArchCreado.setText("comprimido.ext");

        jLabelTamBytesRed.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTamBytesRed.setText("tantos bits");

        jLabel11.setText("Archivo Creado ");

        jLabel12.setText("Tabla(diccionario) Creada");

        jLabelTamBytesCompr.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTamBytesCompr.setText("tantos bits");

        jLabelTablaCreada.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTablaCreada.setText("tabla.ext");

        jComboListaArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboListaArchivosActionPerformed(evt);
            }
        });

        jLabel8.setText("Tam. arch tabla: ");

        jLabelTamBytesTabla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTamBytesTabla.setText("tantos bits");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelArchivoElegido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboListaArchivos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTablaCreada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(55, 55, 55)
                        .addComponent(jLabelArchCreado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTamBytesRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTamBytesOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonComprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonDescomprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addGap(0, 72, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(50, 50, 50)
                                .addComponent(jLabelTamBytesTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabelTamBytesCompr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboListaArchivos, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelArchivoElegido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonComprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButtonDescomprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelArchCreado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTablaCreada, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTamBytesOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTamBytesRed, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTamBytesCompr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTamBytesTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jPanelIzq.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 44, 348, 550));

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

        jPanelDer.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 42, 350, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDer, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelDer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelIzq, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDescomprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDescomprimirActionPerformed
        leerHuffman(jLabelArchivoElegido.getText(), "");
        llenarListaArchivos();
    }//GEN-LAST:event_jButtonDescomprimirActionPerformed

    private void jButtonComprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComprimirActionPerformed
        crearListaDefrecuencias(jLabelArchivoElegido.getText());
        llenarListaArchivos();
    }//GEN-LAST:event_jButtonComprimirActionPerformed

    private void jComboListaArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboListaArchivosActionPerformed
        jLabelArchivoElegido.setText(""+jComboListaArchivos.getSelectedItem());
        if(jLabelArchivoElegido.getText().contains(".DE") || jLabelArchivoElegido.getText().contains(".DH")||jLabelArchivoElegido.getText().contains(".HUF") ){
            jButtonDescomprimir.setEnabled(!jLabelArchivoElegido.getText().contains(".DHU"));//Esto tiene sentido  
            jButtonComprimir.setEnabled(!jLabelArchivoElegido.getText().contains(".HUF"));
        }else{
            jButtonComprimir.setEnabled(true);  
            jButtonDescomprimir.setEnabled(false);            
        } 
    }//GEN-LAST:event_jComboListaArchivosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonComprimir;
    private javax.swing.JButton jButtonDescomprimir;
    private javax.swing.JComboBox<String> jComboListaArchivos;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JEditorPane jEditorPaneDer;
    private javax.swing.JEditorPane jEditorPaneIzq;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelArchCreado;
    private javax.swing.JLabel jLabelArchivoElegido;
    private javax.swing.JLabel jLabelTablaCreada;
    private javax.swing.JLabel jLabelTamBytesCompr;
    private javax.swing.JLabel jLabelTamBytesOriginal;
    private javax.swing.JLabel jLabelTamBytesRed;
    private javax.swing.JLabel jLabelTamBytesTabla;
    private javax.swing.JLabel jLabelTituloDer;
    private javax.swing.JLabel jLabelTituloIzq;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDer;
    private javax.swing.JPanel jPanelIzq;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public void crearListaDefrecuencias(String archivoSeleccionado){
        File aComprimir = new File(archivoSeleccionado);
        HashMap<Character,Float> frecuencias = new HashMap<>();
        frecuencias.put('\0',(float)1); //Le ponemos el caracter que indica fin de archivo
        FileReader fr = null;
        BufferedReader br = null;
        Float contChars;
        try {                               // Apertura del fichero
            fr = new FileReader(aComprimir);                                       // creacion de BufferedReader para poder hacer el metodo readLine()).
            br = new BufferedReader(fr);                                        // Lectura del fichero
            String linea;
            String textoOriginal="";
            boolean primero = true;
            while ((linea = br.readLine()) != null) { 
                if(primero){
                    primero = false;
                    textoOriginal += linea;
                }else{
                    linea ='\n'+linea;
                    textoOriginal += linea;
                }
                for(int i=0;i<linea.length();i++){
                    if((contChars = frecuencias.get(linea.charAt(i)))!=null)
                        frecuencias.put(linea.charAt(i),contChars+1);
                    else 
                        frecuencias.put(linea.charAt(i),(float)1);
                }
            }
            int totalCaracteres = frecuencias.size();
            Set<Character> claves = (Set<Character>) frecuencias.keySet();
            ArrayList<Nodo> frecsNodos = new ArrayList<>();
            for(Character c: claves){
                frecuencias.replace(c, frecuencias.get(c)/totalCaracteres); // Transformo cantidades en frecuencias.
                frecsNodos.add(new Nodo(c,frecuencias.get(c)));//Voy creando los nodos para dejarlos ordenados en la linea de abajo 
            }
            Collections.sort(frecsNodos);//Ordeno de menor a mayor
            Nodo raiz = getArbol(frecsNodos);
            raiz.setCodigo("");
            raiz.codificar(raiz); 
            String sinExtencion=archivoSeleccionado.substring(0,archivoSeleccionado.length()-4);
            Object[] datos = escribirHuffman(sinExtencion,textoOriginal,raiz.imprimirArbol(raiz,""));
            byte[] bytesDeTablaHuffman = (byte[])datos[0];
            byte[] bytesDeHuffman = (byte[])datos[1];
            mostrarArchivosVentanas(textoOriginal,bytesDeHuffman,sinExtencion,bytesDeTablaHuffman);
        } catch (Exception e) {
            e.printStackTrace();
        } finally { // En el finally cerramos el fichero, para asegurarnos que se cierra tanto si todo va bien como si salta excepcion
            try {
                if (null != fr){ fr.close();}
            } catch (Exception e2) {e2.printStackTrace();}
        }
    }
    public void mostrarArchivosVentanas(String izquierdo,byte[] derecho,String sinExtencion,byte[] tabla){
        jEditorPaneIzq.setText(izquierdo);
        try {jEditorPaneDer.setText(new String(derecho, "UTF-8"));
        } catch (UnsupportedEncodingException ex) { Logger.getLogger(PanelHuffman.class.getName()).log(Level.SEVERE, null, ex);}
        jLabelTamBytesOriginal.setText(izquierdo.getBytes().length + " bytes");
        jLabelTamBytesCompr.setText(derecho.length + " bytes");
        jLabelTamBytesRed.setText((izquierdo.getBytes().length-derecho.length) + " bytes");
        jLabelArchCreado.setText(sinExtencion+".HUF");
        jLabelTablaCreada.setText(sinExtencion+".TUF");
        jLabelTamBytesTabla.setText(tabla.length + " bytes");
    }    
    /**
     * Recibe la ruta de un archivo comprimido
     * Recibe la extension del archivo
     * Lee un arhivo donde se encuentra la tabla de codificacion de huffman
     * Instancia un mapa de la forma caracter,codificacion
     * @param pathAleer
     * @param ext 
     */
    public void leerHuffman(String pathAleer,String ext){
        try{
            HashMap<String,Character> diccio = new HashMap<>();//Instancio el diccionario
            String sinExtencion=pathAleer.substring(0,pathAleer.length()-4);
            File tablaHuffman = new File(sinExtencion+".TUF");// Instancio el Archivo que voy a leer
            InputStream in = new FileInputStream(tablaHuffman);
            String codigo="";
            char a; 
            int primerByteLeido;
            while((primerByteLeido = in.read())>= 0){
                a = (char) primerByteLeido;
                codigo = "";
                char control;
                int byteLeido;
                while((byteLeido = in.read())>=0){
                    if ((control = (char) byteLeido) != '\n'){ 
                        codigo +=control; 
                    }else{
                        break;
                    }
                }  
                diccio.put(codigo,a);
            } 
            in.close();
            Object[] datos = exportarDescomprimido(pathAleer, ext,diccio);//retorna el texto descomprimido 
            String textoDescomprimido = ""+datos[0];
            byte[] archivoComprimido = (byte[])datos[1];
            escribirArchivo(textoDescomprimido, sinExtencion+".DUF"); //Descomprimido huf
            mostrarArchivosVentanas2(textoDescomprimido,archivoComprimido,sinExtencion);
        }catch(IOException e){
            
        }
    }
 
    public void mostrarArchivosVentanas2(String der,byte[] izquierdo,String sinExtencion){
        File archivoElegido;
        jEditorPaneDer.setText(der);
        try {jEditorPaneIzq.setText(new String(izquierdo, "UTF-8"));
        } catch (UnsupportedEncodingException ex) { Logger.getLogger(PanelHuffman.class.getName()).log(Level.SEVERE, null, ex);}
        jLabelTamBytesOriginal.setText(izquierdo.length + " bytes");
        jLabelTamBytesCompr.setText(der.getBytes().length + " bytes");
        jLabelTamBytesRed.setText((izquierdo.length-der.getBytes().length) + " bytes");
        jLabelArchCreado.setText(sinExtencion+".DUF");
        jLabelTablaCreada.setText("-");
        jLabelTamBytesTabla.setText("-");
    }
    /**
     * Recibe un texto con la informacion que se va guardar en el archivo
     * Recibe una ruta donde se va a crear/guardar el archivo
     * Crea el archivo en caso de que no exista con la informacion de texto
     * @param texto
     * @param path 
     */
    public static void escribirArchivo(String texto,String path){
        File archivo = null;
        FileReader fr = null; 
        try {
            archivo = new File(path);        
            BufferedWriter bw;
            if(archivo.exists()){
                bw = new BufferedWriter(new FileWriter(archivo));
            }
            else{
                archivo.createNewFile();
                bw = new BufferedWriter(new FileWriter(archivo));
            }  
            bw.write(texto); 
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally { 
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } 
    }
}
