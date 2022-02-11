/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.udrawing_paper;

/**
 *
 * @author JJONK19
 */
public class Main {
    
    
    public static void main(String[] args){
        Main.prueba();
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
