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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author root
 */
public class Nodo implements Comparable<Nodo>{
    private float cant;   //Suma de 
    private Nodo padre;
    private Nodo h1;
    private Nodo h0;
    private char c;
    private String codigo;
    static HashMap<Character,String> diccionario = new HashMap<>();
    /**
     * No le falta el padre tmb?
     * @param c
     * @param cant 
     */
    public Nodo(char c,float cant){
        this.c=c;
        this.cant=cant;
        h1=null;
        h0=null;
    }

    public float getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void setPadre(Nodo p){
        this.padre=p;
    }
    
    public Nodo getPadre(){
        return padre;
    }
    
    public Nodo getH1() {
        return h1;
    }

    public void setH1(Nodo h1) {
        this.h1 = h1;
    }

    public Nodo getH0() {
        return h0;
    }

    public void setH0(Nodo h0) {
        this.h0 = h0;
    }

    public char getChar() {
        return c;
    }

    public void setChar(char c) {
        this.c = c;
    }   
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }

    @Override
    public String toString() {
        return "Nodo{" + "cant=" + cant + ", c=" + c + ", codigo=" + codigo + '}';
    }
       
    public static void crearListaDeFrecuencia(File archivo){
        HashMap<Character,Float> frecuencias = new HashMap<>();
        frecuencias.put('\0',(float)1); //Le ponemos el caracter que indica fin de archivo
        FileReader fr = null;
        BufferedReader br = null;
        int i = 0; // indice que va a tomar la cantidad de bits de info necesaria por iteracion
        Float contChars;
        try {
            archivo = new File("./archivo.txt");                                   // Apertura del fichero
            fr = new FileReader(archivo);                                       // creacion de BufferedReader para poder hacer el metodo readLine()).
            br = new BufferedReader(fr);                                        // Lectura del fichero
            String linea;
            String textoOriginal="";
            boolean primero =true;
            while ((linea = br.readLine()) != null) { 
                if(primero){
                    primero = false;
                    textoOriginal += linea;
                }else{
                    linea ='\n'+linea;
                    textoOriginal += linea;
                }for(i=0;i<linea.length();i++){
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
            i=0;
            for(i=0; i<frecsNodos.size();i++){
                System.out.println("n.toString() = " + frecsNodos.get(i).toString());
            }
            Nodo raiz = getArbol(frecsNodos);
            System.out.println("raiz = " + raiz);
            raiz.setCodigo("");
            raiz.codificar(raiz); 
            escribirHuffman(textoOriginal,raiz.imprimirArbol(raiz,""));
        } catch (Exception e) {
            e.printStackTrace();
        } finally { // En el finally cerramos el fichero, para asegurarnos que se cierra tanto si todo va bien como si salta excepcion
            try {
                if (null != fr){ fr.close();}
            } catch (Exception e2) {e2.printStackTrace();}
        }
    } 
    
    public static void escribirHuffman(String texto, String tabla) throws IOException {
        // byte b = Byte.parseByte("01100110", 2); 
        // System.out.println(Byte.parseByte("01100110", 2));
        // System.out.println(tabla.getBytes().length);
        File tablaHuffman = new File("./tablaHuff.txt");
        OutputStream out = new FileOutputStream(tablaHuffman);
        byte[] buf = tabla.getBytes();
        out.write(buf,0,buf.length); 
        out.close();//A la tabla de la escribo como está. 
        File archivo = new File("./huffman.txt");//.H
        out = new FileOutputStream(archivo);
        ArrayList<Byte> bytesDinamico = new ArrayList<>(); 
        int i; 
        String biteDe8 = ""; //String que contiene los bits del byte que será convertido en byte eventualmente
        int libre = 8; //Los bits Disponibles del byte
        for (i = 0; i < texto.length(); i++) {
            int bitsCodigo = diccionario.get(texto.charAt(i)).length();
         //   System.out.println("biteDe8 = " + biteDe8 + " bitsCodigo " + bitsCodigo + " char " + texto.charAt(i));
            if (libre >= bitsCodigo) { //inicialmente tengo 8 bits libres
                libre = libre - bitsCodigo; // 8 - longitud del codigoHuffman
                biteDe8 += diccionario.get(texto.charAt(i));  //append del codigo al byte
            } else { //Lleno el byte pero me sobran bits del codigo
                biteDe8 += diccionario.get(texto.charAt(i)).substring(0, libre); // corto el codigo para tener 8 bits justo
                byte b = (byte) Integer.parseInt(biteDe8, 2);
                bytesDinamico.add(b);//Agrego al arreglo de bytes a imprimir
                biteDe8 = diccionario.get(texto.charAt(i)).substring(libre); //Le pongo lo que me sobro al siguiente byte 
                libre = 8 - (bitsCodigo - libre);    //Steteo el numero de bits libres del byte a crear
            }
            if (libre == 0) { //Si biteDe8.length() == 8 entonces agrego un byte al arreglo y libre = 8 
                byte b = (byte) Integer.parseInt(biteDe8, 2);
                bytesDinamico.add(b);//Agregarlo al arreglo de bytes a imprimir
                libre = 8;
                biteDe8 = "";
            }//Si es distinto de 0 es por q todavia no completo el byte o por que lo complete y lo agregue y de nuevo el segndo no esta completo
        }
        if (!biteDe8.equals("")) { //Si me sobraron bits del codigo
            //Tengo que agregar un ultimo byte rellenarlo y meterle el caracter nulo de fin de archivo. 
            biteDe8 += diccionario.get('\0');//le agrego el null al final
            if(biteDe8.length()<=8){//me quedo de 8 bits o menos asi q lo parseo
                byte b = (byte) Integer.parseInt(biteDe8, 2);
            }
            else{
                String aux = biteDe8.substring(0, 8); //Aux tiene un byte en string
                biteDe8 = biteDe8.substring(8); //Bite tiene lo q le sobro de agregar el null
                byte b = (byte) Integer.parseInt(aux, 2);
                bytesDinamico.add(b);
                b = (byte) Integer.parseInt(biteDe8, 2);
                bytesDinamico.add(b);
            }
        }
        buf = getArregloDeBytes(bytesDinamico);
        out.write(buf);
        out.close(); 
    } 
    

        /*   try{
            if(archivo2.exists()){
                bw = new BufferedWriter(new FileWriter(archivo2));
            }else{
                archivo2.createNewFile();
                bw = new BufferedWriter(new FileWriter(archivo2));
            }
            int i=0;
            bw.write(tabla);
            for(i=0;i<texto.length();i++){
                if(diccionario.containsKey(texto.charAt(i)))
                    bw.write(diccionario.get(texto.charAt(i)));
                else
                    bw.write(texto.charAt(i));
            }
            bw.close();
        }catch(Exception e) {
            e.printStackTrace(); 
        }finally{
            if (bw!=null)
                bw.close();
        }*/
    
    public static byte[] getArregloDeBytes(ArrayList<Byte> arrBytes){
        byte[] arregloPrimitivo = new byte[arrBytes.size()];
        int i;
        for(i =0;i<arrBytes.size();i++){
            arregloPrimitivo[i]=arrBytes.get(i);
        }
        return arregloPrimitivo;
    }
    
    public byte[] toBytes(boolean[] arregloBits) {
        byte[] aux = new byte[arregloBits.length / 8];
        for(int i = 0; i < aux.length; i++) {
            for(int t = 0; t < 8; t++) {
                if(arregloBits[i * 8 + t]) {
                    aux[i] |= (128 >> t);
                }
            }
        }
        return aux;
    } 
    /**
     * Instancia el padre de los dos nodos que recibe por parametro.
     * El hijo con la menor cantidad es el izquierdo y el otro el derecho.
     * @param a
     * @param b
     * @return 
     */
    public static Nodo getPadre(Nodo a, Nodo b){
        Nodo padre = new Nodo('\0',a.getCant()+b.getCant());
        if(b.getCant() <= a.getCant()){
            padre.setH0(a);
            padre.setH1(b);
        }
        else{
            padre.setH0(b);
            padre.setH1(a);
        }
        a.setPadre(padre);
        b.setPadre(padre);
        return padre;
    }
    /**
     * Recibe una lista de nodos ordenados por frecuencia. 
     * Hace 2 pops por iteración eliminando los ultimos dos elementos
     * Y agrega el padre, ordenando la lista nuevamente, al finalizar retorna la Raiz del arbol.
     * @param lista
     * @return 
     */
    public static Nodo getArbol(ArrayList <Nodo> lista){
        Nodo padre,auxh1,auxh0;
        while(lista.size()>1){
            auxh1 = lista.remove(0);
            auxh0 = lista.remove(0);
            padre = getPadre(auxh0,auxh1);
            lista.add(padre);
            Collections.sort(lista);
        }
        return lista.get(0);
    }

    public String imprimirArbol(Nodo raiz,String tabla){
        if(raiz !=null){
            if(raiz.getH0()==null && raiz.getH1()==null){   //si no tiene hijos 
                diccionario.put(raiz.getChar(),raiz.getCodigo()); // Arma el diccionario
                tabla+=raiz.getChar()+raiz.getCodigo()+'\n';//Esto creo que deberiamos transformarlo a bits pero primero lo primero  
            }
            tabla = imprimirArbol(raiz.getH0(),tabla);
            tabla = imprimirArbol(raiz.getH1(),tabla);        
        }
        return tabla;
    }
    /*
    public void getDiccionario(String tabla){
        String strBits = tabla;//arrToString(tabla.getBytes());
        HashMap<String,String> diccionario = new HashMap<>();
        int i = 0 ;
        for(i=0;i<contador;i++){
            System.out.println("strBits = " + strBits);
            String cha = strBits.substring(0,1);  
            String cod = strBits.substring(1,strBits.indexOf('\n')); 
            strBits = strBits.substring(strBits.indexOf('\n')+1);
            System.out.println("strBits1 = " + strBits);
            diccionario.put(cha, cod);
        }
    } 
    */
    
    
    public void leerCodificacion(String tabla){ 
        String strBits = arrToString(tabla.getBytes());//String de bits
    }
    
    public String arrToString(byte[] b){
        int i=0;
        String strArray="";
        for(i=0; i< b.length;i++){
            strArray+=String.format("%8s", Integer.toBinaryString(b[i])).replace(' ', '0');
        }
        return strArray;
    }
    
    /**
     * Recibe la raiz del arbol, el punto de parada es que sea null
     * Si el padre es distinto de null toma el codigo del padre y agrega un 0 o un 1 si el hijo es el izquierdo o el derecho respectivamente.
     * @param raiz 
     */
    private void codificar (Nodo raiz){
        if (raiz != null){
            Nodo aux;
            if((aux = raiz.getPadre())!=null){
                if(aux.getH0()==raiz){
                    raiz.setCodigo(aux.getCodigo()+'0');
                }
                else{
                    raiz.setCodigo(aux.getCodigo()+'1');
                }
            }
            codificar (raiz.getH0());
            codificar (raiz.getH1());
        }
    }
    
    @Override
    public int compareTo(Nodo o) {
        int aux = (int) (1000* this.getCant()) - (int) (1000* o.getCant());
        if (aux ==0){
            if(this.getChar()>= o.getChar()){
                aux = -1;
            }else{
                aux = 1;
            }                
        }
        return aux;
    }
    
    /**
     * tRADUCE LA TABLA Y TE LA PONE EN EL "DICCIONARIO" QUE ES UN HASHMAP GLOBAL 
     * @param pathAleer
     * @param ext 
     */
    public static void leerHuffman(String pathAleer,String ext){
        try{
            HashMap<String,Character> diccio = new HashMap<>();//Instancio el diccionario
            File tablaHuffman = new File("./"+pathAleer);// Instancio el Archivo que voy a leer
          //  File disViejoCopy = new File("./prueba.HUF"); // Copio en el mismo lugar con otro nombre
            //empieza copiacion
            InputStream in = new FileInputStream(tablaHuffman);
       //     OutputStream out = new FileOutputStream(disViejoCopy);
            byte[] buf = new byte[1024];
            int len; 
            //Leo cantidad de palabras de mi diccionario.
            // len = in.read(); 
            //int cantidadPalabras = (int) in.read() - 48;
            //System.out.println("len"+cantidadPalabras);
            int i=0;
            String codigo="";
            char a; 
            int primerByteLeido;
            while((primerByteLeido = in.read())>= 0){
                a = (char) primerByteLeido;
                System.out.println("a = " + a);
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
                System.out.println(diccio.get(codigo)+"  --  "+ codigo);
            } 
            in.close();
            exportarDescomprimido(pathAleer, ext,diccio);
        /*    
            for(i=0;i<cantidadPalabras;i++){
                codigo = "";
                char a = (char) in.read();
                char control;
                while((control = (char) in.read()) != '\n'){
                    codigo +=control;
                }
                diccionario.put(a,codigo);
                System.out.println(diccionario.get(a)+" "+ a);
            } 
            
            //byte[] array = Files.readAllBytes(Paths.get("./"+pathAleer));
             
           while ((len = in.read()) > 0) {
                
                out.write(buf, 0, len);
            }*/
            
           // out.close();//en teoria ya termino la copiacion  
        }catch(IOException e){
            
        }
    }
    
    
    
    public static void exportarDescomprimido(String pathAleer,String ext,HashMap<String,Character> invertido) throws IOException{ 
        //Aca falta toda la parte de escribir strings en archivo q no me acuerdo y me dio paja 
        byte[] bytes  = Files.readAllBytes(Paths.get("./huffman.txt"));//Devuelve un arreglo de bytes del archivo, si hay bytes "negativos" los fuerza 
        String aux = "";
        String aEscribirEnArchivo = "";
        bucle:
        for(byte b : bytes){ 
            for(int i=0; i<8; i++){
                aux += getBitDeByte(b,i) ? "1" : "0";
                if(invertido.containsKey(aux)){
                    System.out.println("aux = " + aux);
                    char c = invertido.get(aux);
                    if(c=='\0'){
                        break bucle;
                    }
                    aEscribirEnArchivo = aEscribirEnArchivo + c;
                    aux = "";
                }
            }
        }
        escribirArchivo(aEscribirEnArchivo,"./descomprimido.txt"); 
    }
    public static void escribirArchivo(String texto,String path){ 
        System.out.println("  \n Soy texto \n" + texto);
        File archivo = null;
        FileReader fr = null; 
        try {
            archivo = new File("./"+path);        
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
    
    
    
    
    
    
    
    
    
    
    
    
    public static boolean getBitDeByte(byte b, int pos){
        return (1 & (b >> pos))==1; //Esta poronga retorna el booleano de la posicion del byte b (11110111) si le mandas 3 devuelve falso, xq retorna el 0 de la posicion 3 (de atras para adelante)
    }
    
    
}
