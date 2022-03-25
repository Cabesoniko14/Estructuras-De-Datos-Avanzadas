/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboles;

/**
 *
 * @author javi
 */
public class NodoBB<T extends Comparable<T>>{
    T elem;
    NodoBB<T> izq, der,papa;

    public NodoBB (T dato){
    
        elem = dato;
        izq = null;
        der = null;
        papa=null;
    }


   public void setDer (NodoBB<T> actual){
        der = actual;
    }
    public void setIzq (NodoBB<T> actual){
        izq = actual;
    }
    public NodoBB<T> getDer(){
      return der;
    }
    public NodoBB<T> getIzq(){
      return izq;
    }
    public T getElem(){
        return elem;
    }
    public NodoBB<T> getPapa(){
      return papa;
    }
    public void setPapa(NodoBB<T> actual){
    papa=actual;
    }
    public void setElem(T elemento){
      elem=elemento;
    } 
    public void cuelga(NodoBB<T> actual){ // le agregas el nodo actual y 
      if (actual==null)
        return;
      if(actual.getElem().compareTo(elem)<=0)
        izq=actual;
      else
        der=actual; 
      actual.setPapa(this);
    }
    
    
    
    


  
}