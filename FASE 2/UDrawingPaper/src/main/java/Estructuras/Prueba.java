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
        
        //Prueba de AVL 75,40,23,8,6,37,32,45,25,1,88,29,4,11,39,14,66,24,12,7 
        ArbolAVL a = new ArbolAVL();
        a.add(75);
        a.add(40);
        a.add(23);
        a.add(8);
        a.add(6);
        a.add(37);
        a.add(32);
        a.add(45);
        a.add(25);
        a.add(1);
        a.add(88);
        a.add(29);
        a.add(4);
        a.add(11);
        a.add(39);
        a.add(14);
        a.add(66);
        a.add(24);
        a.add(12);
        a.add(7);
        a.add(75);
        
   
        a.dibujar("C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\AVL.txt", "C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\AVL.png");
}
    
}
