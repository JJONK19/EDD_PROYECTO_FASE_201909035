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
public class Pila {
    NodoPila head; //Cabecera de la cola
    
    public Pila(){
        this.head = null;
    }
    
    //Metodos de la cola 
    //--------------------------------------------------------------------------
    public void push(Object _content, String _name){
        NodoPila temp = new NodoPila (_content, _name);
        if(isEmpty()){
            head = temp;
        }else{
            temp.next = head;
            head = temp;
        }
    }
    
    public Object pop(){
        Object contenido = head.content;
        NodoPila temp = head.next;
        head = temp;
        return contenido;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
    
    
    //Vacia la lista
    public void deleteP(){
        this.head = null;
    }
    
    //Metodos de Graficación
    //--------------------------------------------------------------------------
    
    //Unifica el texto que va en el grafo
    public String getcodigo(){
        String t = "digraph structs\n" +"{\n" + "\t node [shape=record]; \n \t rankdir=LR;";
        if (head !=null){
            t += "\t"+ "struct1 [label=\"" + head.declare() + "\"];";
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
