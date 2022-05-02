/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.Serializable;

/**
 *
 * @author JJONK19
 * Basado en : https://github.com/AlexRose97/EDD_1S_2022/blob/main/ArbolB/src/arbolb/NodoB.java
 */

//Contenedor base del arbol
public class NodoB implements Serializable {
    public Cliente contenido;  //Contenido del nodo
    NodoB siguiente; //Sirve para la lista
    NodoB anterior; //Sirve para la lista
    PaginaB izquierda; //Nodo del arbol
    PaginaB derecha; //Nodo del arbol
    
    public NodoB(Cliente contenido){
        this.contenido = contenido;
        siguiente = null;
        anterior = null;
        izquierda = null;
        derecha = null;
    }
}
