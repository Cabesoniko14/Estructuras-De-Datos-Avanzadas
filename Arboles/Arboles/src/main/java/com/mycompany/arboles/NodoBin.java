/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arboles;

/**
 *
 * @author javi
 */
public class NodoBin <T>{
    public T elem;
    NodoBin<T> izq;
    NodoBin<T> der;
    
    public NodoBin(T dato){
        elem = dato;
        izq = null;
        der = null;
    }
    
    public NodoBin<T> getDer(){
        return der;
    }
    
    public NodoBin<T> getIzq(){
        return izq;
    
    }
    
    public void setIzq(NodoBin<T> actual){
        izq = actual;
    }
    
    public void setDer(NodoBin<T> actual){
        der = actual;
    }
    
    
    
    
    
}
