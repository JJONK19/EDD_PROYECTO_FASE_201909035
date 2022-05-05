/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author JJONK19
 */
public class Mensajero implements Serializable{
    BigInteger dpi;
    public String nombre;
    public String apellido;
    public String licencia;
    String genero;
    public String tel;
    String dir;
    
    public Mensajero(String DPI, String _nombre, String _apellido, String _licencia, String _genero, String _dir){
        dpi = new BigInteger(DPI);
        nombre = _nombre;
        apellido = _apellido;
        licencia = _licencia;
        genero = _genero;
        dir = _dir;
    }
}
