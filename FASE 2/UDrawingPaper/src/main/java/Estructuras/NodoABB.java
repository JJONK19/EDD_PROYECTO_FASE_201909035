/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.Serializable;

/**
 *
 * @author JJONK19
 */
public class NodoABB implements Serializable{
    String ID; //ID del nodo - Se usa al graficar
    public Capa content; //contenido del nodo
    public NodoABB hijo1; //Hijo izquierdo del arbol
    public NodoABB hijo2; //Hijo derecho del arbol
    Boolean hoja; //Determina si el arbol es una hoja o no
    
    public NodoABB(Capa contenido){
        this.ID = "";
        this.content = contenido;
        this.hijo1 = null;
        this.hijo2 = null;
        this.hoja = true;
    }
}
