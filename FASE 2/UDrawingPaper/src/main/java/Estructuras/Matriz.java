/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

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
                    while(aux != null){
                        if(x == aux.x){
                            temp.arriba = aux.arriba;
                            temp.abajo = aux.abajo;
                            aux = temp;
                            break;
                        }else{
                            aux = aux.abajo;
                        }
                    }
                    
                    //Modificar X
                    NodoMatriz Aux = tempx;
                    while(Aux != null){
                        if(y == aux.y){
                            temp.izquierda = aux.izquierda;
                            temp.derecha = aux.derecha;
                            aux = temp;
                            break;
                        }else{
                            aux = aux.derecha;
                        }
                    }
                }
            }
        }
    }
}
