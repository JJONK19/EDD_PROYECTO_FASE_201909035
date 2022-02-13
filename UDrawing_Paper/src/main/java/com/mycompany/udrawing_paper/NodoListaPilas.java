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
public class NodoListaPilas {
    String ID;          //ID del nodo. Tiene uso en el gráfico.
    Object content;     //Contenido del Nodo
    NodoListaPilas next;      //Apuntador al siguiente nodo de la lista
    String name;        //Nombre que va a aparecer en el grafo
    Object structure;   //Contiene una estructura auxiliar en caso de ser una lista de-
    
    public NodoListaPilas(Object _content, String _name){
        this.ID = "\""+UUID.randomUUID().toString() + "\"";
        this.structure = _content;
        this.next = null;
        this.name = _name;
        this.content = null;
    }
    
    //Borra la estructura asociada al nodo 
    public void deleteS(){
        this.structure = null;
    }
    
    //Elimina el contenido del nodo
    public void deleteC(){
        this.content = null;
    }
}
