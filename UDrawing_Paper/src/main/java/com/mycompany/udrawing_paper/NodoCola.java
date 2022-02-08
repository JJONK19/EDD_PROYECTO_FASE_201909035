/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.udrawing_paper;

import java.util.UUID;

/**
 *
 * @author JJONK19
 */
public class NodoCola {
    String ID;          //ID del nodo. Tiene uso en el gráfico.
    Object content;     //Contenido del Nodo
    NodoCola next;      //Apuntador al siguiente nodo de la lista
    String name;        //Nombre que va a aparecer en el grafo
    
    public NodoCola(Object _content, String _name){
        this.ID = "\""+UUID.randomUUID().toString() + "\"";
        this.content = _content;
        this.next = null;
        this.name = _name;
    }
    
    //Sirve para crear la declaracion de los nodos que van a ir en el archivo del grafico
    public String declare(){
        if(this.next == null){
            String a = ID + "[shape = box label="+ name + "]\n";
            return a;
        }else{
            String x = "";
            if(next != null){
                x = ID + "[shape = box label="+ name + "]\n"+ next.declare();
            
            }
            return x;
        }
    }
    
    //Crea las conexiones entre los nodos que van a ir en el archivo del grafo
    public String connect(){
        if(this.next == null){
            return ID;
        }else{
            String t = "";
            if(next != null){
                t = ID + "->"+ next.connect();
            
            }
            return t;
        }
    }
    
    
}
