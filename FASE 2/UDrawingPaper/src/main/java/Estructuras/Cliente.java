/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.math.BigInteger;

/**
 *
 * @author JJONK19
 */
public class Cliente {
    String dpi;
    String nombre;
    String password;
 
    public Cliente(String Dpi, String Nombre, String Pass){
        dpi = Dpi;
        nombre = Nombre;
        password = Pass;
    }
    
    //Compara si el dpi es mayor 
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
}
