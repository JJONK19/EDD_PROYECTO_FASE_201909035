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
public class NodoMatriz implements Serializable {
    NodoMatriz arriba;
    NodoMatriz abajo;
    NodoMatriz izquierda;
    NodoMatriz derecha;
    int x; //Posicion en x de la matriz
    int y; //Posicion en y de la matriz
    Object contenido; 
    String ID; //Usado para graficar
    String Nombre;
    
    //Nodo para construir nodos
    public NodoMatriz(int x, int y, Object contenido){
        arriba = null;
        abajo = null; 
        izquierda = null;
        derecha = null;
        this.x = x;
        this.y = y;
        this.contenido = contenido;
        this.Nombre = "";
    }
    
    //Nodo cabeceras
    public NodoMatriz(int x, int y, String Nombre){
        arriba = null;
        abajo = null; 
        izquierda = null;
        derecha = null;
        this.x = x;
        this.y = y;
        this.contenido = null;
        this.Nombre = Nombre;
    }
    
    //Constructor para nodo raiz
    public NodoMatriz(){
        arriba = null;
        abajo = null; 
        izquierda = null;
        derecha = null;
        x = -1;
        y = -1;
        contenido = null;
        Nombre = "";
    }
    
}
