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
public class Cliente implements Serializable {
    String dpi; 
    String nombre; 
    String user; 
    String correo;  
    String password; 
    String tel;
    String dir;
    String municipio;
    
 
    public Cliente(String Dpi, String Nombre, String User, String Correo, String Pass, String Tel, String Dir, String Municipio){
        dpi = Dpi;
        nombre = Nombre;
        user = User;
        correo = Correo;
        password = Pass;
        tel = Tel;
        dir = Dir;
        municipio = Municipio;
    }
    
    public String getName(){
        return nombre;
    }
    
    public String getUser(){
        return user;
    }
    
    public String getDPI(){
        return dpi;
    }
    
    public String getPass(){
        return password;
    }
    
    public void setName(String a){
        nombre = a;
    }
    
    public void setPass(String a){
        password = a;
    }
    
}
