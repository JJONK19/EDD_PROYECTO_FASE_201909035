/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.Serializable;

/**
 *
 * @author JJONK19
 * Basado en https://github.com/AlexRose97/EDD_1S_2022/blob/main/ArbolB/src/arbolb/RamaB.java
 */

//Las paginas funcionan como nodos del arbol
public class PaginaB implements Serializable{
    ListaB lista;   //Lista de claves
    int tamaño;
    
    public PaginaB(){
        lista = new ListaB();   
        tamaño = 0;
    }
    //Dividir la pagina en caso de haber superado el limite permitido
    //Regresa el nodo de la nueva raiz
    public NodoB divide(PaginaB a){
        NodoB aux = a.lista.first;  
        //Moverse al centro de la lista
        for(int i = 0; i < 2; i++){ 
            aux = aux.siguiente;
        }
        
        //Separar la lista por partes, reiniciar sus posiciones y crear nuevas paginas
        //Lista1
        NodoB L11 = a.lista.first;
        NodoB L12= L11.siguiente;
        L11.anterior = L11.siguiente = L12.anterior = L12.siguiente = null;
        PaginaB left = new PaginaB();
        left.addP(L11);
        left.addP(L12);
        
        //Lista2
        NodoB L21 = aux.siguiente;
        NodoB L22 = L21.siguiente;
        L21.anterior = L21.siguiente = L22.anterior = L22.siguiente = null;
        PaginaB right = new PaginaB();
        right.addP(L21);
        right.addP(L22);
        
        //Nodo Raiz. Añadir ambas listas a la nueva raiz.
        aux.anterior = aux.siguiente = null;
        aux.izquierda = left;
        aux.derecha = right;
        
        return aux;
    }
    
    
    //Tiene dos opciones. En el primer caso, regresa la lista actualizada
    //En el segundo, divide las paginas y regresa el primer nodo de la nueva raiz
    public Object addP(NodoB a){
        Object val = null;
        if(lista.add(a)){
            tamaño = lista.size;
            //Validacion de tamaños
            if(tamaño == 5){
                val = divide(this);         //Nodo de la nueva raiz
            }else{
                if(tamaño < 5){
                    val = this;             //Pagina modificada
                }
            }
        }
        
        return val;
    }
}
