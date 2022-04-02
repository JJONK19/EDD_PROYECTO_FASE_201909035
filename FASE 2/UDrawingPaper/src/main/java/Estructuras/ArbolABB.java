/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JJONK19
 */
public class ArbolABB implements Serializable {
    public NodoABB raiz; //Raiz del arbol
    int tamaño;
    public ArbolABB(){
        this.raiz = null;
        tamaño = 0;
    }
    
    //Metodo Añadir
    public void add(Capa agregar, NodoABB revisar){  //Siempre que se vaya a usar, se envia la raiz para que empiece a analizar desde ahí
            if(raiz == null){
                NodoABB nuevo = new NodoABB(agregar);
                raiz = nuevo;
                tamaño++;
            }else{
            if(revisar.content.id != agregar.id){
                if(revisar.content.id > agregar.id){
                    if(revisar.hijo1 == null){
                        NodoABB nuevo = new NodoABB(agregar);
                        revisar.hijo1 = nuevo;
                        tamaño++;
                    }else{
                        add(agregar, revisar.hijo1);
                    }
                }else{
                    if(revisar.hijo2 == null){
                        NodoABB nuevo = new NodoABB(agregar);
                        revisar.hijo2 = nuevo;
                        tamaño++;
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
                if(aux.content.id == valor){
                    ban = 2;    //Valor encontrado
                }else{
                    if(aux.content.id > valor){
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
    
    public int getSize(){
        return tamaño;
    }
    //Metodo para preorden. Siempre que se vaya a declarar, se tiene que mandar raiz como atributo inicial.
    public String preorder(NodoABB inicio){
        String t = "";
        if(raiz != null){
            t += inicio.content.id + " " ;
            if(inicio.hijo1 != null){
                 t += preorder(inicio.hijo1);
            }
            if(inicio.hijo2 != null){
                 t += preorder(inicio.hijo2);
            }
        }
        return t;
    }
    public String preorderI(NodoABB inicio){
        String t = "";
        if(raiz != null){
            t += inicio.content.id + "," ;
            if(inicio.hijo1 != null){
                 t += preorderI(inicio.hijo1);
            }
            if(inicio.hijo2 != null){
                 t += preorderI(inicio.hijo2);
            }
        }
        return t;
    }
    
    //Metodo para post-orden. Siempre que se vaya a declarar, se tiene que mandar raiz como atributo inicial.
    public String postorder(NodoABB inicio){
        String t = "";
        if(raiz != null){
           if(inicio.hijo1 != null){
               t += postorder(inicio.hijo1);
           }
           if(inicio.hijo2 != null){
               t += postorder(inicio.hijo2);
           }
           t += inicio.content.id + " ";
        }
        return t;
    }
    
    //Mismo post orser usasdo para los recorridos de imagenes
    public String postorderI(NodoABB inicio){
        String t = "";
        if(raiz != null){
           if(inicio.hijo1 != null){
               t += postorderI(inicio.hijo1);
           }
           if(inicio.hijo2 != null){
               t += postorderI(inicio.hijo2);
           }
           t += inicio.content.id + ",";
        }
        return t;
    }
    
    //Metodo para inorder. Siempre que se vaya a declarar, se tiene que mandar raiz como atributo inicial.
    public String inorder(NodoABB inicio){
        String t = "";
        if(raiz != null){
            if(inicio.hijo1 != null){
                t += inorder(inicio.hijo1);
            }

            t += inicio.content.id + " ";

            if(inicio.hijo2 != null){
                t += inorder(inicio.hijo2);
            }
        }
        return t;
    }
    
    public String inorderI(NodoABB inicio){
        String t = "";
        if(raiz != null){
            if(inicio.hijo1 != null){
                t += inorderI(inicio.hijo1);
            }

            t += inicio.content.id + ",";

            if(inicio.hijo2 != null){
                t += inorderI(inicio.hijo2);
            }
        }
        return t;
    }
    
    //Recibe el modelo de la tabla y añade la información
    public void esHoja(DefaultTableModel model){
        Cola recorrer = new Cola();
        recorrer.enqueue(this.raiz);
        while(recorrer.no != 0){
            NodoABB aux = (NodoABB) recorrer.dequeue();
            if(aux.hijo1 == null && aux.hijo2 == null){
                model.addRow(new Object[]{ ("Capa " + aux.content.id) });
            }else{
                //Añadir los hijos a la cola de análisis
                if(aux.hijo1 != null){
                    recorrer.enqueue(aux.hijo1);
                }
                
                if(aux.hijo2 != null){
                    recorrer.enqueue(aux.hijo2);
                }
                
            }
        }  
    }
    
    //Copiado para actualizar los pesos del AVL
    public int altura(NodoABB nodo){
        if(nodo.hijo1 == null && nodo.hijo2 == null){
            nodo.altura = 0;
        }else{
            if(nodo.hijo1 == null){
                nodo.altura = altura(nodo.hijo2) + 1;
            }else{
                if(nodo.hijo2 == null){
                    nodo.altura = altura(nodo.hijo1) + 1;
                }else{
                    nodo.altura = mayor(altura(nodo.hijo1), altura(nodo.hijo2)) + 1;
                }
            }
        }       
        return nodo.altura;
    }
    
    //Regresa la profundidadl del arbol
    public int profundidad(){
        altura(raiz);
        return raiz.altura;
    }
    
    //Profundidad del nodo. Realiza una compración simple entre dos valores y regresa el más grande.
    public int mayor(int a1, int a2){
        if(a1 >= a2){ 
            return a1;
        }else{
            return a2;
        }
    }
    
    public String amplitud(){
        String t = "";
        Cola recorrer = new Cola();
        recorrer.enqueue(this.raiz);
        while(recorrer.no != 0){
            NodoABB aux = (NodoABB) recorrer.dequeue();
            t += aux.content.id + ",";
            if(aux.hijo1 != null){
                recorrer.enqueue(aux.hijo1);
            }
            
            if(aux.hijo2 != null){
                recorrer.enqueue(aux.hijo2);
            }
        }
        
        return t;
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
            t += inicio.ID + "[shape = circle label="+ inicio.content.id + "]\n";
            
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
