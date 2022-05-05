/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author JJONK19
 */
//Tabla solo para emnsajeros
public class TablaHash implements Serializable {
    
    NodoHash[] bucket;
    int tamaño;
    int uso;
    
    public TablaHash(){
        bucket = new NodoHash[37];
        tamaño = 37;
        uso = 0;
    }
    
    //Añade un Valor a la tabla
    public void add(Mensajero a){
        //Añadir al bucket
        int posicion = hash(a.dpi);
        //Revisar si el indice no se sale de la tabla
        if(posicion > (tamaño -1)){
           boolean ban = true;
                int i = 1;
                //Iterar la creacion de un nuevo hash hasta que entre
                while(ban){
                    posicion = colision(a.dpi, i);
                    if(posicion > (tamaño - 1)){
                        ban = false;
                        System.out.println(a.dpi + " genera un hash superior al tamaño");
                    }else{
                        NodoHash check = bucket[posicion];
                        if(check == null){
                            //Añadir a la posicion
                            bucket[posicion] = new NodoHash(a, posicion);
                            tamaño++;
                             ban = false;
                        }
                }
            }
        }else{
            NodoHash check = bucket[posicion];
            if(check == null){
                //Añadir a la posicion
                bucket[posicion] = new NodoHash(a, posicion);
                tamaño++;
            }else{
                //Revisar si no viene repetido. 
                //Si es diferente se tiene que resolbver la colision.
                if(a.dpi.compareTo(check.content.dpi) != 0){
                    boolean ban = true;
                    int i = 1;
                    //Iterar la creacion de un nuevo hash hasta que entre o salga porque el tamaño es grande
                    while(ban){
                        posicion = colision(a.dpi, i);
                        if(posicion > (tamaño - 1)){
                            ban = false;
                            System.out.println(a.dpi + " genera un hash superior al tamaño");
                        }else{
                            check = bucket[posicion];
                            if(check == null){
                                //Añadir a la posicion
                                bucket[posicion] = new NodoHash(a, posicion);
                                tamaño++;
                                ban = false;
                            }
                        }
                    }
                }
            }
        }
        
        //Verificar el tamaño para hacer rehash
        if(uso() > 0.75){
            //Actualizar el tamaño
            tamaño = primo(tamaño);
            NodoHash[] bt = new NodoHash[tamaño];
            
            //Recorrer de nuevo la lista y aplicar rehash
        }
    }
    
    //Retorna un Valor de la tabla
    public void find(){
        
    }
    
    //Retorna el porcentaje de uso en la tabla
    public int uso(){
        return uso/tamaño;
    }
    
    //Retorna el indice de la tabla
    public int hash(BigInteger a){
        BigInteger tam = new BigInteger(Integer.toString(tamaño));
        BigInteger hash = a.mod(tam);
        String temp = hash.toString();
        int salida = Integer.parseInt(temp);
        return salida;
    }
    
    //Maneja las colisiones
    public int colision(BigInteger a, int colision){
        BigInteger col = new BigInteger(Integer.toString(colision));
        BigInteger siete = new BigInteger(Integer.toString(7));
        BigInteger uno = new BigInteger(Integer.toString(1));
        BigInteger hash = (a.mod(siete).add(uno)).multiply(col) ;
        String temp = hash.toString();
        int salida = Integer.parseInt(temp);
        return salida;
    }
    
    
    //Retorna el primo siguiente al tamaño actual
    //Basado = https://www.javatpoint.com/prime-number-program-in-java
    public int primo(int a){
    int i = 0;
    int m = 0;
    int flag = 0;    
    int n = a + 1;      
    boolean ban = true;
    
    while(ban){
        flag = 0;
        m = n / 2;    
        if(n==0||n==1){
            n++;
        }else{
            for(i = 2;i <= m; i++){    
              if(n % i == 0){    
                n++;   
                flag = 1;
               break;    
              }    
            }    
            if(flag == 0){ 
                ban = false; 
            }
        }
    }    
        return n;
    }
    
    //Actualiza el tamaño de la tabla así como sus posiciones
    public void rehash(){
        
    }
    
    //Metodos de Graficación
    //--------------------------------------------------------------------------
    
    public String declare(){
        String x = "";
        for(int i = 0; i < bucket.length; i++){
           NodoHash temp = bucket[i]; 
           if(temp == null){
               x += "A" + i  + "[fontsize = 25 height = 2 width = 4 shape = box label=\""+ i + "\"]\n";
           }else{
                x += temp.ID + "[fontsize = 25 height = 2 width = 4 shape = box label=\""+ temp.content.nombre + " " + temp.content.apellido + "\n" + temp.content.dpi + "\n" + temp.content.dir + "\"]\n";
           }
        }
        return x;
    }
    
    //Crea las conexiones entre los nodos que van a ir en el archivo del grafo
    public String connect(){
        String x = "";
        for(int i = 0; i < (bucket.length); i++){
           NodoHash temp = bucket[i];
           if(temp == null){
                if(i != (bucket.length - 1)){
                    NodoHash tem = bucket[i + 1];
                    if(tem == null){
                        x += "A" + i + "->" + "A" + (i+1) + "\n";
                    }else{
                         x += "A" + i + "->" + tem.ID + "\n";
                    }
                }
           }else{
               if(i != (bucket.length - 1)){
                    NodoHash tem = bucket[i + 1];
                    if(tem == null){
                        x += temp.ID + "->" + "A" + (i+1) + "\n";
                    }else{
                         x += temp.ID + "->" + tem.ID + "\n";
                    }
                }
           }
        }
        return x;
    }
    
    public String getcodigo(){
        String t = "digraph G\n" +"{\n";
        t += "\t" + declare()+ connect();
        
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
