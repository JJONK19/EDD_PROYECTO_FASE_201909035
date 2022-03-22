/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author JJONK19
 */
public class Prueba {
    
    public static void main(String[]args){
        //Prueba de Matriz dispersa
        /*
        Matriz a = new Matriz();
        a.add(0, 0, "Adios");
        a.add(1, 1, "Hola");
        a.add(2, 2, "Hola");
        a.add(3, 3, "Hola");
        a.add(3, 0, "Hola");
        a.dibujar("C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\matriz.txt", "C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\matriz.png");
        */
        
        //Prueba de AVL 
        ArbolAVL a = new ArbolAVL();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        a.add(10);
        a.delete(9);
        a.delete(6);
        a.delete(8);
        a.delete(7);
        a.add(11);
        a.add(12);
        a.add(7);
        a.delete(1);
        a.delete(3);
        a.delete(10);
        a.delete(12);
        a.delete(11);
        
        
       
        
   
        a.dibujar("C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\AVL.txt", "C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\AVL.png");
}
    
}
