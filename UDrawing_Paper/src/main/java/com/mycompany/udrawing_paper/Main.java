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
    }
}
