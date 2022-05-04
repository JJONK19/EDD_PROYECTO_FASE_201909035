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
    public String ID; //UUID Graphviz
    
    public Ruta(int Id, int Peso, String _ID){
        id = Id;
        peso = Peso;
        ID = _ID;
    }
    
    public int getID(){
        return id;
    }
}
