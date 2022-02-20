/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.udrawing_paper;

import java.io.File;
import  com.jayway.jsonpath.JsonPath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;


/**
 *
 * @author JJONK19
 */
public class Main {
    static int carga = 0; //Bandera que indica si ya se cargó la información
    static int ventanas = 0; // Guarda el número de ventanillas. Si el usuario asigna 0 o no lo hace, muestra error.
    static Cola Clientes = new Cola(); //G Cola de Clientes que entran a la empresa
    static ListaPilas Ventanilla = new ListaPilas(); //G Ventanillas de la empresa
    static ListaSimple Atendidos = new ListaSimple(); //Lista de Clientes atendidos
    static Cola BN = new Cola(); //Impresora en blanco y negro
    static Cola C = new Cola(); //Impresora a color
    static ListaDCircularL Espera = new ListaDCircularL(); //Lista de Clientes esperando
    static String[] Nombres = new String []{"Olivia", "Emma", "Ava", "Charlotte", "Sophia", "Amelia", "Isabella", "Mia", "Evelyn", "Harper", "Camila", "Gianna", "Abigail", "Luna", "Ella", "Elizabeth", "Emily", "Avery", "Mila", "Scarlett", "Eleanor", "Madison", "Layla", "Penelope", "Aria", "Chloe", "Grace", "Ellie", "Nora", "Zoey", "Liam", "Noah", "Oliver", "Elijah", "William", "James", "Benjamin", "Lucas", "Henry", "Alexander", "Mason", "Michael", "Ethan", "Daniel", "Jacob", "Logan", "Jackson", "Levi", "Sebastian", "Mateo", "Jack", "Owen", "Theodore", "Aiden", "Samuel", "Joseph", "John", "David", "Luke", "Asher" };
    static String[] Apellidos = new String []{"Smith", "Johnson", "Martin", "Wright", "Thompson", "Lopez", "Williams", "Garcia", "Hill", "Jones", "Martibnez", "Scott", "Brown", "Robinson", "Green", "Davis", "Clark", "Adams", "Miller", "Rodriguez", "Baker", "Wilson", "Lewis", "Gonzalez", "Moore", "Lee", "Nelson", "Taylor", "Walker", "Carter", "Anderson", "Hall", "Mitchell", "Thomas", "Allen", "Perez", "Jackson", "Young", "Roberts", "White", "Hernandez", "Turner", "Harris", "King", "Phillips", "Parker", "Campbell", "Ward", "Gray", "Long", "Flores", "Foster", "Perry", "Sanchez", "Butler", "Morris", "Cook", "Ross", "Murphy"};
    
    
    public static void main(String[] args){
        String x = "";
        int conC = 0;  //Indica cuantos pasos llevva la impresión a color 
        int conB = 0;  //Indica cuantos pasos llevva la impresión a BN 
        int pasos = 1; //Contador de pasos ejecutados
        //Inicialización de grafos
        Atendidos.add(null, "Vacio");
        BN.enqueue(null, "Libre");
        C.enqueue(null, "Libre");
        ListaSimple lt = new ListaSimple();
        lt.add(null, "Vacio");
        Espera.add(lt, "Vacio", null);
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
                    System.out.println("0. Regresar");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Ingrese el número de una instrucción:");
                    x1 = String.valueOf(a.nextLine());  
                    System.out.println("---------------------------------------------------------");
                    
                    //Carga de datos
                    if ("1".equals(x1)){ 
                        try{
                            Clientes.deleteL();
                            Scanner a1 = new Scanner(System.in);
                            String ruta;
                            System.out.println("Ingrese la ruta del archivo:");
                            ruta = a1.nextLine();  
                            
                            //Aplicación de la libreria: https://stackoverflow.com/questions/55976047/extracting-objects-from-an-array-with-jackson-streaming-api
                            //Compilador de prueba para JSONPath: http://jsonpath.com/
                            File json = new File(ruta).getAbsoluteFile();
                            List<Map> clientes = JsonPath.parse(json).read("$.*"); //Al leer, guarda las coincnidencias como un diccionario y esos los guarda en la lista
                            for (int i =0; i<clientes.size();i++){
                                
                                //Lectura de los diccionarios
                                Map temp = clientes.get(i);
                                String id = (String)temp.get("id_cliente");
                                String nom = (String) temp.get("nombre_cliente");
                                int col = Integer.parseInt((String)temp.get("img_color"));
                                int bn = Integer.parseInt((String)temp.get("img_bw"));
                                
                                //Creacion del objeto cliente
                                Cliente c = new Cliente(id, nom, col, bn);
                                
                                //Añadirlos a la cola inicial
                                Clientes.enqueue(c, nom);
                              
                            }
                            carga = 1;
                            
                            System.out.println("");
                            System.out.println("MENSAJE: Información cargada correctamente.");
                            System.out.println("");
                            System.out.println("---------------------------------------------------------");

                        }catch(Exception e){
                            System.out.println("");
                            System.out.println("ERROR: No se pudo leer el archivo de carga.");
                            System.out.println("---------------------------------------------------------");
                        }
                    }

                    //Número de Ventanillas
                    if ("2".equals(x1)){
                        System.out.println("Ingrese el número de ventanillas a manejar:");
                        try{
                            ventanas = a.nextInt();
                            a.nextLine();
                            Pila [] prueba = new Pila[ventanas];
                            String [] ab = new String[ventanas];
                            String n;
                            for(int i = 0; i < ventanas; i++){
                                prueba[i] = new Pila();
                                prueba[i].push(null, "Libre");
                                ab[i] = "Ventanilla_" + Integer.toString(i+1);
                        }
                      
                        for(int i = 0; i < ventanas; i++){ 
                            Ventanilla.add(prueba[i], ab[i]);
                        }
                        }catch(Exception e){
                            
                        }
                        
                        System.out.println("---------------------------------------------------------");
                        System.out.println("");
                        System.out.println("MENSAJE: Número de ventanillas actualizado.");
                        System.out.println("");
                        System.out.println("---------------------------------------------------------");
                    }  
                } 
            }
            
            
            //Siguiente Paso********************************************************************
            if ("2".equals(x)){
                if( carga == 0 || ventanas == 0 ){
                    System.out.println("");
                    System.out.println("ERROR: Debe cargar la infromación y definir la cantidad de ventanillas antes de proceder.");
                    System.out.println("");
                    System.out.println("---------------------------------------------------------");
                }else{
                    System.out.println("*********************************************************");
                    System.out.println("                   RESUMEN DEL PASO " + Integer.toString(pasos));
                    System.out.println("*********************************************************");
                    pasos++;
                    
                //Manejo de la Cola------------------------------------------------------------
                    //Inicializar cola
                    NodoCola tcc = Clientes.head;
                    if(tcc.name.equals("Vacio")){
                        Clientes.deleteL();
                    }
                            
                    //Añadir clientes nuevos
                    Random r = new Random();
                    int nuevos = r.nextInt(4);
                    for(int i = 0; i < nuevos+1; i++){
                        String nombre = Nombres[r.nextInt(Nombres.length)];
                        String apellido = Apellidos[r.nextInt(Apellidos.length)];
                        String NA = nombre + " " + apellido;
                        String ID = UUID.randomUUID().toString();
                        int bnc = r.nextInt(5);
                        int cc = r.nextInt(5);
                        Cliente c = new Cliente(ID, NA, bnc, cc);
                        Clientes.enqueue(c, NA);    
                        System.out.println(NA + " entra a la empresa.");
                    }

                //Manejo de las Ventanillas-----------------------------------------------------
                    //Vaciar espacios
                    NodoListaPilas temp = Ventanilla.head;
                    System.out.println("");
                    for(int i = 0; i < Ventanilla.no; i++){

                        if(temp.content != null){   //Está llena
                            Cliente ct = (Cliente)temp.content;
                            int sub = ct.bn + ct.color;     //Imagenes que el cliente no ha procesado

                            if(sub == 0){                           //Sacar Cliente de la ventanilla
                                ct.ventana = temp.name;
                                ct.pasos++;

                                //Inicializa la lista´para poder añadir clientes 
                                NodoListaDobleCircular tes = Espera.head;
                                if(tes.name.equals("Vacio")){
                                    Espera.deleteL();
                                }

                                //Añade al cliente a la lista
                                ListaSimple tsi = new ListaSimple();
                                tsi.add(null, "Vacio");
                                
                                Espera.add(tsi, "\"" + ct.nombre + "\"", ct);
                                System.out.println(ct.nombre + " entra en la lista de espera.");

                                //Sacar al cliente de la ventanilla
                                temp.content = null;

                                //Vaciar Pila de imagenes
                                Pila pt = (Pila)temp.structure;
                                while(pt.head != null){
                                    Imagen it = (Imagen)pt.pop();
                                    if(it.Tipo.equals("Color")){
                                        //Inicializar Impresoras
                                        NodoCola tbn = BN.head;
                                        tbn = C.head;
                                        if(tbn.name.equals("Libre")){
                                            C.deleteL();
                                        }
                                        C.enqueue(it, it.Nombre);
                                    }else{
                                        //Inicializar Impresoras 
                                        NodoCola tbn = BN.head;
                                        if(tbn.name.equals("Libre")){
                                            BN.deleteL();
                                        }
                                        BN.enqueue(it, it.Nombre);
                                    }
                                }
                                System.out.println("Las " + Integer.toString(ct.total) +" imagenes de " + ct.nombre + " son enviadas a las colas de impresión.");

                                //Reiniciar Pila de Imagenes
                                 pt.push(null, "Libre");

                            }else{                                  //Añadir una imagen del cliente en la pila
                                if(ct.bn != 0){
                                    String nombre = ct.nombre + " - " +Integer.toString(sub);
                                    Pila t = (Pila)temp.structure;
                                    t.push(new Imagen(ct.ID, nombre, "BN"), nombre);
                                    ct.bn--;
                                    ct.pasos++;
                                    System.out.println(ct.nombre + " registra una imagen en blanco y negro.");
                                }else{
                                    String nombre = ct.nombre + " - " +Integer.toString(sub);
                                    Pila t = (Pila)temp.structure;
                                    t.push(new Imagen(ct.ID, nombre, "Color"), nombre);
                                    ct.color--;
                                    ct.pasos++;
                                    System.out.println(ct.nombre + " registra una imagen a color.");
                                }
                            }
                        }           
                        temp = temp.next;
                    }

                    //Añadir Clientes a las ventanillas vacias
                    System.out.println("");
                    temp = Ventanilla.head;
                    for(int i = 0; i < Ventanilla.no; i++){
                        //Verificar si la cola está vacia  
                        tcc = Clientes.head;
                        if(tcc == null){
                            Clientes.enqueue(null, "Vacio");
                            break;
                        }

                        if(temp.content == null){   //Está vacía
                            //Inicializar Pila de Imagenes borrando nodo libre
                            Pila t = (Pila)temp.structure;
                            t.deleteP();
                            
                            //Ingresar Cliente a la ventanilla
                            Cliente ct = (Cliente)Clientes.dequeue();
                            int sub = ct.bn + ct.color;     //Imagenes que el cliente no ha procesado
                            temp.content = ct;
                            System.out.println(ct.nombre + " sale de la cola y se mueve a " + temp.name +".");
                            
                            //Ingresar imagen a la pila
                            if(ct.bn != 0){
                                String nombre = ct.nombre + " - " +Integer.toString(sub);
                                t.push(new Imagen(ct.ID, nombre, "BN"), nombre);
                                ct.bn--;
                                ct.pasos++;
                                System.out.println(ct.nombre + " registra una imagen en blanco y negro.");
                            }else{
                                String nombre = ct.nombre + " - " +Integer.toString(sub);
                                t.push(new Imagen(ct.ID, nombre, "Color"), nombre);
                                ct.color--;
                                ct.pasos++;
                                System.out.println(ct.nombre + " registra una imagen a color.");
                            }
                        }      
                        temp = temp.next;
                    }
                    //Verificar si la cola está vacia  
                    tcc = Clientes.head;
                    if(tcc == null){
                        Clientes.enqueue(null, "Vacio");
                    }
                    
                    //Sumar un paso a cada cliente que queda
                    tcc = Clientes.head;
                    if(tcc == null){
                    }else{
                        while(tcc.next != null){
                            Cliente ct = (Cliente)tcc.content;
                            ct.pasos++;
                            tcc = tcc.next;
                        }
                    }
                 
                    
                //Manejo de las impresoras------------------------------------------------------------
                  //Impresora Blanco y Negro
                  System.out.println("");
                    //Sacar Imagen
                    NodoCola tbn = BN.head;
                    if(tbn.name.equals("Libre")){
                        
                    }else{
                        if (conB == 0){
                            if(!(tbn.name.equals("Libre"))){
                                Imagen it = (Imagen)BN.dequeue();
                                int index = Espera.find(it.ID);
                                NodoListaDobleCircular finder = Espera.head;
                                for(int i = 0; i < index; i++){
                                    finder = finder.next;
                                }

                                ListaSimple finlis = (ListaSimple)finder.structure;
                                if (finlis.head.name.equals("Vacio")){
                                    finlis.deleteL();
                                }
                                finlis.add(it, "\"" + it.Nombre + "\"");
                                Cliente ct = (Cliente)finder.content;
                                ct.total--;
                                System.out.println("Se ha impreso " + it.Nombre + ".");
                                conB = 0;
                            }
                        }else{
                            
                        }
                    }
                    
                    
                    //Reiniciar Impresora
                    tcc = BN.head;
                    if(tcc == null){
                        BN.enqueue(null, "Libre");
                    }
                    
                  //Impresora a color
                    System.out.println("");
                    //Sacar Imagen
                    tbn = C.head;
                    if(tbn.name.equals("Libre")){
                        
                    }else{
                        if (conC == 1){
                            if(!(tbn.name.equals("Libre"))){
                                Imagen it = (Imagen)C.dequeue();
                                int index = Espera.find(it.ID);
                                NodoListaDobleCircular finder = Espera.head;
                                for(int i = 0; i < index; i++){
                                    finder = finder.next;
                                }

                                ListaSimple finlis = (ListaSimple)finder.structure;
                                if (finlis.head.name.equals("Vacio")){
                                    finlis.deleteL();
                                }
                                finlis.add(it, "\"" + it.Nombre + "\"");
                                Cliente ct = (Cliente)finder.content;
                                ct.total--;
                                System.out.println("Se ha impreso " + it.Nombre + ".");
                                conC = 0;
                            }
                        }else{
                            conC = conC + 1 ;
                        }
                    }
                    
                                        
                    //Reiniciar Impresora
                    tcc = C.head;
                    if(tcc == null){
                        C.enqueue(null, "Libre");
                    }
                    
                //Manejo de Clientes en Espera------------------------------------------------------
                    System.out.println("");
                    //Verificación de Imagenes
                    NodoListaDobleCircular finder = Espera.head;
                    int iterador = Espera.no;
                    if(!finder.name.equals("Vacio")){
                        
                        //Inicializar Lista atendidos
                        NodoListaSimple lf = Atendidos.head;
                        if(lf == null){
                            
                        }else{
                            if(lf.name.equals("Vacio")){
                            Atendidos.deleteL();
                            }
                        }
                     
                        for(int i = 0; i < iterador; i++){
                            Cliente ct = (Cliente)finder.content;
                            if (ct.total == 0){
                                Atendidos.add(ct, "\"" + ct.nombre + "\"" );
                                System.out.println(ct.nombre + " se ha retirado del establecimiento.");
                                System.out.println("Pasos de " + ct.nombre + ": " + Integer.toString(ct.pasos));
                                System.out.println("");
                                Espera.remove(i);
                            }else{
                                ct.pasos++;
                            }
                            finder = finder.next;
                        }
                    }
                    
                    //Reinicio de Lista
                    NodoListaDobleCircular tcd = Espera.head;
                    if(tcd == null){
                        ListaSimple lt1 = new ListaSimple();
                        lt1.add(null, "Vacio");
                        Espera.add(lt, "Vacio", null);
                    }   
                    
                //FIN DEL PROCESO
                    System.out.println("---------------------------------------------------------");
                }
            }
                
                
            //Mostrar Estructuras***************************************************************
            if ("3".equals(x)){
                if( carga == 0 || ventanas == 0 ){
                    System.out.println("");
                    System.out.println("ERROR: Debe cargar la infromación y definir la cantidad de ventanillas antes de proceder.");
                    System.out.println("");
                    System.out.println("---------------------------------------------------------");
                }else{
                    
                    Clientes.dibujar("Estructuras\\Cola Clientes.txt", "Estructuras\\Cola Clientes.png");
                    Ventanilla.dibujar("Estructuras\\Ventanillas.txt", "Estructuras\\Ventanillas.png");
                    Atendidos.dibujar("Estructuras\\Clientes atendidos.txt", "Estructuras\\Clientes Atendidos.png");
                    BN.dibujar("Estructuras\\Fotocopiadora BN.txt", "Estructuras\\Fotocopiadora BN.png");
                    C.dibujar("Estructuras\\Fotocopiadora Color.txt", "Estructuras\\Fotocopiadora Color.png");
                    Espera.dibujar("Estructuras\\Clientes esperando.txt", "Estructuras\\Clientes esperando.png");
                    System.out.println("");
                    System.out.println("MENSAJE: Estrcturas actualizadas. Revise la carpeta estructuras dentro del proyecto.");
                    System.out.println("");
                    System.out.println("---------------------------------------------------------");
                }
            }
            
            
            //Reportes**************************************************************************
            if ("4".equals(x)){
                if( carga == 0 || ventanas == 0 ){
                    System.out.println("");
                    System.out.println("ERROR: Debe cargar la infromación y definir la cantidad de ventanillas antes de proceder.");
                    System.out.println("");
                    System.out.println("---------------------------------------------------------");
                }else{
                    //Inicializar Lista atendidos
                    NodoListaSimple lf = Atendidos.head;
                    if(lf == null){
                            
                    }else{
                        if(lf.name.equals("Vacio")){
                            System.out.println("");
                            System.out.println("ERROR: No hay clientes que hayan salido de la organización.");
                            System.out.println("");
                            System.out.println("---------------------------------------------------------");
                        }else{
                            
                            String x1 = "";
                            while(!"0".equals(x1)){
                                System.out.println("UDrawing Paper");
                                System.out.println("REPORTES");
                                System.out.println("1. Cliente con mayor cantidad de Impresiones a color");
                                System.out.println("2. Cliente con mayor cantidad de Impresiones en Blanco y Negro");
                                System.out.println("3. Cliente con mayor número de pasos");
                                System.out.println("4. Buscar Cliente");
                                System.out.println("0. Regresar");
                                System.out.println("---------------------------------------------------------");
                                System.out.println("Ingrese el número de una instrucción:");
                                x1 = String.valueOf(a.nextLine());  
                                System.out.println("---------------------------------------------------------");

                                //Cliente con mayor cantidad de imagenes a color
                                if ("1".equals(x1)){
                                    System.out.println("*********************************************************");
                                    System.out.println("                TOP 5 - IMAGENES A COLOR ");
                                    System.out.println("*********************************************************");
                                    for (int i = 0; i < Atendidos.no-1; i++){
                                        NodoListaSimple o1 = Atendidos.head;
                                        NodoListaSimple o2 = o1.next;
                                        for (int j = 0; j < Atendidos.no-1; j++){
                                            Cliente to1 = (Cliente)o1.content;
                                            Cliente to2 = (Cliente)o2.content;
                                            int con1 = (int)to1.tc;
                                            int con2 = (int)to2.tc;
                                            if (con1 < con2)
                                            {
                                                Cliente tp = to1;
                                                o1.content = o2.content;
                                                o2.content = tp;
                                            }
                                            o1 = o1.next;
                                            o2 = o2.next;
                                        }
                                    }

                                    int iterador = Atendidos.no;
                                    if(iterador > 5){
                                        iterador = 5;
                                    }
                                    
                                    NodoListaSimple o1 = Atendidos.head;
                                    for(int i = 0; i < iterador; i++){
                                        Cliente temp = (Cliente)o1.content;
                                        System.out.println(Integer.toString(i + 1) + ". " + temp.nombre + " - Imagenes Impresas a Color: " + temp.tc);
                                        o1 = o1.next;
                                    }
                                    System.out.println("");
                                    System.out.println("---------------------------------------------------------");
                                }

                                //Cliente con mayor cantidad de imagenes en blanco y negro
                                if ("2".equals(x1)){
                                    System.out.println("*********************************************************");
                                    System.out.println("                TOP 5 - IMAGENES EN BN ");
                                    System.out.println("*********************************************************");
                                    for (int i = 0; i < Atendidos.no-1; i++){
                                        NodoListaSimple o1 = Atendidos.head;
                                        NodoListaSimple o2 = o1.next;
                                        for (int j = 0; j < Atendidos.no-1; j++){
                                            Cliente to1 = (Cliente)o1.content;
                                            Cliente to2 = (Cliente)o2.content;
                                            int con1 = (int)to1.tn;
                                            int con2 = (int)to2.tn;
                                            if (con1 < con2)
                                            {
                                                Cliente tp = to1;
                                                o1.content = o2.content;
                                                o2.content = tp;
                                            }
                                            o1 = o1.next;
                                            o2 = o2.next;
                                        }
                                    }

                                    int iterador = Atendidos.no;
                                    if(iterador > 5){
                                        iterador = 5;
                                    }
                                    
                                    NodoListaSimple o1 = Atendidos.head;
                                    for(int i = 0; i < iterador; i++){
                                        Cliente temp = (Cliente)o1.content;
                                        System.out.println(Integer.toString(i + 1) + ". " + temp.nombre + " - Imagenes Impresas en Blanco y Negro: " + temp.tn);
                                        o1 = o1.next;
                                    }
                                    System.out.println("");
                                    System.out.println("---------------------------------------------------------");

                                }

                                //Cliente con mayor número de pasos
                                if ("3".equals(x1)){
                                    System.out.println("*********************************************************");
                                    System.out.println("                CLIENTE CON MÁS PASOS");
                                    System.out.println("*********************************************************");
                                    for (int i = 0; i < Atendidos.no-1; i++){
                                        NodoListaSimple o1 = Atendidos.head;
                                        NodoListaSimple o2 = o1.next;
                                        for (int j = 0; j < Atendidos.no-1; j++){
                                            Cliente to1 = (Cliente)o1.content;
                                            Cliente to2 = (Cliente)o2.content;
                                            int con1 = (int)to1.tn;
                                            int con2 = (int)to2.tn;
                                            if (con1 < con2)
                                            {
                                                Cliente tp = to1;
                                                o1.content = o2.content;
                                                o2.content = tp;
                                            }
                                            o1 = o1.next;
                                            o2 = o2.next;
                                        }
                                    }
                                    Cliente temp = (Cliente)Atendidos.head.content;
         
                                    System.out.println(temp.nombre + " estuvo más tiempo en la empresa con la cantidad de " + Integer.toString(temp.pasos) + " pasos." );
                                    System.out.println("");
                                    System.out.println("---------------------------------------------------------");
                                }

                                //Buscar Cliente
                                if ("4".equals(x1)){
                                    Scanner a1 = new Scanner(System.in);
                                    String cliente;
                                    System.out.println("Ingrese el nombre del cliente:");
                                    cliente = a1.nextLine();

                                    NodoListaSimple to = Atendidos.head;
                                    for ( int i = 0; i < Atendidos.no; i++){
                                        Cliente ct = (Cliente)to.content;
                                        if(cliente.equals(ct.nombre)){
                                            System.out.println("*********************************************************");
                                            System.out.println("                 RESULTADOS DE BUSQUEDA ");
                                            System.out.println("*********************************************************");
                                            System.out.println("ID                    : " + ct.ID);
                                            System.out.println("NOMBRE                : " + ct.nombre);
                                            System.out.println("VENTANA QUE LO ATENDIÓ: " + ct.ventana);
                                            System.out.println("IMAGENES A COLOR      : " + Integer.toString(ct.tc));
                                            System.out.println("IMAGENES EN BN        : " + Integer.toString(ct.tn));
                                            System.out.println("PASOS EN EL SISTEMA   : " + Integer.toString(ct.pasos));
                                            System.out.println("");
                                            System.out.println("---------------------------------------------------------");
                                            break;
                                        }
                                        to = to.next;
                                    } 
                                }

                            }
                            
                        }
                    }
                }
            }
            
            
            //Acerca de************************************************************************
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
        
        
        //Ejemplo para crear una pila
        Pila b = new Pila();
        b.push(1, "Uno");
        b.push(2, "Dos");
        b.push(3, "Tres");
        b.pop();
        
        
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
        c.remove(0);
        c.dibujar("Prueba.txt", "Prueba.png");
        
        
        //Ejemplo de una lista simple
        ListaSimple c1 = new ListaSimple();
        c1.add(1, "UNO");
        c1.add(2, "DOS");
        c1.add(3, "TRES");
        
        
        //Ejemplo de una lista simple
        ListaSimple c2 = new ListaSimple();
        c2.add(1, "UNO");
        c2.add(2, "DOS");
        c2.add(3, "TRES");
        
        
        ListaSimple c3 = new ListaSimple();
        c3.add(1, "UNO");
        c3.add(2, "DOS");
        c3.add(3, "TRES");
       
        //Ejemplo de Lista de Listas
        ListaDCircularL d = new ListaDCircularL();
        d.add(c, "Números", null);
        
        
        //Ejemplo de una lista de pilas
        ListaPilas e = new ListaPilas();
        e.add(b, "UNI");
        e.add(b1, "Pueblos");
        e.add(b3, "Caballos");
        e.add(b2, "Rancho");
        
    }
}
