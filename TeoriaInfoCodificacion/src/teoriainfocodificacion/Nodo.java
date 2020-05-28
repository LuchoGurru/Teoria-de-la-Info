/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoriainfocodificacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    static int contador = 0;// por ahora no lo uso pero probablemente lo necesite para saber cuantas lineas de TABLA tengo al leer un archivo
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
                    textoOriginal += '\n'+linea;
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
            System.out.println(raiz.imprimirArbol(raiz, ""));
           // raiz.getDiccionario(raiz.imprimirArbol(raiz, ""));
           contador = 0; //Nota siempre reiniciar el contador antes de imprimir
           escribirHuffman(textoOriginal,raiz.imprimirArbol(raiz,""));
        } catch (Exception e) {
            e.printStackTrace();
        } finally { // En el finally cerramos el fichero, para asegurarnos que se cierra tanto si todo va bien como si salta excepcion
            try {
                if (null != fr){ fr.close();}
            } catch (Exception e2) {e2.printStackTrace();}
        }
    } 
    
    public static void escribirHuffman(String texto,String tabla) throws IOException{
            File archivo2 = new File("./huffman.txt");//.H
            BufferedWriter bw=null;
        try{
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
        }
             
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
                contador++;
            }
            tabla = imprimirArbol(raiz.getH0(),tabla);
            tabla = imprimirArbol(raiz.getH1(),tabla);        
        }
        return tabla;
    }
    
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
    
}
