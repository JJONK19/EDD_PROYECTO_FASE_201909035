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
public class Imagen implements Serializable {
     public int id; //ID de la imagen
     public ArbolABB capas; //Arbol de capas de la imagen
     
     public Imagen(int _id, ArbolABB content){
         id = _id;
         capas = content;
     }
}
