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
public class Capa implements Serializable {
    public int id;
    public Object content;
    
    public Capa(int _id, Object _content){
        id = _id;
        content = _content;
    }
}
