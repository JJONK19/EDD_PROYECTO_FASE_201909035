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
public class NodoAVL implements Serializable{
    String ID; //ID del nodo - Se usa al graficar
    public Imagen content; //contenido del nodo
    public NodoAVL hijo1; //Hijo izquierdo del arbol
    public NodoAVL hijo2; //Hijo derecho del arbol 
    public NodoAVL padre; //Padre del noco en cuestion. Si no tiene es la raiz.
    Boolean hoja; //Determina si el arbol es una hoja o no
    int altura;
    
    public NodoAVL(Imagen contenido){
        this.ID = "";
        this.content = contenido;
        this.hijo1 = null;
        this.hijo2 = null;
        this.padre = null;
        this.hoja = true;
        this.altura = 0;
    }
}
