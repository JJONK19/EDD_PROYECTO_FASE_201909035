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
       
        a.add(1, 1, "#0B1FCB");
        a.add(2, 2, "#0B1FCB");
        a.add(3, 3, "#0B1FCB");
        a.add(3, 0, "#0B1FCB");
        
       a.add(3, 3, "#000000");
        a.dibujar("C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\matriz.txt", "C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\matriz.png");
        */
        
        /*
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
        */
        
        /*
        ArbolB a = new ArbolB();
        a.addN(new Cliente("1111111111101", "", ""));
        a.addN(new Cliente("1111111111102", "", ""));
        a.addN(new Cliente("1111111111103", "", ""));
        a.addN(new Cliente("1111111111104", "", ""));
        a.addN(new Cliente("1111111111105", "", ""));
        a.addN(new Cliente("1111111111106", "", ""));
        a.addN(new Cliente("1111111111107", "", ""));
        a.addN(new Cliente("1111111111108", "", ""));
        a.addN(new Cliente("1111111111109", "", ""));
        a.addN(new Cliente("1111111111110", "", ""));
        a.addN(new Cliente("1111111111111", "", ""));
        a.addN(new Cliente("1111111111112", "", ""));
        a.addN(new Cliente("1111111111113", "", ""));
        a.addN(new Cliente("1111111111114", "", ""));
        a.addN(new Cliente("1111111111115", "", ""));
        a.addN(new Cliente("1111111111116", "", ""));
        a.addN(new Cliente("1111111111117", "", ""));
        
        a.search("1111111111117", a.raiz);
       
        a.dibujar("C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\AB.txt", "C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\AB.png");
        */
        
        //Comparacion de Clientes
        /*
        Cliente a1 = new Cliente("3005409730100", "Pedro", "hola");
        Cliente a2 = new Cliente("3005409730101", "Pedro", "hola");
        
        if(a1.comparar(a2.dpi) == 1){
            System.out.println("Es mayor");
        }else{
            if(a1.comparar(a2.dpi) == -1){
                System.out.println("Es menor");
            }else{
                System.out.println("Es igual");
            }
            
        }
        */
        
        //Prueba de lista simple
        ListaDCircularL a = new ListaDCircularL();
        ListaSimple a1 = new ListaSimple();
        a1.add(1, "1");
        a1.add(1, "2");
        a1.add(1, "3");
        
        ListaSimple a2 = new ListaSimple();
        a2.add(1, "1");
        a2.add(1, "2");
        a2.add(1, "3");
        a2.add(1, "4");
        
        ListaSimple a3 = new ListaSimple();
        a3.add(1, "1");
        a3.add(1, "2");
        a3.add(1, "3");
        a3.add(1, "5");
        
        a.add(a1, "Album 1", null);
        a.add(a2, "Album 2", null);
        a.add(a3, "Album 3", null);
        
        ListaSimple p = (ListaSimple) a.head.structure;
        p.borrar("1");
        //a1.dibujar("C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\Ls.txt", "C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\Ls.png");
        
        a.dibujar("C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\LC.txt", "C:\\Users\\lapto\\Documents\\Ingenieria\\Estructuras\\Ejemplos\\LC.png");
        
}
    
}
