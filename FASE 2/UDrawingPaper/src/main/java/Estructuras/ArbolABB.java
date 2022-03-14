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
    public String ID; //Nombre del arbol
    NodoABB raiz; //Raiz del arbol
    int no; //Nodos del arbol
    public ArrayList<NodoABB> Nodos;  //Lista de Nodos del arbol. Se usa para graficar.
    
    public ArbolABB(String _ID, NodoABB _cabecera){
        this.ID = _ID;
        this.Nodos = new ArrayList<>();
        this.raiz = _cabecera;
        this.no = 0;
    }
    
    //Metodos de Graficación
    //--------------------------------------------------------------------------
    
    //Unifica el texto que va en el grafo
    public String getcodigo(){
        String t = "digraph G\n" +"{\n" + "node [ shape=circle ];\n";
        //Asignación de nombres, ID, y nodo
        for(int i = 0; i < this.Nodos.size(); i++){
            NodoABB temp = Nodos.get(i);
            temp.ID = "\""+UUID.randomUUID().toString() + "\"";
            
            String last = "(" + temp.last.get(0);
            for (int j = 1; j < temp.last.size(); j++) {
		last += "," + temp.last.get(j) ;
            }
            last += ")";
             
            String anulable;
            if(temp.anulable){
                anulable = "V";
            }else{
                anulable = "F";
            }
            
            String nombre = "";
            if(temp.nombre == null){
                nombre = "-";
            }else{
                nombre = temp.nombre;
            }
            
            t += temp.ID + "[ label=\""+ first + "| {" + anulable + "|" + temp.simbolo + "|"+ nombre + "} |" + last + "\"];\n";
            
             /*
             t += temp.ID + "[ label=\""+ first + "| {" + anulable + temp.valor + temp.nombre + "} |" + last + "\"];\n";
             */
        }

        
        //Conexión de Nodos
        for(int i = 0; i < this.Nodos.size(); i++){
            NodoA temp = Nodos.get(i);
            //Conexion a Hijo1
            if(temp.hijo1 != null){
                t += temp.ID + "->" + temp.hijo1.ID + "[minlen=2 ];\n";
            }
            //Conexion a Hijo 2
            if(temp.hijo2 != null){
                t += temp.ID + "->" + temp.hijo2.ID + "[minlen=2 ];\n";
            }
        }
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
    
    public void dibujar(){
        try{
            String ruta = "Reportes/ARBOLES_201909035/"+this.ID+".txt";
            String gname = "Reportes/ARBOLES_201909035/"+this.ID+".png";
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
