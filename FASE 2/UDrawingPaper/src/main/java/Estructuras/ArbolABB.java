/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author JJONK19
 */
public class ArbolABB {
    NodoABB raiz; //Raiz del arbol
    
    public ArbolABB(){
        this.raiz = null;
    }
    
    //Metodo Añadir
    public void add(int agregar, NodoABB revisar){  //Siempre que se vaya a usar, se envia la raiz para que empiece a analizar desde ahí
        if(raiz == null){
            NodoABB nuevo = new NodoABB(agregar);
            raiz = nuevo;
        }else{
            if(revisar.content != agregar){
                if(revisar.content > agregar){
                    if(revisar.hijo1 == null){
                        NodoABB nuevo = new NodoABB(agregar);
                        revisar.hijo1 = nuevo;
                    }else{
                        add(agregar, revisar.hijo1);
                    }
                }else{
                    if(revisar.hijo2 == null){
                        NodoABB nuevo = new NodoABB(agregar);
                        revisar.hijo2 = nuevo;
                    }else{
                        add(agregar, revisar.hijo2);
                    }
                }
            }
        }
    }
    
    //Metodo para buscar
    public void search(){
    }
    
    //Metodo para borrar
    public void delete(){
    }
    
    //Metodo para preorden. Siempre que se vaya a declarar, se tiene que mandar raiz como atributo inicial.
    public void preorder(NodoABB inicio){
        if(raiz != null){
            System.out.print(" " + inicio.content + " ");
            if(inicio.hijo1 != null){
                preorder(inicio.hijo1);
            }
            if(inicio.hijo2 != null){
                preorder(inicio.hijo2);
            }
        }
    }
    
    //Metodo para post-orden. Siempre que se vaya a declarar, se tiene que mandar raiz como atributo inicial.
    public void postorder(NodoABB inicio){
        if(raiz != null){
           if(inicio.hijo1 != null){
               postorder(inicio.hijo1);
           }
           if(inicio.hijo2 != null){
               postorder(inicio.hijo2);
           }
           System.out.print(" " + inicio.content + " ");   
        }
    }
    
    //Metodo para inorder. Siempre que se vaya a declarar, se tiene que mandar raiz como atributo inicial.
    public void inorder(NodoABB inicio){
        if(raiz != null){
            if(inicio.hijo1 != null){
                inorder(inicio.hijo1);
            }

            System.out.print(" " + inicio.content + " ");

            if(inicio.hijo2 != null){
                inorder(inicio.hijo2);
            }
        }
    }
    
    //Metodos de Graficación
    //--------------------------------------------------------------------------
    
   
}
