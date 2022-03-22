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
    public NodoABB search(int valor){
        NodoABB aux = raiz;
        int ban = 0;     //Estado Inicial
        while(ban == 0){
            if(aux == null){
                ban = 1; //Fin del arbol
            }else{
                if(aux.content == valor){
                    ban = 2;    //Valor encontrado
                }else{
                    if(aux.content > valor){
                        aux = aux.hijo1;
                    }else{
                        aux = aux.hijo2;
                    }
                }
            }
        }
        
        if(ban == 2){
            return aux;
        }else{
            return null;
        }
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
    
    //Metodo para declarar los nodos
    //String t es la cadena con el codigo que se esta trabajando
    //inicio debe de ser la raiz al declararse para que recorra completo
    public String declarar(NodoABB inicio){
        String t = "";
        if(raiz != null){
            inicio.ID = "\""+UUID.randomUUID().toString() + "\"";
            t += inicio.ID + "[shape = circle label="+ inicio.content + "]\n";
            
            if(inicio.hijo1 != null){
                t += declarar(inicio.hijo1);
            }
            
            if(inicio.hijo2 != null){
                t += declarar(inicio.hijo2);
            }
        }
        return t;
    }
    
    public String conectar(NodoABB inicio){
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
