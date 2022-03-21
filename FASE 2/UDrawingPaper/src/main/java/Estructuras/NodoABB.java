/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author JJONK19
 */
public class NodoABB {
    String ID; //ID del nodo - Se usa al graficar
    int content; //contenido del nodo
    NodoABB hijo1; //Hijo izquierdo del arbol
    NodoABB hijo2; //Hijo derecho del arbol 
    NodoABB padre; //Padre del noco en cuestion. Si no tiene es la raiz.
    Boolean hoja; //Determina si el arbol es una hoja o no
    
    public NodoABB(int contenido){
        this.ID = "";
        this.content = contenido;
        this.hijo1 = null;
        this.hijo2 = null;
        this.padre = null;
        this.hoja = true;
    }
}