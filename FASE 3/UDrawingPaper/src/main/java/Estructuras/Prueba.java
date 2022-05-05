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
        
     TablaHash a = new TablaHash();
     Mensajero a1 = new Mensajero("3005409730101", "Hola", "Mundo", "A", "F", "Africa", "30164091");
     a.add(a1);
     
     a.dibujar("src/main/java/Imagenes/Hash.txt", "src/main/java/Imagenes/Hash.png");
    }
    
}
