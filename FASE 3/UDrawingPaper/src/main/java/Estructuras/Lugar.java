/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author JJONK19
 */
public class Lugar {
    int id ;
    String departamento;
    String nombre;
    boolean sucursal;
    
    public Lugar(int Id, String Depto, String Nombre, boolean Sucursal){
        id = Id;
        departamento = Depto;
        nombre = Nombre;
        sucursal = Sucursal;
    }
    
    public int getID(){
        return id;
    }
    
}
