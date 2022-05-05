/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author JJONK19
 */
public class NodoHash implements Serializable {
    public Mensajero content;
    public int key;
    public String ID;          //ID del nodo. Tiene uso en el gráfico.
    
    public NodoHash(Mensajero _content, int _key){
        content = _content;
        key = _key;
        ID = "\""+UUID.randomUUID().toString() + "\"";
    }
    
}
