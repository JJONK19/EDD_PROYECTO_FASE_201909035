/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.udrawing_paper;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author JJONK19
 */
public class ListaDCircularL{
    int no; //Maneja el número de nosdos que posee la lista
    NodoListaDobleCircular head; //Cabecera de la cola
    
    public ListaDCircularL(){
        this.head = null;
        this.no = 0;
    }
    
    //Metodos de la lista
    //--------------------------------------------------------------------------
    public void add(Object _structure, String _name, Object _content){
        NodoListaDobleCircular t = new NodoListaDobleCircular (_structure, _name, _content);
        if(isEmpty()){
            head = t;
            head.next= head;
            head.prev = head; 
            no+=1;
        }else{
            NodoListaDobleCircular r = head;
            for(int i = 1; i < this.no; i++){
                r = r.next;
            }
            r.next = t;
            t.prev = r;
            t.next = head;
            head.prev = t;
            no+=1;
        }
    }
    
    public void show(){
        NodoListaDobleCircular r = head;
        for(int i = 0; i < this.no; i++){
            System.out.println(r.name);
            r = r.next;
        }
    }
    
    //Vacia la lista
    public void deleteL(){
        this.head = null;
        this.no = 0;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
    
    //Metodos de Graficación
    //--------------------------------------------------------------------------
    
    //Sirve para crear la declaracion de los nodos que van a ir en el archivo del grafico.
    //Tanto de la lista doble como la lista que contiene.
    
    public String declare(){
        String x = "";
        NodoListaDobleCircular temp = this.head;
        for(int i = 0; i < this.no; i++){
           x += temp.ID + "[shape = box label="+ temp.name + "]\n";
           
           ListaSimple t = (ListaSimple)temp.structure;
           x += t.head.declare();
           temp = temp.next;
        }
        return x;
    }
    
    //Crea las conexiones entre los nodos que van a ir en el archivo del grafo
    public String connect(){
        String x = "";
        NodoListaDobleCircular temp = this.head;
        for(int i = 0; i < this.no; i++){
           x += temp.ID + "->" + temp.next.ID + ";\n";
           x += temp.ID + "->" + temp.prev.ID + ";\n";
           
           ListaSimple t = (ListaSimple)temp.structure;
           String o = temp.ID.replace("\"", "");
           x += "subgraph cluster_" + o.replace("-", "") + "{" + t.head.connect() + "}";
           x += temp.ID + "->" + t.head.ID + "[minlen=3]";
           temp = temp.next;
        }
        return x;
    }
    
    //Unifica el texto que va en el grafo
    public String getcodigo(){
        String t = "digraph G\n" +"{\n" + "rankdir=LR";
        if (head !=null){
            t += "\t" + declare()+ connect();
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
