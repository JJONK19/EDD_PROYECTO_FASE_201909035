/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author JJONK19
 */
public class Cola {
    NodoCola head; //Cabecera de la cola
    public int no; //Numero de nodos de la cola
    
    public Cola(){
        this.head = null;
    }
    
    //Metodos de la cola 
    //--------------------------------------------------------------------------
    public void enqueue(Object _content){
        NodoCola temp = new NodoCola (_content);
        if(isEmpty()){
            head = temp;
            no++;
        }else{
            NodoCola r = head;
            while(r.next != null){
                r = r.next;
            }
            r.next = temp;
            no++;
        }
    }
    
    public Object dequeue(){
        Object contenido = head.content;
        NodoCola temp = head.next;
        head = temp;
        no--;
        return contenido;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
    
    //Vacia la lista
    public void deleteL(){
        this.head = null;
        this.no =0;
    }
}
