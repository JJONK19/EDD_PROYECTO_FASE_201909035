/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author JJONK19
 * Basado en: https://github.com/AlexRose97/EDD_1S_2022/blob/main/ArbolB/src/arbolb/ArbolB.java
 */
public class ArbolB implements Serializable {
    public PaginaB raiz;
    boolean recorrer;       //Indica si hay que recorrer o no el arbol
    
    public ArbolB(){
        raiz = null;
        recorrer = false;
    }
    
    //Metodo recursivo para insertar el nodo
    public Object recorrido(NodoB a, PaginaB origen){
        //Bandera que determina si es hoja.
        int ban = 0;
        //Revisa que el primer nodo tenga conexiones
        if(origen.lista.first.izquierda == null){
            ban = 1;
        }
        
        //Caso base
        if(ban == 1){
            //Añadir normalmente el nodo a la pagina
            return origen.addP(a);
        }else{
            //Menor a la raiz. Se mueve a la lista izquierda.
            if(origen.lista.first.contenido.comparar(a.contenido.dpi) == 1){
                Object r = recorrido(a, origen.lista.first.izquierda);
                //Determinar si hay que actualizar la hoja o no
                if(r instanceof NodoB){
                    //Insertar a la lista el nodo
                    NodoB salida = (NodoB) r;
                    return origen.addP(salida);
                }else{
                    //Actualizar pagina actual 
                    PaginaB salida = (PaginaB) r;
                    origen.lista.first.izquierda = salida; 
                    return origen;
                }
            }else{
                //Mayor a la raiz. Mover al lado derecho
                if(origen.lista.last.contenido.comparar(a.contenido.dpi) == -1 ){
                    Object r = recorrido(a, origen.lista.last.derecha);
                    //Determinar si hay que actualizar la hoja o no
                    if(r instanceof NodoB){
                        //Insertar a la lista el nodo
                        NodoB salida = (NodoB) r;
                        return origen.addP(salida);
                    }else{
                        //Actualizar pagina actual 
                        PaginaB salida = (PaginaB) r;
                        origen.lista.last.derecha = salida; 
                        return origen;
                    }
                }else{
                    //Moverse en la lista
                    NodoB mov = origen.lista.first;
                    while(mov != null){
                        if(a.contenido.comparar(mov.contenido.dpi) == -1 ){
                            Object r = recorrido(a, mov.izquierda);
                            if(r instanceof NodoB){ 
                                NodoB salida = (NodoB) r;
                                return origen.addP(salida);
                            }else{
                                PaginaB salida = (PaginaB) r;
                                mov.izquierda = salida;
                                mov.anterior.derecha = salida;
                                return origen;
                            }
                        }else{
                            if(a.contenido == mov.contenido){
                                return origen;
                            }else{
                                mov = mov.siguiente;
                            }
                        }
                    }
                }
            }
        } 
        return this;
    }
    //Añade un nodo 
    public void addN(Cliente data){
        NodoB nuevo = new NodoB(data);
        //Raiz vacia o insertar en lo existencte
        if(raiz == null){
            raiz = new PaginaB();
            raiz = (PaginaB) raiz.addP(nuevo);
        }else{
            //Insertar en la pagina raiz o buscar la pagina dentro de los hijos
            if(!recorrer){
                Object temp = raiz.addP(nuevo);
                //Determinar si hay que actualizar la raiz o no
                if(temp instanceof NodoB){
                    //Actualizar la raiz con el nuevo nodo
                    recorrer = true;    //Hay hijos
                    NodoB salida = (NodoB) temp;
                    raiz = new PaginaB();
                    raiz = (PaginaB) raiz.addP(salida);
                }else{
                    //Apuntar la raiz a la nueva pagina actualizada
                    PaginaB salida = (PaginaB) temp;
                    raiz = salida;
                    
                }
            }else{
                Object temp = recorrido(nuevo, raiz);
                //Determinar si hay que actualizar la raiz o no
                if(temp instanceof NodoB){
                    //Actualizar la raiz con el nuevo nodo
                    NodoB salida = (NodoB) temp;
                    raiz = new PaginaB();
                    raiz = (PaginaB) raiz.addP(salida);
                }else{
                    //Apuntar la raiz a la nueva pagina actualizada
                    PaginaB salida = (PaginaB) temp;
                    raiz = salida;
                }
            }
        }
        
    }
    
    //Método de busqueda
    public NodoB search(String val, PaginaB origen){
        NodoB salida = buscar(val,origen);
        if(salida == null){
            System.out.println("El nodo no existe");
        }else{
            System.out.println(salida.contenido.dpi);
        }
        return salida;
    }
    
    //Metodo recursivo para insertar el nodo
    public NodoB buscar(String val, PaginaB origen){
        //Bandera que determina si es hoja.
        int ban = 0;
        //Revisa que el primer nodo tenga conexiones
        if(origen.lista.first.izquierda == null){
            ban = 1;
        }
        
        NodoB salida = null;
        
        //Caso base
        if(ban == 1){
            NodoB aux = origen.lista.first;
            int bn = 0;
            while(bn == 0){
                if(aux.contenido.comparar(val) == 0){
                    salida = aux;
                    bn = 1;
                }else{
                    if(aux.siguiente == null){
                        salida = null;
                        bn = 1;
                    }else{
                        if(aux.contenido.comparar(val) == -1){
                            aux = aux.siguiente;
                        }else{
                            salida = null;
                            bn = 1;
                        }
                    }
                }
            }
            
        }else{
            //Menor a la raiz. Se mueve a la lista izquierda.
            if(origen.lista.first.contenido.comparar(val)  ==  0){
                salida = origen.lista.first;     ;
                
            }else{
                //Mayor a la raiz. Mover al lado derecho
                if(origen.lista.last.contenido.comparar(val) ==  0){
                   salida  = origen.lista.last;
                    
                }else{
                    //Moverse en la lista
                    NodoB aux = origen.lista.first;
                    int bn = 0;
                    while(bn == 0){
                        if(aux.contenido.comparar(val) == 0){
                            salida = aux;
                            bn = 1;
                        }else{
                            if(aux.contenido.comparar(val) == 1){
                                salida = buscar(val, aux.izquierda);
                                bn = 1;
                            }else{
                                if(aux.siguiente == null){
                                    salida = buscar(val, aux.derecha);
                                    bn = 1;
                                }else{
                                    aux = aux.siguiente;
                                }
                            }
                        }
                    }
                }
            }
        } 
        return salida;
    }
    
    //Metodos de Graficación
    //--------------------------------------------------------------------------
    
    //Metodo para declarar los nodos
    //String t es la cadena con el codigo que se esta trabajando
    //inicio debe de ser la raiz al declararse para que recorra completo
    public String declarar(PaginaB origen){
        //Bandera que determina si es hoja.
        int ban = 1;
        //Revisa que el primer nodo tenga conexiones
        if(origen.lista.first.izquierda != null){
            ban = 0;
        }
        String t = "";

        if(ban == 1){ 
            t += "node[shape=record label= \"<p0>";
            int c =0;
            //Recorrer lista actual
            NodoB aux = origen.lista.first;
            while(aux != null){
                c++;
                t +="|"+aux.contenido.dpi+"|<p"+c+"> ";
                aux= aux.siguiente;
            }
            t +="\"]"+ origen.lista.first.contenido.dpi + ";\n";
        }else{
            //Declara la lista inicial
            t += "node[shape=record label= \"<p0>";
            int c =0;
            NodoB aux = origen.lista.first;
            while(aux!=null){
                c++;
                t +="|{"+aux.contenido.dpi +"}|<p"+ c +"> ";
                aux= aux.siguiente;
            }
            t += "\"]"+ origen.lista.first.contenido.dpi + ";\n";

            //De forma recursiva, recorre cada una de las listas hijos
            //Por la recursividad, baja hasta las hojas del arbol
            aux = origen.lista.first;
            while(aux != null){
                t += declarar(aux.izquierda);
                aux = aux.siguiente;
            }
            t += declarar(origen.lista.last.derecha);
        }
         return t;
    }
    
    public String conectar(PaginaB origen){
         //Bandera que determina si es hoja.
        int ban = 1;
        //Revisa que el primer nodo tenga conexiones
        if(origen.lista.first.izquierda != null){
            ban = 0;
        }
        String t = "";
        if(ban == 1){
            t += origen.lista.first.contenido.dpi+";\n";
        }else{
            NodoB aux = origen.lista.first;
            int c =0;
            while(aux != null){
                t += origen.lista.first.contenido.dpi + ":p"+c+"->"+ conectar(aux.izquierda);
                c++;
                aux = aux.siguiente;
            }
            t += origen.lista.first.contenido.dpi + "->" + conectar(origen.lista.last.derecha);
        }
        return t;
    }

    
    //Unifica el texto que va en el grafo
    public String getcodigo(){
        String t = "digraph G\n" +"{\n" + "rankr=TB;\n";
        
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
