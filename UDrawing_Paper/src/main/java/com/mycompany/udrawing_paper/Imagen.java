/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.udrawing_paper;

/**
 *
 * @author JJONK19
 */
public class Imagen {
    
    String ID; //ID del dueño. Sirve para ubicarla facilmente.
    String Nombre; //Nombre de la Imagen
    String Tipo; //Determina si es BN o Color
    
    public Imagen(String id, String nombre, String tipo){
        this.ID = id;
        this.Nombre = nombre;
        this.Tipo = tipo;
    }
    
}
