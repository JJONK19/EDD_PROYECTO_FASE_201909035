/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.udrawing_paper;

/**
 *
 * @author JJONK19
 */
public class Cliente {
    String ID; //Identificador del Cliente
    String nombre; //Nombre del cliente
    int color; //Número de imagenes a color
    int bn; //Número de imagenes en blanco y negro
    int pasos; //Numero de pasos en el sistema
    String ventana; //Nombre de la ventanilla que lo atendió
    int total; //Total de imagenes que posee un cliente
    
    public Cliente(String _id, String _nombre, int _color, int _bn){
        this.ID = _id;
        this.nombre = _nombre;
        this.color = _color;
        this.bn = _bn;
        this.pasos = 0;
        this.total = _color + _bn;
    }
}
