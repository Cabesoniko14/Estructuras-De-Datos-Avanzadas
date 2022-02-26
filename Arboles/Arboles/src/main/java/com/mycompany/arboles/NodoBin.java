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
public class NodoBin <T extends Comparable<T>>{
    public T elem;
    NodoBin<T> izq;
    NodoBin<T> der;
    NodoBin<T> papa;
    
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

    public T getElem() {
        return elem;
    }
    
    public void setElem(T elemento){
        elem = elemento;
    }
    
    
    public void setIzq(NodoBin<T> actual){
        izq = actual;
    }
    
    public void setDer(NodoBin<T> actual){
        der = actual;
    }
    
    public void cuelga(NodoBin<T> actual){
        if (actual == null)
            return;
        if (actual.getElem().compareTo(elem) <= 0)
            izq = actual;
        else
            der = actual;
        actual.setPapa(this);
    
    }
    
    public NodoBin<T> getPapa(){
      return papa;
    }
    
    public void setPapa(NodoBin<T> actual){
        papa=actual;
    }
    
    
    
    
}
