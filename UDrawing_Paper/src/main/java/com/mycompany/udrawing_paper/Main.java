/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.udrawing_paper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author JJONK19
 */
public class Main {
    static int carga = 0; //Bandera que indica si ya se cargó la información
    static int ventanas = 0; //Guarda el número de ventanillas. Si el usuario asigna 0 o no lo hace, muestra error.
    Cola Clientes = new Cola(); //Cola de Clientes que entran a la empresa
    ListaPilas Ventanilla = new ListaPilas(); //Ventanillas de la empresa
    ListaSimple Atendidos = new ListaSimple();
    Cola BN = new Cola(); //Impresora en blanco y negro
    Cola C = new Cola(); //Impresora a color
    ListaDCircularL Espera = new ListaDCircularL(); //Lista de Clientes esperando
    
    
    
    public static void main(String[] args){
        String x = "";
        Scanner a = new Scanner(System.in);
        while(!"0".equals(x)){
            System.out.println("UDrawing Paper");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Paraametros Iniciales");
            System.out.println("2. Ejecutar Paso");
            System.out.println("3. Estado en memoría de las estructuras");
            System.out.println("4. Reportes");
            System.out.println("5. Acerca de");
            System.out.println("0. Salir");
            System.out.println("---------------------------------------------------------");
            System.out.println("Ingrese el número de una instrucción:");
            x = String.valueOf(a.nextLine());  
            System.out.println("---------------------------------------------------------");
            
            //Carga y Definición de Datos Iniciales***********************************************
            if ("1".equals(x)){
                String x1 = "";
                while(!"0".equals(x1)){
                    System.out.println("UDrawing Paper");
                    System.out.println("PARAMETROS INICIALES");
                    System.out.println("1. Carga de Clientes");
                    System.out.println("2. Definir número de ventanillas");
                    System.out.println("0. Salir");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Ingrese el número de una instrucción:");
                    x1 = String.valueOf(a.nextLine());  
                    System.out.println("---------------------------------------------------------");
                    
                    //Carga de datos
                    if ("1".equals(x1)){
                        try{
                            Scanner a1 = new Scanner(System.in);
                            String ruta;
                            System.out.println("Ingrese la ruta del archivo:");
                            ruta = a1.nextLine();  
                            File file = new File(ruta);
                            Scanner input = new Scanner(file);
                            String txt = "";
                            while(input.hasNextLine()){
                                txt += input.nextLine();
                            }
                            
                            
                        }catch(Exception e){
                            System.out.println("");
                            System.out.println("ERROR: No se pudo leer el archivo de carga.");
                            System.out.println("");
                            System.out.println("---------------------------------------------------------");
                        }
                    }

                    //Número de Ventanillas
                    if ("2".equals(x1)){
                        System.out.println("Ingrese el número de ventanillas a manejar:");
                        ventanas = a.nextInt();  
                        System.out.println("---------------------------------------------------------");
                        System.out.println("");
                        System.out.println("MENSAJE: Número de ventanillas actualizado.");
                        System.out.println("");
                        System.out.println("---------------------------------------------------------");
                    }  
                } 
            }
            
            if ("2".equals(x)){
                System.out.println("Funciona");
            }
            
            if ("3".equals(x)){
                System.out.println("Funciona");
            }
            
            if ("4".equals(x)){
                System.out.println("Funciona");
            }
            
            if ("5".equals(x)){
                System.out.println("ESTRUCTURAS DE DATOS SECCIÓN C");
                System.out.println("Josué Javier Aguilar López");
                System.out.println("201909035");
                System.out.println("---------------------------------------------------------");
            }
           
            
        }
    }
    
    //Metodo de ejemplo para usar estructuras
    public static void prueba(){
        //Ejemplo de como se debe de craer una cola
        Cola a = new Cola();
        a.enqueue(1, "Uno");
        a.enqueue(2, "Dos");
        a.enqueue(3, "Tres");
        a.dequeue();
        a.dibujar("Cola.txt", "Cola.png");
        
        //Ejemplo para crear una pila
        Pila b = new Pila();
        b.push(1, "Uno");
        b.push(2, "Dos");
        b.push(3, "Tres");
        b.pop();
        b.dibujar("Pila.txt", "Pila.png");
        
        //Ejemplo para crear una pila
        Pila b1 = new Pila();
        b1.push(1, "Uno");
        b1.push(2, "Dos");
        b1.push(3, "Tres");
        b1.pop();
        
        
        //Ejemplo para crear una pila
        Pila b2 = new Pila();
        b2.push(1, "Uno");
        b2.push(2, "Dos");
        b2.push(3, "Tres");
        b2.pop();
        
        //Ejemplo para crear una pila
        Pila b3 = new Pila();
        b3.push(1, "Uno");
        b3.push(2, "Dos");
        b3.push(3, "Tres");
        b3.push(4, "Hola");
        b3.push(5, "Cinco");
        b3.push(6, "Seis");
        b3.push(7, "Patata");
        
        //Ejemplo de una lista simple
        ListaSimple c = new ListaSimple();
        c.add(1, "Uno");
        c.add(2, "Dos");
        c.add(3, "Tres");
        c.dibujar("Lista.txt", "Lista.png");
        
        //Ejemplo de una lista simple
        ListaSimple c1 = new ListaSimple();
        c1.add(1, "UNO");
        c1.add(2, "DOS");
        c1.add(3, "TRES");
        c1.dibujar("Lista1.txt", "Lista1.png");
        
        //Ejemplo de una lista simple
        ListaSimple c2 = new ListaSimple();
        c2.add(1, "UNO");
        c2.add(2, "DOS");
        c2.add(3, "TRES");
        c2.dibujar("Lista2.txt", "Lista3.png");
        
        ListaSimple c3 = new ListaSimple();
        c3.add(1, "UNO");
        c3.add(2, "DOS");
        c3.add(3, "TRES");
       
        //Ejemplo de Lista de Listas
        ListaDCircularL d = new ListaDCircularL();
        d.add(c, "Números");
        d.add(c1, "Texto");
        d.add(c2, "Hola");
        d.add(c3, "Pedro");
        d.dibujar("DLC.txt", "DLC.png");
        
        //Ejemplo de una lista de pilas
        ListaPilas e = new ListaPilas();
        e.add(b, "UNI");
        e.add(b1, "Pueblos");
        e.add(b3, "Caballos");
        e.add(b2, "Rancho");
        e.dibujar("PL.txt", "PL.png");
    }
}
