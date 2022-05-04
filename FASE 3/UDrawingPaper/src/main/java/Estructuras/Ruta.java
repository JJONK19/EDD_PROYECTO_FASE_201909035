/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.Serializable;

/**
 *
 * @author JJONK19
 */
public class Ruta implements Serializable {
    int id ;
    int peso;
    
    public Ruta(int Id, int Peso){
        id = Id;
        peso = Peso;
    }
    
    public int getID(){
        return id;
    }
}
