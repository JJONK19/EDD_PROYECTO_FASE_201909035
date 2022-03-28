/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.UUID;

/**
 *
 * @author JJONK19
 */
public class NodoCola {
    Object content;     //Contenido del Nodo
    NodoCola next;      //Apuntador al siguiente nodo de la lista
    
    public NodoCola(Object _content){
        this.content = _content;
        this.next = null;
    }
}
