/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author JJONK19
 */
public class ListaSimple {
    NodoListaSimple head; //Cabecera de la cola
    int no; //Nodos de la lista
    
    public ListaSimple(){
        this.head = null;
        this.no = 0;
    }
    
    //Metodos de la lista
    //--------------------------------------------------------------------------
    public void add(Object _content, String _name){
        NodoListaSimple temp = new NodoListaSimple (_content, _name);
        if(isEmpty()){
            head = temp;
            no++;
        }else{
            NodoListaSimple r = head;
            while(r.next != null){
                r = r.next;
            }
            r.next = temp;
            no++;
        }
    }
    
    
    //Vacia la lista
    public void deleteL(){
        this.head = null;
        no = 0;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
    
    //Las posiciones empiezan desde 0. Restarle uni al idice para no tener errores.
    public void remove(int pos){
        NodoListaSimple aux = this.head;
        for(int i = 0; i < pos; i++){
            aux = aux.next;
        }
        
        if (this.no ==1 && aux ==this.head){
            this.head = null;
            this.no = 0;
        } else{
            if (aux == this.head){
            NodoListaSimple rnext = aux.next;
            this.head = rnext;
            this.no--;
            }else{
                NodoListaSimple rprev = this.head;
                NodoListaSimple rnext = aux.next;
                for(int i = 0; i < pos-1; i++){
                    rprev = rprev.next;
                }
                rprev.next = rnext;
                aux = null;
                this.no--;
            }
        }
    }
    //Metodos de Graficación
    //--------------------------------------------------------------------------
    
    //Unifica el texto que va en el grafo
    public String getcodigo(){
        String t = "digraph G\n" +"{\n";
        if (head !=null){
            t += "\t" + head.declare()+ head.connect();
        }
        t += "}";
        return t;
    }
    
    //Crea y escribe el archivo que lleva el codifo del grafo generado
    public void escribir(String ruta, String contenido){
        FileWriter fichero = null;
        PrintWriter p = null;
        
        try{
            fichero  = new FileWriter(ruta);
            p = new PrintWriter(fichero);
            p.write(contenido);
            p.close();
            fichero.close();
        
        }catch(Exception e){
            System.out.print(e.getMessage());
            
        }finally{
            if (p!= null){
                p.close();
            }
        }
        
    }
    
    //Se encarga de dibujar el grafo. Ruta es el nombre del archivo *.txt y gname es el nombre
    //del grafo en formato *.png
    
    public void dibujar(String ruta, String gname){
        try{
            escribir(ruta, getcodigo());
            ProcessBuilder a;
            a = new ProcessBuilder("dot", "-Tpng", "-o", gname, ruta);
            a.redirectErrorStream(true);
            a.start();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
}
