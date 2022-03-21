/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.UUID;

/**
 *
 * @author JJONK19
 */
public class ArbolAVL {
    NodoAVL raiz;
    
    public ArbolAVL(){
        this.raiz = null;
    }
    
    //Altura del nodo. Regresa la altura del nodo
    public int altura(NodoAVL nodo){
        if(nodo != null){
            return nodo.altura;
        }else{
            return -1;
        }
    }
    
    //Profundidad del nodo. Realiza una compración simple entre dos valores y regresa el más grande.
    public int mayor(int a1, int a2){
        if(a1 >= a2){ 
            return a1;
        }else{
            return a2;
        }
    }
    
    //Rotación simple por la izquerda
    public NodoAVL rotacionl(NodoAVL nodo){
        NodoAVL aux = nodo.hijo1;
        nodo.hijo1 = aux.hijo2;
        aux.hijo2 = nodo;
        //Calculo de las nuevas alturas
        nodo.altura = mayor(altura(nodo.hijo2), altura(nodo.hijo1)) + 1;
        
        aux.altura = mayor(nodo.altura , altura(nodo.hijo1)) + 1;
        return aux;
    }
    //Rotación simple por la derecha
    public NodoAVL rotacionr(NodoAVL nodo){
        NodoAVL aux = nodo.hijo2;
        nodo.hijo2= aux.hijo1;
        aux.hijo1 = nodo;
        //Calculo de las nuevas alturas
        nodo.altura = mayor(altura(nodo.hijo1), altura(nodo.hijo2)) + 1;
        aux.altura = mayor(nodo.altura , altura(nodo.hijo2)) + 1;
        return aux;
    }

    //Rotación Izquierda - Derecha. COmbinar rotaciones nada más.
    public NodoAVL rotacionlr(NodoAVL nodo){
        nodo.hijo1 = rotacionr(nodo.hijo1);
        NodoAVL aux = rotacionl(nodo);
        return aux;
    }

    //Rotación Derecha - Izquierda. Combinar rotaciones nada más 
    public NodoAVL rotacionrl(NodoAVL nodo){
        nodo.hijo2 = rotacionl(nodo.hijo2);
        NodoAVL aux = rotacionr(nodo);
        return aux;
    }
    
    //Inserción de Nodos
    public NodoAVL insertar(NodoAVL revisar , NodoAVL nuevo){
        if(revisar != null){
            if(nuevo.content != revisar.content){
                if(nuevo.content < revisar.content){
                    revisar.hijo1 = insertar(revisar.hijo1 , nuevo);   //Insercion en el hijo izquierdo
                    //Calculo de la nueva altura
                    revisar.altura = mayor(altura(revisar.hijo1), altura(revisar.hijo2)) + 1;
                    //Revision de equilibrio
                    if(altura(revisar.hijo2) - altura(revisar.hijo1) == -2){
                        if(nuevo.content < revisar.hijo1.content){             
                            revisar = rotacionl(revisar);     //Mismo signo con el hijo
                        }else{ 
                            revisar = rotacionlr(revisar);    //Diferente signo con el hijo
                        }
                    }
                }else{
                    revisar.hijo2 = insertar(revisar.hijo2 , nuevo);  //Insercion en el hijo derecho
                    //Calculo de la nueva altura
                    revisar.altura = mayor(altura(revisar.hijo1), altura(revisar.hijo2)) + 1;
                    if(altura(revisar.hijo2) - altura(revisar.hijo1) == 2){
                        if(nuevo.content > revisar.hijo2.content){ 
                            revisar = rotacionr(revisar);    //Mismo signo con el hijo
                        }else{
                            revisar = rotacionrl(revisar);    //Diferente signo con el hijo
                        }
                    }
                }
            }
            return revisar;
        }else{
            revisar = nuevo;
            return revisar;
        }
    }
    
    //Añadir Nodo
    public void add(int agregar){ //Siempre que se vaya a usar, se envia la raiz para que empiece a analizar desde ahí
        NodoAVL nuevo = new NodoAVL(agregar);
        if(raiz == null){
            raiz = nuevo;
        }else{
            raiz = insertar(raiz, nuevo);
        }
    }
    
    //Metodo para preorden. Siempre que se vaya a declarar, se tiene que mandar raiz como atributo inicial.
    public void preorder(NodoAVL inicio){
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
    public void postorder(NodoAVL inicio){
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
    public void inorder(NodoAVL inicio){
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
    
    //Metodo para declarar los nodos
    //String t es la cadena con el codigo que se esta trabajando
    //inicio debe de ser la raiz al declararse para que recorra completo
    public String declarar(NodoAVL inicio){
        String t = "";
        if(raiz != null){
            inicio.ID = "\""+UUID.randomUUID().toString() + "\"";
            t += inicio.ID + "[shape = circle label="+ inicio.content  + "]\n";
            
            if(inicio.hijo1 != null){
                t += declarar(inicio.hijo1);
            }
            
            if(inicio.hijo2 != null){
                t += declarar(inicio.hijo2);
            }
        }
        return t;
    }
    
    public String conectar(NodoAVL inicio){
        String t = "";
        if(raiz != null){
            if(inicio.hijo1 != null){
                t += inicio.ID + "->"+ inicio.hijo1.ID + "[label = \"I\"]\n";
            }
            
            if(inicio.hijo2 != null){
                t += inicio.ID + "->"+ inicio.hijo2.ID + "[label = \"D\"]\n";
            }
            
            if(inicio.hijo1 != null){
               t += conectar(inicio.hijo1);
            }
            
            if(inicio.hijo2 != null){
                t += conectar(inicio.hijo2);
            }
        }
        return t;
    }

    
    //Unifica el texto que va en el grafo
    public String getcodigo(){
        String t = "digraph G\n" +"{\n" + "node [ shape=circle ];\n";
        
        //Declarar nodos
        t += declarar(raiz);
        
        //Hacer conexiones
        t += conectar(raiz);
        t += "}";
        return t;
    }
    
    //Crea y escribe el archivo que lleva el codifo del grafo generado
    public void escribir(String ruta, String contenido){
        FileWriter fichero = null;
        PrintWriter p = null;
        
        try{
            fichero  = new FileWriter(ruta);
            p = new PrintWriter(fichero);
            p.write(contenido);
            p.close();
            fichero.close();
        
        }catch(Exception e){
            System.out.print(e.getMessage());
            
        }finally{
            if (p!= null){
                p.close();
            }
        }
        
    }
    
    //Se encarga de dibujar el grafo. Ruta es el nombre del archivo *.txt y gname es el nombre
    //del grafo en formato *.png
    
    public void dibujar(String ruta, String gname){
        try{
            escribir(ruta, getcodigo());
            ProcessBuilder a;
            a = new ProcessBuilder("dot", "-Tpng", "-o", gname, ruta);
            a.redirectErrorStream(true);
            a.start();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
