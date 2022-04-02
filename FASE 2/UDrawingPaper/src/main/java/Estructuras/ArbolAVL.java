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
 */
public class ArbolAVL implements Serializable{
    public NodoAVL raiz;
    
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
                if(nuevo.content.id < revisar.content.id){
                    revisar.hijo1 = insertar(revisar.hijo1 , nuevo);   //Insercion en el hijo izquierdo
                    //Calculo de la nueva altura
                    revisar.altura = mayor(altura(revisar.hijo1), altura(revisar.hijo2)) + 1;
                    //Revision de equilibrio
                    if(altura(revisar.hijo2) - altura(revisar.hijo1) == -2){
                        if(nuevo.content.id < revisar.hijo1.content.id){             
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
                        if(nuevo.content.id > revisar.hijo2.content.id){ 
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
    public void add(Imagen agregar){ //Siempre que se vaya a usar, se envia la raiz para que empiece a analizar desde ahí
        NodoAVL nuevo = new NodoAVL(agregar);
        if(raiz == null){
            raiz = nuevo;
        }else{
            raiz = insertar(raiz, nuevo);
        }
    }
    
    //Eliminar Nodo
    public void borrar(NodoAVL nodo){
        if(nodo != null){
            if(nodo.hijo1 == null && nodo.hijo2 == null){   //Es una hoja
                if(nodo.padre.hijo1 != null){
                    if(nodo.padre.hijo1.equals(nodo)){
                        nodo.padre.hijo1 = null;
                        actualizar(this.raiz);
                        balance(this.raiz, null);
                    }else{
                        nodo.padre.hijo2 = null;
                        actualizar(this.raiz);
                        balance(this.raiz, null);
                    }
                }else{
                    nodo.padre.hijo2 = null;
                    actualizar(this.raiz);
                    balance(this.raiz, null);
                }
                
                nodo = null;
                
            }else{
                if(nodo.hijo1 == null){         //Solo tiene un hijo
                    nodo.content = nodo.hijo2.content;
                    nodo.hijo2 = null;
                    actualizar(this.raiz);
                    balance(this.raiz, null);
                }else{
                    if(nodo.hijo2 == null){     //Solo tiene un hijo
                        nodo.content= nodo.hijo1.content;
                        nodo.hijo1 = null;
                        actualizar(this.raiz);
                        balance(this.raiz, null);
                    }else{                      //Los dos hijos existen
                        nodo.content = (Imagen) grande(nodo.hijo1, nodo);
                        actualizar(this.raiz);
                        balance(this.raiz, null);
                    }
                }
            }
        }
    }
    
    //Conseguir la posicion del más grande de los pequeños
    public Object grande(NodoAVL nodo, NodoAVL pa){
        NodoAVL aux = nodo;
        NodoAVL padre= pa;
        int pos = 1; //1 para hijo izquierdo y 2 para hijo derecho
        int ban = 0;     //Estado Inicial
        Object content = null;
        if(nodo.hijo1 == null && nodo.hijo2 == null){
            content = nodo.content;
            pa.hijo1 = null;
        }else{
            while(ban == 0){
                if(aux.hijo2 != null){
                    padre = aux;
                    pos = 2;
                    aux = aux.hijo2;
                }else{
                    content = aux.content;
                    if(pos == 1){
                       padre.hijo1 = aux.hijo1;
                    }else{
                       padre.hijo2 = aux.hijo2;
                        }
                    ban = 1;
                }
            }
        }
        
        return content;
    }
    
    //Metodo para buscar
    public NodoAVL search(int valor){
        NodoAVL aux = raiz;
        NodoAVL pa = raiz;
        int ban = 0;     //Estado Inicial
        while(ban == 0){
            if(aux == null){
                ban = 1; //Fin del arbol
            }else{
                if(aux.content.id == valor){
                    aux.padre = pa;
                    ban = 2;    //Valor encontrado
                }else{
                    if(aux.content.id > valor){
                        pa = aux;
                        aux = aux.hijo1;
                    }else{
                        pa = aux;
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
    
    public void delete(int valor){
        NodoAVL aux = search(valor);
        borrar(aux);
    }
    //Actualiza los pesos y vuleve a modificar en caso sea necesario. Revisa desde la raiz. 
    public int actualizar(NodoAVL nodo){
        if(nodo.hijo1 == null && nodo.hijo2 == null){
            nodo.altura = 0;
        }else{
            if(nodo.hijo1 == null){
                nodo.altura = actualizar(nodo.hijo2) + 1;
            }else{
                if(nodo.hijo2 == null){
                    nodo.altura = actualizar(nodo.hijo1) + 1;
                }else{
                    nodo.altura = mayor(actualizar(nodo.hijo1), actualizar(nodo.hijo2)) + 1;
                }
            }
        }       
        return nodo.altura;
    }
    
    //Reacomoda los nodos si el arbol se desbalanceo. Revisa desde la raiz.
    public void balance(NodoAVL nodo, NodoAVL padre){
        int a1 = altura(nodo.hijo1);
        int a2 = altura(nodo.hijo2);
        
        if(nodo.hijo1 != null){
            balance(nodo.hijo1, nodo);
        }
        if(nodo.hijo2 != null){
            balance(nodo.hijo2, nodo);
        }
        
        //Revision de equilibrio
        if(a1 == -1){
            a1 = 0;
        }else{
            a1 +=1;
        }
        if(a2 == -1){
            a2 = 0;
        }else{
            a2 +=1;
        }
        int dif = a2 - a1;
        
        if(dif == 0 || dif == 1 || dif == -1){
            
        }else{
            if(nodo.hijo1 == null && nodo.hijo2 == null){
                
            }else{
                if(dif < 0){
                    int ah1 = altura(nodo.hijo1.hijo1);
                    int ah2 = altura(nodo.hijo1.hijo2);
                    int difh = ah2 - ah1;
                    
                    if(difh <= 0){
                        
                        nodo = rotacionl(nodo);     //Mismo signo con el hijo
                        if(padre == null){
                            raiz = nodo;
                        }else{
                            padre.hijo1 = nodo;
                        }
                    }else{
                        
                        nodo = rotacionlr(nodo);    //Diferente signo con el hijo
                        if(padre == null){
                            raiz = nodo;
                        }else{
                            padre.hijo1 = nodo;
                        }
                    }
                }else{
                    int ah1 = altura(nodo.hijo2.hijo1);
                    int ah2 = altura(nodo.hijo2.hijo2);
                    int difh = ah2 - ah1;
                    if(difh < 0){
                        
                        nodo = rotacionrl(nodo);     //diferente signo con el hijo
                        if(padre == null){
                            raiz = nodo;
                        }else{
                            padre.hijo2 = nodo;
                        }
                    }else{
                        
                        nodo = rotacionr(nodo);    //mismo signo con el hijo
                        if(padre == null){
                            raiz = nodo;
                        }else{
                            padre.hijo2 = nodo;
                        }
                    }
                }   
            }
        }
        
    }
    //Metodo para preorden. Siempre que se vaya a declarar, se tiene que mandar raiz como atributo inicial.
    public String preorder(NodoAVL inicio){
        String t = "";
        if(raiz != null){
            t += inicio.content.id + "," ;
            if(inicio.hijo1 != null){
                 t += preorder(inicio.hijo1);
            }
            if(inicio.hijo2 != null){
                 t += preorder(inicio.hijo2);
            }
        }
        return t;
    }
    
    //Metodo para post-orden. Siempre que se vaya a declarar, se tiene que mandar raiz como atributo inicial.
    public String postorder(NodoAVL inicio){
        String t = "";
        if(raiz != null){
           if(inicio.hijo1 != null){
               t += postorder(inicio.hijo1);
           }
           if(inicio.hijo2 != null){
               t += postorder(inicio.hijo2);
           }
           t += inicio.content.id + ",";
        }
        return t;
    }
    
    //Metodo para inorder. Siempre que se vaya a declarar, se tiene que mandar raiz como atributo inicial.
    public String inorder(NodoAVL inicio){
        String t = "";
        if(raiz != null){
            if(inicio.hijo1 != null){
                t += inorder(inicio.hijo1);
            }

            t += inicio.content.id + ",";

            if(inicio.hijo2 != null){
                t += inorder(inicio.hijo2);
            }
        }
        return t;
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
            t += inicio.ID + "[shape = circle label=\""+ inicio.content.id + "\"]\n";
            
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
