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
//Contenedores de los nodos del arbol
public class ListaB implements Serializable {
    NodoB first;
    NodoB last;
    int size;
    
    public ListaB(){
        first = null;
        last = null;
        size = 0;
    }
    
    //Añadir nuevo elemento a la lista. 
    //Retorna un booleano que indica si el elemento se pudo añadir (en caso esté repetido) 
    public boolean add(NodoB a){
        boolean ban = false;
        //Lista vacia
        if(first == null){
            first = a;
            last = a;
            size += 1;
            ban = true;
        }else{
            //Un elemento en existencia
            if(first == last){
                //Insertar al inicio
                if(first.contenido.comparar(a.contenido.dpi) == 1){
                    //Posiciones de lista
                    a.siguiente = first;
                    first.anterior = a;
                    //Posiciones de pagina
                    first.izquierda = a.derecha;
                    first = a;
                    size += 1;
                    ban = true;
                }else{
                    //Insertar al final
                    if(last.contenido.comparar(a.contenido.dpi) == -1 ){
                        //Posiciones de lista
                        a.anterior = last;
                        last.siguiente = a;
                        //Posiciones de pagina
                        last.derecha = a.izquierda;
                        last = a;
                        size += 1;
                        ban = true;
                    }
                }
            }else{
                //Insertar al inicio
                if(first.contenido.comparar(a.contenido.dpi) == 1 ){
                    //Posiciones de lista
                    a.siguiente = first;
                    first.anterior = a;
                    //Posiciones de pagina
                    first.izquierda = a.derecha;
                    first = a;
                    size += 1;
                    ban = true;
                }else{
                    //Insertar al final
                    if(last.contenido.comparar(a.contenido.dpi) == -1 ){
                        //Posiciones de lista
                        a.anterior = last;
                        last.siguiente = a;
                        //Posiciones de pagina
                        last.derecha = a.izquierda;
                        last = a;
                        size += 1;
                        ban = true;
                    }else{
                        //Recorrer para insertar en medio
                        NodoB aux = first;
                        while(aux != null){
                            if(a.contenido.comparar(aux.contenido.dpi) == -1 ){
                                //punteros
                                
                                //Punteros
                                a.siguiente = aux;
                                a.anterior = aux.anterior;
                                //Manejo de paginas
                                aux.izquierda= a.derecha;
                                aux.anterior.derecha = a.izquierda;
                                //Punteros
                                aux.anterior.siguiente = a;
                                aux.anterior = a;
                                size++;
                                ban = true;
                                break;
                            }else{
                                aux = aux.siguiente;
                            }
                        }
                    }
                }
            }
        }
        
        return ban;
    }
}
