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
    
    //Compara si el dpi es mayor 
    // 1 = mayor
    // 0 = igual
    // -1 = menor
    public int comparar(String dpi2){
        int salida = -1;
        for(int i = 0; i < dpi.length(); i++){
            int c1 = Character.getNumericValue(dpi.charAt(i));
            int c2 = Character.getNumericValue(dpi2.charAt(i));
            if(i == (dpi.length()-1)){
                if(c1 != c2){
                    if(c1 > c2){
                        salida = 1;
                        break;
                    }else{
                        if(c1 < c2){
                            salida = -1;
                            break;
                        }
                    }
                }else{
                    salida = 0;
                    break;
                }
            }else{
                if(c1 != c2){
                    if(c1 > c2){
                        salida = 1;
                        break;
                    }else{
                        salida = -1;
                        break;
                    }
                }
            }
            
        }
        return salida;
    }
    
    public String getName(){
        return nombre;
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
