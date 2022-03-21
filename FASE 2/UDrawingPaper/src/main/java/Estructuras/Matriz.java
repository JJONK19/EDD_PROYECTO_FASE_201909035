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
public class Matriz {
    NodoMatriz raiz;
    
    public Matriz(){
        raiz = new NodoMatriz();
    }
    
    //Buscar si la columna ya existe en la lista de columnas
    //Regresa null si no lo encuentra
    public NodoMatriz searchy(int y){
        NodoMatriz aux = raiz;
        while(aux != null){
            if(aux.y == y){
                break;
            }else{
                aux = aux.derecha;
            }
        }
        
        return aux;
    }
    
    //Buscar si la fila ya existe en la lista de filas
    //Regresa null si no lo encuentra
    public NodoMatriz searchx(int x){
        NodoMatriz aux = raiz;
        while(aux != null){
            if(aux.x == x){
                break;
            }else{
                aux = aux.abajo;
            }
        }
        
        return aux;
    }
    
    //Añadir uma nueva columna
    public void ncol (int y){
        String nombre = Integer.toString(y);
        NodoMatriz temp = new NodoMatriz(-1, y, nombre);
        NodoMatriz aux = raiz;
        while(aux != null){
            if(y > aux.y){
                //Añadir al final
                if(aux.derecha == null){
                    aux.derecha = temp;
                    temp.izquierda = aux;
                    break;
                }
                else{
                    aux = aux.derecha;
                }
            }else{
                //Añadir en medio
                NodoMatriz ant = aux.izquierda;
                ant.derecha = temp;
                temp.izquierda = ant;
                temp.derecha = aux;
                aux.izquierda = temp;
                break;
            }
        }
    }
    
    //Añadir una nueva fila
    public void nfil (int x){
        String nombre = Integer.toString(x);
        NodoMatriz temp = new NodoMatriz(x, -1, nombre);
        NodoMatriz aux = raiz;
        while(aux != null){
            if(x > aux.x){
                //Añadir al final
                if(aux.abajo == null){
                    aux.abajo = temp;
                    temp.arriba = aux;
                    break;
                }
                else{
                    aux = aux.abajo;
                }
            }else{
                //Añadir en medio
                NodoMatriz ant = aux.arriba;
                ant.abajo = temp;
                temp.arriba = ant;
                temp.abajo = aux;
                aux.arriba = temp;
                break;
            }
        }
    }
    //Añadir una posicion a la matriz
    public void add(int x, int y, Object contenido){
        NodoMatriz tempx = searchx(x);
        NodoMatriz tempy = searchy(y);
        NodoMatriz temp = new NodoMatriz(x, y, contenido);
        
        if(tempx == null && tempy == null){
            nfil(x);    //Añadir la fila que no está
            ncol(y);    //añadir la columna que no esta
            tempx = searchx(x);
            tempy = searchy(y);
            tempx.derecha = temp;
            temp.izquierda = tempx;
            tempy.abajo = temp;
            temp.arriba = tempy;
        }else{
            if(tempx != null && tempy == null){
                //Añadir en y
                ncol(y);    //añadir la columna que no esta
                tempy = searchy(y);
                tempy.abajo = temp;
                temp.arriba = tempy;
                
                //Añadir en x. Es copiar el metodo para añadir columna.
                NodoMatriz aux = tempx;
                while(aux != null){
                    if(y > aux.y){
                        //Añadir al final
                        if(aux.derecha == null){
                            aux.derecha = temp;
                            temp.izquierda = aux;
                            break;
                        }
                        else{
                            aux = aux.derecha;
                        }
                    }else{
                        //Añadir en medio
                        NodoMatriz ant = aux.izquierda;
                        ant.derecha = temp;
                        temp.izquierda = ant;
                        temp.derecha = aux;
                        aux.izquierda = temp;
                        break;
                    }
                }
            }else{
                if(tempx == null && tempy != null){
                    //Añadir en x
                    nfil(x);    //Añadir la fila que no está
                    tempx = searchx(x);
                    tempx.derecha = temp;
                    temp.izquierda = tempx;
                    
                    //Añadir en y. Es copiar el codigo para añadir una fila
                    NodoMatriz aux = tempy;
                    while(aux != null){
                        if(x > aux.x){
                            //Añadir al final
                            if(aux.abajo == null){
                                aux.abajo = temp;
                                temp.arriba = aux;
                                break;
                            }
                            else{
                                aux = aux.abajo;
                            }
                        }else{
                            //Añadir en medio
                            NodoMatriz ant = aux.arriba;
                            ant.abajo = temp;
                            temp.arriba = ant;
                            temp.abajo = aux;
                            aux.arriba = temp;
                            break;
                        }
                    }
                }else{
                    //Modificar Y
                    NodoMatriz aux = tempy;
                    int bany = 0;
                    while(aux != null){
                        if(x == aux.x){
                            temp.arriba = aux.arriba;
                            temp.abajo = aux.abajo;
                            aux = temp;
                            bany = 1;
                            break;
                        }else{
                            aux = aux.abajo;
                        }
                    }
                    if(bany == 0){
                        aux = tempy;
                        while(aux != null){
                            if(x > aux.x){
                                //Añadir al final
                                if(aux.abajo == null){
                                    aux.abajo = temp;
                                    temp.arriba = aux;
                                    break;
                                }
                                else{
                                    aux = aux.abajo;
                                }
                            }else{
                                //Añadir en medio
                                NodoMatriz ant = aux.arriba;
                                ant.abajo = temp;
                                temp.arriba = ant;
                                temp.abajo = aux;
                                aux.arriba = temp;
                                break;
                            }
                        }
                    }
                    
                    //Modificar X
                    aux = tempx;
                    int banx = 0;
                    while(aux != null){
                        if(y == aux.y){
                            temp.izquierda = aux.izquierda;
                            temp.derecha = aux.derecha;
                            aux = temp;
                            banx = 1;
                            break;
                        }else{
                            aux = aux.derecha;
                        }
                    }
                    if(banx == 0){
                        aux = tempx;
                        while(aux != null){
                            if(y > aux.y){
                                //Añadir al final
                                if(aux.derecha == null){
                                    aux.derecha = temp;
                                    temp.izquierda = aux;
                                    break;
                                }
                                else{
                                    aux = aux.derecha;
                                }
                            }else{
                                //Añadir en medio
                                NodoMatriz ant = aux.izquierda;
                                ant.derecha = temp;
                                temp.izquierda = ant;
                                temp.derecha = aux;
                                aux.izquierda = temp;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    //Metodos de Graficación Basado en:  https://502tec.com/matriz-dispersa-en-graphviz-sin-morir-en-el-intento/
    //--------------------------------------------------------------------------
    
    //Metodo para declarar los nodos
    //String t es la cadena con el codigo que se esta trabajando
    public String declarar(){
        String t = "";
        
        //Declarar Cabecera - Filas
        NodoMatriz aux = raiz.abajo;
        while(aux != null){
            t += "F"+Integer.toString(aux.x)+"[ label = \""+Integer.toString(aux.x)+"\", width = 1 height=1, group = -1 ];\n";
            //Declarar contenido de filas
            NodoMatriz temp = aux.derecha;
            while(temp != null){
                t += "F"+Integer.toString(temp.x)+"C"+Integer.toString(temp.y)+"[width = 1 height=1, group =" + Integer.toString(temp.y) + "];\n";
                temp = temp.derecha;
            }
            aux = aux.abajo;
        }
        
        //Declarar Cabecera - columnas
        aux = raiz.derecha;
        while(aux != null){
            t += "C"+Integer.toString(aux.y)+"[ label = \""+Integer.toString(aux.y)+"\", width = 1 height=1, group =" + Integer.toString(aux.y) + "];\n";
            aux = aux.derecha;
        }
        
        return t;
    }
    
    public String conectar(){
        String t = "";
        //Conectar Raiz a cabeceras
        if(raiz.derecha!=null){
            t += "R ->" + "C"+Integer.toString(raiz.derecha.y)+";\n";
        }
        if(raiz.abajo != null){
            t += "R ->" + "F"+Integer.toString(raiz.abajo.x)+";\n";
        }
        
        //Conectar Cabecera - Filas
        NodoMatriz aux = raiz.abajo;
        while(aux != null){
            if(aux.abajo !=null){
                t += "F"+Integer.toString(aux.x) + "->" + "F" + Integer.toString(aux.abajo.x) + "[dir=\"both\"];\n";
            } 
            
            //Conectar contenido de filas
            NodoMatriz temp = aux.derecha;
            String rank = "F"+Integer.toString(aux.x)+";";
            //---Declarar conexion con el inicial
            if(temp != null){
                t += "F"+Integer.toString(aux.x) + "->" + "F"+Integer.toString(temp.x)+"C"+Integer.toString(temp.y) + "[dir=\"both\"];\n";
                while(temp != null){
                    if(temp.derecha !=null){
                        t += "F"+Integer.toString(temp.x)+"C"+Integer.toString(temp.y) + "->" + "F"+Integer.toString(temp.derecha.x)+"C"+Integer.toString(temp.derecha.y) + "[dir=\"both\"];\n";
                    }
                    rank += "F"+Integer.toString(temp.x)+"C"+Integer.toString(temp.y) + ";";
                    if(temp.abajo !=null){
                        t += "F"+Integer.toString(temp.x)+"C"+Integer.toString(temp.y) + "->" + "F"+Integer.toString(temp.abajo.x)+"C"+Integer.toString(temp.abajo.y) + "[dir=\"both\"];\n";
                    }
                    temp = temp.derecha;
                }
                t += "{rank = same;"+rank+"}";
            }
            
            aux = aux.abajo;
        }
        
        //Conectar Cabecera - columnas
        String rank = "R;";
        aux = raiz.derecha;
        while(aux != null){
            if(aux.derecha !=null){
                t += "C"+Integer.toString(aux.y) + " -> " + "C" + Integer.toString(aux.derecha.y) + "[dir=\"both\"];\n";
            }
            rank += "C"+aux.Nombre + ";";
            
            //Conectar contenido de filas
            NodoMatriz temp = aux.abajo;
            //---Declarar conexion con el inicial
            if(temp != null){
                t += "C"+Integer.toString(aux.y) + "->" + "F"+Integer.toString(temp.x)+"C"+Integer.toString(temp.y) + "[dir=\"both\"];\n";
            }
            aux = aux.derecha;
        }
        t += "{rank = same;"+rank+"}";
        
        return t;
    }

    
    //Unifica el texto que va en el grafo
    public String getcodigo(){
        String t = "digraph G\n" +"{\n" + "node [ shape=square ];\n";
        t += "R[ label = \"R\", width = 1 height=1, group = -1 ];\n"
                + "e0[ shape = point, width = 0 ];\n"
                + "e1[ shape = point, width = 0 ];\n";
        
        //Declaraciones 
        t += declarar();
        
        //Conexiones
        t += conectar();
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

